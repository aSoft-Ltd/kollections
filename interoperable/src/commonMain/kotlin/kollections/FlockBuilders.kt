package kollections

import kotlin.collections.List

expect inline fun <T> flockOf() : Flock<T>

expect inline fun <T> flockOf(vararg items: T) : Flock<T>

expect inline fun <T> mutableFlockOf() : MutableFlock<T>

expect inline fun <T> mutableFlockOf(vararg items: T) : MutableFlock<T>

expect inline fun <T> List<T>.toFlock(): Flock<T>