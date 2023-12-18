@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.Set as KSet
import kotlin.collections.buildSet as kBuildSet

actual inline fun <T> setOf(): Set<T> = js("new Set()")

actual inline fun <T> setOf(vararg items: T): Set<T> = js("new Set(items)")

actual inline fun <T> mutableSetOf(): MutableSet<T> = js("new Set()")

actual inline fun <T> mutableSetOf(vararg items: T): MutableSet<T> = js("new Set(items)")

actual inline fun <T> KSet<T>.toSet(): Set<T> = buildSet { for (item in this@toSet) add(item) }

fun <T> Set<T>.toKSet(): KSet<T> = kBuildSet(size) { this@toKSet.forEach { add(it) } }

fun <T> KSet<T>.intoSet(): MutableSet<T> = toSet().unsafeCast<MutableSet<T>>()