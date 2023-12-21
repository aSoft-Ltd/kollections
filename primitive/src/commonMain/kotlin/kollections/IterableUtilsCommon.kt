package kollections

import kotlin.collections.List as KList
import kotlin.collections.buildList as kBuildList

inline fun <T> Iterable<T>.contains(item: T): Boolean = find { it == item } != null

inline fun <T> Iterable<T>.toKList(): KList<T> = kBuildList { this@toKList.forEach { add(it) } }

inline fun <T> Iterable<T>.partition(crossinline predicate: (item: T) -> Boolean): Pair<List<T>, List<T>> {
    val passed = mutableListOf<T>()
    val failed = mutableListOf<T>()
    forEach { (if (predicate(it)) passed else failed).add(it) }
    return passed to failed
}

inline fun <T, I : Iterable<T>> I.onEach(crossinline fn: (item: T) -> Unit): I {
    forEach { fn(it) }
    return this
}

inline fun <T> Iterable<T>.filterNotNull(): List<T & Any> = filter { it != null } as List<T & Any>

inline fun <T> Iterable<T>.reduce(crossinline reducer: (acc: T, item: T) -> T): T {
    var count = 0
    var reduced: T? = null
    forEach {
        val r = reduced
        if (r == null) {
            reduced = it
        } else {
            reduced = reducer(r, it)
        }
        count++
    }
    if (count == 0) throw NoSuchElementException("Collection is empty")
    return reduced as T
}