package kollections.internal

external interface IteratorResult<out T> {
    val value: @UnsafeVariance T
    val done: Boolean
}

inline fun <T> IteratorResult(value: T, done: Boolean = false): IteratorResult<T> = js("{ value, done }")
inline fun CompletedIteratorResult(): IteratorResult<Nothing> = js("{ done: false }")