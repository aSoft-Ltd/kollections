@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List

actual inline fun <T> flockOf(): Flock<T> = js("[]")

actual inline fun <T> flockOf(vararg items: T): Flock<T> = items as Flock<T>

actual inline fun <T> mutableFlockOf(): MutableFlock<T> = js("[]")

actual inline fun <T> mutableFlockOf(vararg items: T): MutableFlock<T> = items as MutableFlock<T>

actual inline fun <T> List<T>.toFlock(): Flock<T> = buildFlock { for (item in this@toFlock) add(item) }