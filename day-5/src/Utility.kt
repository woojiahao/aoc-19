import java.io.File
import kotlin.system.measureTimeMillis

fun data() = File("data.txt").readLines()[0].split(",").map { it.toInt() }

fun timeAndSolve(solve: (List<Int>, Int) -> List<Int>) {
  val time = measureTimeMillis {
    solve(data(), 0)
  }
  println("Time taken: $time")
}
