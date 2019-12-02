fun opCode(data: List<Int>, counter: Int) =
  data.modify {
    val opCode = data[counter]
    val a = data[data[counter + 1]]
    val b = data[data[counter + 2]]
    val c = data[counter + 3]
    removeAt(c)
    add(c, when (opCode) {
      1 -> a + b
      2 -> a * b
      else -> throw Exception("Cannot perform any operations in halting code")
    })
  }

fun solve(data: List<Int>, counter: Int): Int {
  val updatedData = opCode(data, counter)
  val c = counter + 4
  return if (data[c] != 99) solve(updatedData, c)
  else updatedData[0]
}

fun main() = println(solve(data, 0))
