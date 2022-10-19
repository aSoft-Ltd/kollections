package kollections.internal

import kotlin.collections.Set as KSet
import kotlin.collections.emptySet as kEmptySet
import kollections.Set

@PublishedApi
internal object EmptySet : Set<Nothing>, KSet<Nothing> by kEmptySet() {
    override fun toString(): String = "[]"
}