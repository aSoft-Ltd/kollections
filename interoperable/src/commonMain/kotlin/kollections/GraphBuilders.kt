@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kollections.internal.DirectedGraphImpl
import kollections.internal.UndirectedGraphImpl
import kotlinx.JsExport
import kotlin.js.JsName

@JsName("undirectedGraph")
fun <N, E> undirectedGraphOf(vararg nodes: N): MutableGraph<N, E> = UndirectedGraphImpl(*nodes)

@JsName("directedGraphOf")
fun <N, E> directedGraphOf(vararg nodes: N): MutableGraph<N, E> = DirectedGraphImpl(*nodes)

inline fun <N, E> buildDirectedGraph(
    vararg nodes: N,
    builder: MutableGraph<N, E>.() -> Unit
): MutableGraph<N, E> = DirectedGraphImpl<N, E>().apply(builder)

@JsName("graphOf")
fun <N, E> graphOf(vararg nodes: N): Graph<N, E> = UndirectedGraphImpl(*nodes)