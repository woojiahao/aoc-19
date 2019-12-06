import kotlin.system.measureTimeMillis

fun total(path: List<Point>, p: Point) = with(path) { subList(0, indexOf(p) + 1).size }

fun solve2(t1: List<Travel>, t2: List<Travel>): Int {
  val p1 = path(t1)
  val p2 = path(t2)
  return intersections(p1, p2).map { total(p1, it) + total(p2, it) }.min()!!
}

fun main() {
  val (t1, t2) = data()
  val time = measureTimeMillis {
    println(solve2(t1, t2))
  }
  println(time)
}
