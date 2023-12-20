@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package kollections

import kotlin.collections.addAll as kAddAll
import kotlin.collections.plus as kPlus
import kotlin.collections.minus as kMinus
import kotlin.collections.removeAll as kRemoveAll

actual typealias MutableSet<T> = kotlin.collections.MutableSet<T>

actual inline fun <T> MutableSet<T>.add(item: T) {
    add(element = item)
}

actual inline fun <T> MutableSet<T>.addAll(vararg items: T) {
    kAddAll(items)
}

actual inline fun <T> MutableSet<T>.addAll(items: Set<T>) {
    kAddAll(items)
}

actual inline fun <T> MutableSet<T>.addAll(items: Iterable<T>) {
    kAddAll(items)
}

actual inline operator fun <T> MutableSet<T>.plus(item: T) {
    kPlus(item)
}

actual inline operator fun <T> MutableSet<T>.plus(items: Iterable<T>) {
    kPlus(items)
}

actual inline fun <T> MutableSet<T>.remove(item: T): T? = if (remove(item)) item else null

actual inline fun <T> MutableSet<T>.removeAll(items: Iterable<T>) {
    kRemoveAll(items)
}

actual inline operator fun <T> MutableSet<T>.minus(item: T) {
    kMinus(item)
}