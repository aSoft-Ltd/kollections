package kollections.internal

import kollections.MutableList
import kollections.iMutableListOf

class Queue<E>(private val list: MutableList<E>) : AbstractCollection<E>(), MutableList<E> by list {
    constructor(vararg elms: E) : this(iMutableListOf(*elms))

    fun shift(): E? {
        val l = list.firstOrNull()
        list.remove(l)
        return l
    }
}