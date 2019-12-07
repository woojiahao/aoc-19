package both

import timeAndAnswer

// Part 1
fun pairInput(i: Int, predicate: (Int, Int) -> Boolean) =
  i.toString().zipWithNext { a, b -> predicate(a.toInt(), b.toInt()) }

fun hasRepeating(i: Int) = pairInput(i) { a, b -> a == b }.any { it }

fun isAscending(i: Int) = pairInput(i) { a, b -> a <= b }.all { it }

fun validate(i: Int) = hasRepeating(i) && isAscending(i)

fun solve(lower: Int, upper: Int) = (lower..upper).filter { validate(it) }.size

// Part 2
fun hasValidRepeatGroup(i: Int) = i.toString().groupBy { it }.map { it.value.size == 2 }.any { it }

fun validate2(i: Int) = validate(i) && hasValidRepeatGroup(i)

fun solve2(lower: Int, upper: Int) = (lower..upper).filter { validate2(it) }.size

fun main() {
  timeAndAnswer(::solve)
  timeAndAnswer(::solve2)
}
