package kollections

actual external interface Collection<out T> : Iterable<T> {
    fun forEach(runner: (item: T) -> Unit)
}