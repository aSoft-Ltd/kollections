@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List

actual inline fun <T> flockOf(): Flock<T> = listOf<T>() as Flock<T>

actual inline fun <T> flockOf(vararg items: T): Flock<T> = listOf(*items) as Flock<T>
actual inline fun <T> mutableFlockOf(): MutableFlock<T> = mutableListOf()

actual inline fun <T> mutableFlockOf(vararg items: T): MutableFlock<T> = mutableListOf(*items)
actual inline fun <T> List<T>.toFlock(): Flock<T> = this as Flock<T>