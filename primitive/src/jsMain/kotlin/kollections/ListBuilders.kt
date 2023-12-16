@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List as KList

actual inline fun <reified T> listOf(): List<T> = arrayOf<T>().unsafeCast<List<T>>() // js("[]")

actual inline fun <reified T> listOf(vararg items: T): List<T> = items.unsafeCast<List<T>>()

actual inline fun <reified T> mutableListOf(): MutableList<T> = arrayOf<T>().unsafeCast<MutableList<T>>() // js("[]")

actual inline fun <reified T> mutableListOf(vararg items: T): MutableList<T> = items.unsafeCast<MutableList<T>>()

actual inline fun <reified T> KList<T>.toList(): List<T> = buildList { for (item in this@toList) add(item) }

fun <T> List<T>.toKList(): KList<T> = kotlin.collections.listOf(*unsafeCast<Array<T>>())

fun <T> KList<T>.intoList(): MutableList<T> {
    val list = arrayOf<T>().unsafeCast<MutableList<T>>()
    list.addAll(list)
    return list
}