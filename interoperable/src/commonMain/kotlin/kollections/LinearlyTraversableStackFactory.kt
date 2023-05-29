@file:JsExport
@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kollections.internal.LinearlyTraversableStackImpl

inline fun <E> traversableStackOf(): LinearlyTraversableStack<E> = LinearlyTraversableStackImpl()