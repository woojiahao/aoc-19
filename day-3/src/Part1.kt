import Direction.*
import kotlin.math.abs
import kotlin.system.measureTimeMillis

val o = 0 to 0

fun manhattanDistance(i: Point) = abs(o.x - i.x) + abs(o.y - i.y)

fun move(pos: Point, t: Travel) =
  when (t.direction) {
    L -> (pos.x downTo (pos.x - t.distance)).map { it to pos.y }
    R -> (pos.x..(pos.x + t.distance)).map { it to pos.y }
    U -> (pos.y..(pos.y + t.distance)).map { pos.x to it }
    D -> (pos.y downTo (pos.y - t.distance)).map { pos.x to it }
  }

fun path(t: List<Travel>): List<Point> {
  var cur = o.copy()
  return t.map {
    with(move(cur, it)) {
      cur = last()
      this
    }
  }.flatten()
}

fun intersections(t1: List<Travel>, t2: List<Travel>) = path(t1).intersect(path(t2)).toList()

fun solve(t1: List<Travel>, t2: List<Travel>) = intersections(t1, t2).map { manhattanDistance(it) }.min()!!

fun main() {
  val (t1, t2) = data()
  val timeTaken = measureTimeMillis {
    println(solve(t1, t2))
  }
  println(timeTaken)
}