fun hasRepeating(i: Int): Boolean = i.toString().zipWithNext { a, b -> a.toInt() == b.toInt() }.any { it }

fun isAscending(i: Int) = i.toString().zipWithNext { a, b -> a <= b }.all { it }

fun validate(i: Int) = hasRepeating(i) && isAscending(i)

fun solve(lower: Int, upper: Int) = (lower..upper).filter { validate(it) }.size

fun main() {
  println(solve(lower, upper))
}