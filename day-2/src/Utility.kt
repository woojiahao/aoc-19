fun <T> List<T>.modify(modification: MutableList<T>.() -> Unit) = toMutableList().apply(modification).toList()
