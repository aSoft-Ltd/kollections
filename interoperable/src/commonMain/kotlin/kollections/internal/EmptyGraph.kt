package kollections.internal

import kollections.Graph

@PublishedApi
internal object EmptyGraph : AbstractCollection<Nothing>(), Graph<Nothing, Nothing> {
    override fun containsAll(elements: Collection<Nothing>): Boolean = false

    override fun isEmpty(): Boolean = true

    override val size: Int = 0

    override fun contains(element: Nothing): Boolean = false

    override fun iterator(): Iterator<Nothing> = emptyList<Nothing>().iterator()

}
