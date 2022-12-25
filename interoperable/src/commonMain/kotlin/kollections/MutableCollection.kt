@file:JsExport

package kollections

import kotlin.collections.MutableCollection as KMutableCollection
import kotlin.js.JsExport

interface MutableCollection<E> : KMutableCollection<E>, Collection<E> {

    override fun add(element: E): Boolean
    override fun clear()

    override fun remove(element: E): Boolean
}