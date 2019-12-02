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

fun changePure(data: List<Int>, noun: Int, verb: Int) =
  data.modify {
    set(1, noun)
    set(2, verb)
  }

fun solve2(data: List<Int>, change: (List<Int>, Int, Int) -> List<Int>, expected: Int): Pair<Int, Int> {
  for (noun in 0..99) {
    for (verb in 0..99) {
      if (solve(change(data, noun, verb), 0) == expected) return Pair(noun, verb)
    }
  }

  throw Exception("Failed to calculate a valid noun and verb")
}

fun time(data: List<Int>, change: (List<Int>, Int, Int) -> List<Int>, expected: Int): Long {
  val before = System.currentTimeMillis()
  solve2(data, change, expected)
  val after = System.currentTimeMillis()
  return after - before
}

fun main() {
  println(time(data, ::changeImmutable, 19690720))
  println(time(data, ::change, 19690720))
  println(time(data, ::changePure, 19690720))
}