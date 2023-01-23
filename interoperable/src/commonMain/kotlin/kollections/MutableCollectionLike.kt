@file:JsExport

package kollections

import kotlin.collections.MutableCollection as KMutableCollection
import kotlin.js.JsExport

interface MutableCollectionLike<E> : KMutableCollection<E>, CollectionLike<E> {

    override fun add(element: E): Boolean

    override fun remove(element: E): Boolean

    override fun clear()
}