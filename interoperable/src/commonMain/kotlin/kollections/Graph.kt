@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package kollections

import kotlin.js.JsExport

interface Graph<out N, out E> : Collection<N> {
    fun isConnected(node1: @UnsafeVariance N, node2: @UnsafeVariance N): Boolean

    fun edge(from: @UnsafeVariance N, to: @UnsafeVariance N): E?

    fun loops(): List<Set<N>>

    fun uniqueLoops(): List<Set<N>>

    fun paths(from: @UnsafeVariance N, to: @UnsafeVariance N): List<Set<N>>

    fun hasPath(from: @UnsafeVariance N, to: @UnsafeVariance N): Boolean
}