@file:JsExport

package kollections

interface LinearlyTraversable<out E> {
    fun current(): E?
    fun forward(): E?
    fun back(): E?
    fun go(steps: Int): E?
}