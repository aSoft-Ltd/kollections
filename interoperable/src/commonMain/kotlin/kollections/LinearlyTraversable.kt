@file:JsExport

package kollections

interface LinearlyTraversable<out E> {
    fun forward(): E?
    fun back(): E?
    fun go(steps: Int): E?
}