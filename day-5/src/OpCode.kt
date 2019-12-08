import OpCode.*

enum class OpCode(val code: Int, val parameterCount: Int) {
  ADD(1, 3),
  MULTIPLY(2, 3),
  INPUT(3, 1),
  OUTPUT(4, 1),
  HALT(99, 0);

  companion object {
    fun retrieve(value: Int) = values().firstOrNull { it.code == value }
      ?: throw IllegalArgumentException("Invalid OpCode")
  }
}

enum class ParameterMode {
  POSITION,
  IMMEDIATE;

  fun get(data: List<Int>, index: Int) =
    when (this) {
      POSITION -> data[data[index]]
      IMMEDIATE -> data[index]
    }
}

/**
 * [parameters] are in order
 */
class Instruction(val opCode: OpCode, private vararg val parameters: ParameterMode) {
  fun executeMutable(data: List<Int>, counter: Int): List<Int> {
    val (aPos, bPos, cPos) = Triple(counter + 1, counter + 2, counter + 3)
    val (p1, p2, p3) = Triple(parameters[0], parameters[1], parameters[2])

    return data.toMutableList().apply {
      when (opCode) {
        ADD, MULTIPLY -> {
          val (a, b, c) = Triple(p1.get(this, aPos), p2.get(this, bPos), data[cPos])
          val value = when (opCode) {
            ADD -> a + b
            MULTIPLY -> a * b
            else -> throw Exception("Invalid op code")
          }
          set(c, value)
        }
        INPUT -> {
          print("Enter some input: ")
          val input = readLine()!!.split(' ')[0].toInt()
          set(data[aPos], input)
        }
        OUTPUT -> println(p1.get(this, aPos))
        HALT -> throw Exception("Halting should not execute")
      }
    }.toList()
  }
}

fun parseInstruction(instruction: Int) =
  with(instruction.toString().padStart(5, '0')) {
    val opCode = OpCode.retrieve(substring(4).toInt())
    val parameters = substring(0, 3)
      .reversed()
      .map { ParameterMode.values()[it.toString().toInt()] }
      .toTypedArray()
    Instruction(opCode, *parameters)
  }
