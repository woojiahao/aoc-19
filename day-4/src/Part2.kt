fun hasValidRepeatGroup(i: Int) = i.toString().groupBy { it }.map { it.value.size == 2 }.any { it }

fun validate2(i: Int) = validate(i) && hasValidRepeatGroup(i)

fun solve2(lower: Int, upper: Int) = (lower..upper).filter { validate2(it) }.size

fun main() = timeAndAnswer(::solve2)