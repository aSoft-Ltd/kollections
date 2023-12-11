@file:Suppress("NOTHING_TO_INLINE")

package kollections

import kotlin.collections.List

actual inline fun <reified T> flockOf(): Flock<T> = arrayOf<T>() as Flock<T> // js("[]")

actual inline fun <reified T> flockOf(vararg items: T): Flock<T> = items as Flock<T>

actual inline fun <reified T> mutableFlockOf(): MutableFlock<T> = arrayOf<T>() as MutableFlock<T> // js("[]")

actual inline fun <reified T> mutableFlockOf(vararg items: T): MutableFlock<T> = items as MutableFlock<T>

actual inline fun <reified T> List<T>.toFlock(): Flock<T> = buildFlock { for (item in this@toFlock) add(item) }