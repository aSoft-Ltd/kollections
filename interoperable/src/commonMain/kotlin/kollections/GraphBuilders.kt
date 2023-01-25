@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kollections.internal.EmptyGraph
import kollections.internal.MutableGraphImpl
import kotlin.js.JsExport
import kotlin.js.JsName

@JsName("emptyMutableGraph")
fun <N, E> iMutableGraphOf(): MutableGraph<N, E> = MutableGraphImpl()

@JsName("mutableGraphOf")
fun <N, E> iMutableGraphOf(vararg elements: N): MutableGraph<N, E> = MutableGraphImpl(*elements)

@JsName("emptyGraph")
fun <N, E> iEmptyGraph(): Graph<N, E> = EmptyGraph

@JsName("graphOf")
fun <N, E> graphOf(vararg elements: N): Graph<N, E> = MutableGraphImpl(*elements)