package kollections

actual inline fun <T> Collection<T>.isEmpty() = asDynamic().length == 0 || asDynamic().size == 0

actual inline fun <T> Collection<T>.isNotEmpty() = !isEmpty()
