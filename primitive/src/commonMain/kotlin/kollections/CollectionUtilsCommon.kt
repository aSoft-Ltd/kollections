package kollections

inline fun <E> Collection<E>.dropLast(n: Int): List<E> = take(size - n)