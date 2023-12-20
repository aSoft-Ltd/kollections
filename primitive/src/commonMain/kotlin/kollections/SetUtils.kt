package kollections

operator fun <T> Set<T>.plus(item: T): Set<T> = buildSet {
    addAll(this@plus)
    add(item)
}

operator fun <T> Set<T>.plus(items: Iterable<T>): Set<T> = buildSet {
    addAll(this@plus)
    addAll(items)
}

operator fun <T> Set<T>.minus(item: T): Set<T> = buildSet {
    this@minus.forEach { if (it != item) add(it) }
}

operator fun <T> Set<T>.minus(items: Iterable<T>): Set<T> = buildSet {
    this@minus.forEach { if(!items.contains(it)) add(it) }
}