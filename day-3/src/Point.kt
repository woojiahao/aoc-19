data class Point(val x: Int, val y: Int)

infix fun Int.to(y: Int) = Point(this, y)