package kollections

fun <T> Iterable<T>.contains(item: T): Boolean = find { it == item } != null