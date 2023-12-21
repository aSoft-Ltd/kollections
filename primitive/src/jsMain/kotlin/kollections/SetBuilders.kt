@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List as KList
import kotlin.collections.Iterable as KIterable
import kotlin.collections.Set as KSet
import kotlin.collections.buildSet as kBuildSet

actual inline fun <T> emptySet(): Set<T> = js("new Set()")
actual inline fun <T> setOf(): Set<T> = js("new Set()")

actual inline fun <T> setOf(vararg items: T): Set<T> = js("new Set(items)")

actual inline fun <T> mutableSetOf(): MutableSet<T> = js("new Set()")

actual inline fun <T> mutableSetOf(vararg items: T): MutableSet<T> = js("new Set(items)")

actual inline fun <T> Iterable<T>.toSet(): Set<T> {
    if(isSet()) return asSet()
    val tmp = this
    return js("new Set(tmp)")
}

inline fun <T> KIterable<T>.copyToNewSet(): Set<T> = buildSet {
    this@copyToNewSet.forEach { add(it) }
}

actual inline fun <T> Iterable<T>.toMutableSet(): MutableSet<T> = toSet().unsafeCast<MutableSet<T>>()

actual inline fun <T> KSet<T>.toSet(): Set<T> = copyToNewSet()

actual inline fun <T> KList<T>.toSet(): Set<T> = copyToNewSet()

fun <T> Set<T>.toKSet(): KSet<T> = kBuildSet(size) { this@toKSet.forEach { add(it) } }

fun <T> KSet<T>.toMutableSet(): MutableSet<T> = toSet().unsafeCast<MutableSet<T>>()