import kotlin.system.measureTimeMillis

fun total(path: List<Point>, p: Point) = with(path) { subList(0, indexOf(p) + 1).size }

fun solve2(t1: List<Travel>, t2: List<Travel>) =
  dualWith(path(t1), path(t2)) { p1, p2 ->
    intersections(p1, p2)
      .map { total(p1, it) + total(p2, it) }
      .min()!!
  }

fun main() {
  val (t1, t2) = data()
  println("Answer: ${solve2(t1, t2)}")

  val rawTime = measureTimeMillis {
    println(solve2(t1, t2))
  }
  println("Raw time: $rawTime")

  val p1 = path(t1)
  val p2 = path(t2)
  val betterTime = measureTimeMillis {
    intersections(p1, p2).map { total(p1, it) + total(p2, it) }.min()!!
  }
  println("Better time: $betterTime")
}
