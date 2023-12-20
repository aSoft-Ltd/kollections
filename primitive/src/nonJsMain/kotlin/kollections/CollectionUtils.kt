package kollections

import kotlin.collections.flatMap as kFlatMap
import kotlin.collections.isNotEmpty as kIsNotEmpty
import kotlin.collections.isNullOrEmpty as kIsNullOrEmpty
import kotlin.collections.map as kMap

actual inline fun <T> Collection<T>.isEmpty() : Boolean = isEmpty()
actual inline fun <T> Collection<T>.isNotEmpty() = kIsNotEmpty()

actual inline fun <T> Collection<T>?.isNullOrEmpty() = kIsNullOrEmpty()

actual inline val <T> Collection<T>.size get() = size

actual inline fun <T, R> Collection<T>.map(noinline fn: (T) -> R): List<R> = kMap(fn)

actual inline fun <T, R> Collection<T>.flatMap(fn: (T) -> Iterable<R>): List<R> = kFlatMap(fn)