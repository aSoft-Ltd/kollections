@file:JsExport

package kollections

import kotlin.js.JsExport

interface MutableGraph<N, E> : MutableCollection<N>, Graph<N, E> {
    fun connect(from: N, to: N, with: E)
}