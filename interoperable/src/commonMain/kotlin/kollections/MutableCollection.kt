@file:JsExport

package kollections

import kotlin.js.JsExport
import kotlin.js.JsName
import kotlin.collections.MutableCollection as KMutableCollection

interface MutableCollection<E> : KMutableCollection<E>, Collection<E> {

    override fun add(element: E): Boolean
    override fun clear()

    override fun remove(element: E): Boolean
}