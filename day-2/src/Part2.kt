fun changeImmutable(data: List<Int>, noun: Int, verb: Int) =
  data.mapIndexed { index, value ->
    when (index) {
      1 -> noun
      2 -> verb
      else -> value
    }
  }

fun change(data: List<Int>, noun: Int, verb: Int) =
  data.modify {
    replace(1, noun)
    replace(2, verb)
  }

fun solve2(data: List<Int>, expected: Int): Pair<Int, Int> {
  for (noun in 0..99) {
    for (verb in 0..99) {
      if (solve(change(data, noun, verb), 0) == expected) return Pair(noun, verb)
    }
  }

  throw Exception("Failed to calculate a valid noun and verb")
}

fun main() {
  val before = System.currentTimeMillis()
  val (noun, verb) = solve2(data, 19690720)
  val after = System.currentTimeMillis()
  println(after - before)
  println(100 * noun + verb)
}