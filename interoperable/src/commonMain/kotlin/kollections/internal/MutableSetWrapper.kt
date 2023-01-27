package kollections.internal

import kotlin.collections.MutableSet as KMutableSet
import kollections.MutableSet
import kotlin.js.JsName

@PublishedApi
@JsName("MutableSet")
internal open class MutableSetWrapper<E>(
    private val set: KMutableSet<E>
) : AbstractCollection<E>(), MutableSet<E>, KMutableSet<E> by set {

    override fun toString(): String = set.toString()

    override fun hashCode(): Int = set.hashCode()

    override fun equals(other: Any?): Boolean = set == other
}