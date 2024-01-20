package kollections

inline fun <E> MutableList<E>.removeLastOrNull(): E? {
    val s = size
    if (s <= 0) return null
    return remove(getOrNull(s - 1) ?: return null)
}

inline fun <E> MutableList<E>.retainAll(items: Collection<E>) {
    val list = items.toList()
    forEach { if (list.indexOf(it) < 0) remove(it) }
}