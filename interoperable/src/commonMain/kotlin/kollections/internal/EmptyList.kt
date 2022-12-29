package kollections.internal

import kotlin.collections.List as KList
import kotlin.collections.emptyList as kEmptyList
import kollections.List

@PublishedApi
internal object EmptyList : AbstractCollection<Nothing>(), List<Nothing>, KList<Nothing> by kEmptyList() {
    override fun toString(): String = "[]"
}