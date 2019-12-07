import kotlin.system.measureTimeMillis

const val lower = 284639
const val upper = 748759

fun timeAndAnswer(method: (Int, Int) -> Int) {
  val answer = method(lower, upper)
  println("Answer: $answer")

  val time = measureTimeMillis {
    method(lower, upper)
  }
  println("Time taken: $time")
}
