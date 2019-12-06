enum class Direction { L, R, U, D }

data class Travel(val direction: Direction, val distance: Int)

fun readTravel(input: String, delimiter: String = ",") = input.split(delimiter).map { parseToTravel(it) }

fun parseToTravel(input: String) = Travel(Direction.valueOf(input[0].toString()), input.substring(1).toInt())