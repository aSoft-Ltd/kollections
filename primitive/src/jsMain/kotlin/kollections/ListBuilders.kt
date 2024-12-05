@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List as KList
import kotlin.collections.Set as KSet
import kotlin.collections.Iterable as KIterable

actual inline fun <T> emptyList(): List<T> = arrayOf<T>().unsafeCast<List<T>>() // js("[]")

actual inline fun <T> listOf(): List<T> = arrayOf<T>().unsafeCast<List<T>>() // js("[]")

actual inline fun <T> listOf(vararg items: T): List<T> = items.unsafeCast<List<T>>()

actual inline fun <T> mutableListOf(): MutableList<T> = arrayOf<T>().unsafeCast<MutableList<T>>() // js("[]")

actual inline fun <T> mutableListOf(vararg items: T): MutableList<T> = items.unsafeCast<MutableList<T>>()

inline fun <T> Iterable<T>.copyToNewList() : MutableList<T> {
    val tmp = this
    return js("Array.from(tmp)")
}
actual inline fun <T> Iterable<T>.toList(): List<T> {
    if(isList()) return asList()
    return copyToNewList()
}

actual inline fun <T> Iterable<T>.toMutableList(): MutableList<T> = copyToNewList()

actual inline fun <T> KList<T>.toList(): List<T> = toIterable().toList()
actual inline fun <T> KSet<T>.toList(): List<T> = toIterable().toList()

fun <T> List<T>.toKList(): KList<T> = kotlin.collections.listOf(*unsafeCast<Array<T>>())

fun <T> KList<T>.toMutableList(): MutableList<T> = toList().unsafeCast<MutableList<T>>()




