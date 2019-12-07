fun pairInput(i: Int, predicate: (Int, Int) -> Boolean) =
  i.toString().zipWithNext { a, b -> predicate(a.toInt(), b.toInt()) }

fun hasRepeating(i: Int) = pairInput(i) { a, b -> a == b }.any { it }

fun isAscending(i: Int) = pairInput(i) { a, b -> a <= b }.all { it }

fun validate(i: Int) = hasRepeating(i) && isAscending(i)

fun solve(lower: Int, upper: Int) = (lower..upper).filter { validate(it) }.size

fun main() = timeAndAnswer(::solve)
