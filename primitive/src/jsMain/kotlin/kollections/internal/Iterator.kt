package kollections.internal

external interface Iterator<out T> {
    fun next(): IteratorResult<T>
}