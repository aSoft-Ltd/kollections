package kollections

expect fun <T> Collection<T>.isEmpty() : Boolean
expect fun <T> Collection<T>.isNotEmpty() : Boolean
expect fun <T> Collection<T>?.isNullOrEmpty() : Boolean

expect val <T> Collection<T>.size : Int

expect fun <T, R> Collection<T>.map(fn: (T) -> R): List<R>

expect fun <T, R> Collection<T>.flatMap(fn: (T) -> Iterable<R>): List<R>