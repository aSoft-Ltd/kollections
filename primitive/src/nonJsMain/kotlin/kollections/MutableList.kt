@file:Suppress("NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER")

package kollections

import kotlin.jvm.JvmName
import kotlin.collections.addAll as kAddAll
import kotlin.collections.plus as kPlus
import kotlin.collections.minus as kMinus
import kotlin.collections.removeAll as kRemoveAll

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

actual inline fun <T> MutableList<T>.addAll(items: Iterable<T>) {
    kAddAll(items)
}

@JvmName("addArray")
actual inline fun <T> MutableList<T>.addAll(items: Array<T>) {
    kAddAll(items)
}

actual inline operator fun <T> MutableList<T>.plus(item: T) {
    kPlus(item)
}

actual inline operator fun <T> MutableList<T>.plus(items: Iterable<T>) {
    kPlus(items)
}

actual inline fun <T> MutableList<T>.remove(item: T): T? = if (remove(item)) item else null

actual inline fun <T> MutableList<T>.removeAll(items: Iterable<T>) {
    kRemoveAll(items)
}

actual inline operator fun <T> MutableList<T>.minus(item: T) {
    kMinus(item)
}