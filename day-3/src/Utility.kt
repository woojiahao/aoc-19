import java.io.File

fun data() =
  with(File("data.txt").readLines()) {
    Pair(readTravel(this[0]), readTravel(this[1]))
  }