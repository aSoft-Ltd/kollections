@file:Suppress("WRONG_JS_INTEROP_TYPE")
@file:JsExport

package kollections

import kotlin.collections.Iterable as KIterable
import kotlinx.JsExport

actual interface Iterable<out E> : KIterable<E> {

    fun toArray(): Array<out E>

    fun count(): Int
}