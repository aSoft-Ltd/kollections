package kollections

fun <E, R> Array<E>.flatMap(transform: (E) -> Iterable<R>): List<R> = buildList {
    this@flatMap.forEach { addAll(transform(it)) }
}