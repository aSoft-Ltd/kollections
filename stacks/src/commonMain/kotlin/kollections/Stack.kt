@file:JsExport

package kollections

import kotlinx.JsExport

interface Stack<E> : kotlin.collections.Collection<E> {
    fun top(): E?
    fun push(element: E)
    fun pop(): E?
    fun canPop(): Boolean

    fun toList(): List<E>
}