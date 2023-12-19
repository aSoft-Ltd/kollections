package kollections

actual inline fun <T> Collection<T>.isEmpty() = asDynamic().length == 0 || asDynamic().size == 0

actual inline fun <T> Collection<T>.isNotEmpty() = !isEmpty()

actual inline val <T> Collection<T>.size: Int
    get() {
        val l: Int? = asDynamic().length
        if (l != null) return l
        val s: Int? = asDynamic().size
        if (s != null) return s
        throw IllegalArgumentException("Are you sure this is a collection bruv")
    }