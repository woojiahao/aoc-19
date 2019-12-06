import java.io.File

fun data() =
  with(File("data.txt").readLines()) {
    Pair(readTravel(this[0]), readTravel(this[1]))
  }

fun <U, V, R> dualWith(first: U, second: V, body: (U, V) -> R) = body(first, second)