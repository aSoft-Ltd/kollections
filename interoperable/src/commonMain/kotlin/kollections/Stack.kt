@file:JsExport

package kollections

interface Stack<E> : Collection<E> {
    fun top(): E?
    fun push(element: E)
    fun pop(): E?
    fun canPop(): Boolean
    fun toList() : List<E>
}