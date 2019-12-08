fun solve(data: List<Int>, counter: Int): List<Int> =
  with(parseInstruction(data[counter])) {
    val updatedData = executeMutable(data, counter)
    val c = counter + opCode.parameterCount + 1
    return if (updatedData[c] != 99) solve(updatedData, c)
    else updatedData
  }

fun main() = timeAndSolve(::solve)