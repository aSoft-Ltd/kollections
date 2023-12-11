package kollections

import kotlin.collections.List

expect inline fun <reified T> flockOf() : Flock<T>

expect inline fun <reified T> flockOf(vararg items: T) : Flock<T>

expect inline fun <reified T> mutableFlockOf() : MutableFlock<T>

expect inline fun <reified T> mutableFlockOf(vararg items: T) : MutableFlock<T>

expect inline fun <reified T> List<T>.toFlock(): Flock<T>