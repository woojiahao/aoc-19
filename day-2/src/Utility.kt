fun <T> List<T>.modify(modification: MutableList<T>.() -> Unit) = toMutableList().apply(modification).toList()

fun <T> MutableList<T>.replace(index: Int, value: T) = with(this) {
  removeAt(index)
  add(index, value)
}