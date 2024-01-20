@file:JsExport
@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kollections.internal.LinearlyTraversableStackImpl
import kotlinx.JsExport

inline fun <E> traversableStackOf(): LinearlyTraversableStack<E> = LinearlyTraversableStackImpl()