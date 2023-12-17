@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package kollections

import kotlin.collections.addAll as kAddAll

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

actual inline fun <T> MutableSet<T>.addAll(iterable: Iterable<T>) {
    kAddAll(iterable)
}