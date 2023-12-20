package kollections

actual external interface Iterable<out T> {
    fun forEach(fn: (item: T) -> Unit)

    fun toArray() : List<T>
}