@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package kollections

import kotlin.collections.addAll as kAddAll

actual typealias MutableList<T> = kotlin.collections.MutableList<T>

actual inline fun <T> MutableList<T>.add(item: T) {
    add(element = item)
}

actual inline fun <T> MutableList<T>.addAll(vararg items: T) {
    kAddAll(items)
}

actual inline fun <T> MutableList<T>.addAll(items: List<T>) {
    kAddAll(items)
}

actual inline fun <T> MutableList<T>.addAll(iterable: Iterable<T>) {
    kAddAll(iterable)
}