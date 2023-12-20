@file:OptIn(ExperimentalContracts::class)

package kollections

import kotlin.contracts.ExperimentalContracts

actual fun <T> Iterable<T>.forEach(block: (item: T) -> Unit) = forEach(block)

actual fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit) {
    var index = 0
    forEach { block(index++, it) }
}

actual fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T? = firstOrNull(predicate)

actual fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean = unsafeCast<Array<T>>().all(predicate)

actual fun <T> Iterable<T>.any(predicate: (item: T) -> Boolean): Boolean {
    var found = false
    forEach {
        found = predicate(it)
        if (found) return@forEach
    }
    return found
}

actual fun <T> Iterable<T>.joinToString(
    separator: CharSequence,
    prefix: CharSequence,
    postfix: CharSequence,
    limit: Int,
    truncated: CharSequence,
    transform: ((T) -> CharSequence)?
): String = unsafeCast<Array<T>>().joinToString(separator, prefix, postfix, limit, truncated, transform)

actual inline fun <reified R> Iterable<*>.filterIsInstance(): List<R> = buildList {
    this@filterIsInstance.forEach { if (it is R) push(it) }
}

inline fun <T> Iterable<T>.isList(): Boolean {
    val tmp = this
    return js("Array.isArray(tmp)") == true
}

inline fun <T> Iterable<T>.copyToNewList() : MutableList<T> {
    val tmp = this
    return js("Array.from(tmp)")
}

actual inline fun <T> Iterable<T>.toList(): List<T> {
    if(isList()) return unsafeCast<List<T>>()
    return copyToNewList()
}

actual inline fun <T> Iterable<T>.toMutableList(): MutableList<T> = copyToNewList()

actual fun <T> Iterable<T>.toMutableSet(): MutableSet<T> = toSet().unsafeCast<MutableSet<T>>()

actual inline fun <T> Iterable<T>.toSet(): Set<T> {
    val tmp = this
    return js("new Set(tmp)")
}

actual fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = buildMap {
    this@associate.toList().forEach {
        val (key, value) = fn(it)
        set(key, value)
    }
}

actual inline fun <T, V> Iterable<T>.associateWith(crossinline fn: (item: T) -> V): Map<T, V> = buildMap {
    this@associateWith.toList().forEach { set(it, fn(it)) }
}

actual inline fun <K, T> Iterable<T>.associateBy(crossinline fn: (item: T) -> K): Map<K, T> = buildMap {
    this@associateBy.toList().forEach { set(fn(it), it) }
}

actual fun <T> Iterable<T>.reversed(): List<T> = toList().unsafeCast<Array<T>>().reversed().unsafeCast<List<T>>()

actual inline fun <T> Iterable<T>.chunked(size: Int): List<List<T>> = toKList().chunked(size).map {
    it.toTypedArray()
}.toTypedArray().unsafeCast<List<List<T>>>()

actual inline fun <T> Iterable<T>.first(): T = first { true }

actual inline fun <T> Iterable<T>.firstOrNull(): T? = firstOrNull { true }

actual inline fun <T> Iterable<T>.first(noinline predicate: (item: T) -> Boolean): T = firstOrNull(predicate) ?: throw NoSuchElementException()
actual fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T? {
    var found: T? = null
    forEach {
        if (predicate(it)) {
            found = it
            return@forEach
        }
    }
    return found
}

actual inline fun <T> Iterable<T>.last(): T = last { true }

actual inline fun <T> Iterable<T>.lastOrNull(): T? = lastOrNull { true }

actual inline fun <T> Iterable<T>.last(noinline predicate: (item: T) -> Boolean): T = lastOrNull(predicate) ?: throw NoSuchElementException()

actual inline fun <T> Iterable<T>.lastOrNull(noinline predicate: (item: T) -> Boolean): T? {
    var found: T? = null
    forEach {
        if (predicate(it)) {
            found = it
        }
    }
    return found
}

actual inline fun <T> Iterable<T>.filter(noinline predicate: (item: T) -> Boolean): List<T> = toList().filter(predicate)

actual inline fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?): List<T> = toList().unsafeCast<Array<T>>().sortedBy(selector).toList()
actual inline fun <T, R : Comparable<R>> Iterable<T>.sortedByDescending(crossinline selector: (T) -> R?) = toList().unsafeCast<Array<T>>().sortedBy(selector).toList()