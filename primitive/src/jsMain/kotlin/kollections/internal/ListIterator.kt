package kollections.internal

import kollections.List
import kollections.get
import kollections.size

internal class ListIterator<out T>(private val list: List<T>) : Iterator<T> {
    private var index = 0
    override fun hasNext(): Boolean = index < list.size

    override fun next(): T {
        val item = list[index]
        index++
        return item
    }
}