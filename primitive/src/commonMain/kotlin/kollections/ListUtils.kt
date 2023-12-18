package kollections

operator fun <T> List<T>.plus(item: T): List<T> = buildList {
    addAll(this@plus)
    add(item)
}

operator fun <T> List<T>.plus(items: Iterable<T>): List<T> = buildList {
    addAll(this@plus)
    addAll(items)
}

operator fun <T> List<T>.minus(item: T): List<T> = buildList {
    this@minus.forEach { if (it != item) add(it) }
}

operator fun <T> List<T>.minus(items: Iterable<T>): List<T> = buildList {
    this@minus.forEach { if(!items.contains(it)) add(it) }
}

fun <T> List<T>.first(): T {
    if (size <= 0) throw NoSuchElementException("List is empty")
    return get(0)
}

fun <T> List<T>.firstOrNull(): T? = if (size <= 0) null else get(0)
fun <T> List<T>.last(): T {
    if (size <= 0) throw NoSuchElementException("List is empty")
    return get(size - 1)
}

fun <T> List<T>.lastOrNull(): T? = if (size <= 0) null else get(size - 1)

val <T> List<T>.indices get() = 0..<size

fun <T> List<T>.getOrNull(index: Int): T? = if (index >= size) null else get(index)