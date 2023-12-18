package kollections

expect fun <T, R> Array<out T>.map(fn: (item: T) -> R): List<R>

expect fun <T, R> Array<out T>.mapIndexed(fn: (index: Int, item: T) -> R): List<R>

expect fun <T, K, V> Array<out T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V>

expect fun <T> Array<T>.toList() : List<T>