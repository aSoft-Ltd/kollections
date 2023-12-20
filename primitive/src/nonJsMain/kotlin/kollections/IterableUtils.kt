package kollections

import kotlin.collections.sortByDescending
import kotlin.collections.sortedBy
import kotlin.collections.find as kFind
import kotlin.collections.first as kFirst
import kotlin.collections.firstOrNull as kFirstOrNull
import kotlin.collections.last as kLast
import kotlin.collections.lastOrNull as kLastOrNull
import kotlin.collections.forEach as kForEach
import kotlin.collections.forEachIndexed as kForEachIndexed
import kotlin.collections.associate as kAssociate
import kotlin.collections.associateWith as kAssociateWith
import kotlin.collections.associateBy as kAssociateBy
import kotlin.collections.toList as kToList
import kotlin.collections.toMutableList as kToMutableList
import kotlin.collections.toSet as kToSet
import kotlin.collections.toMutableSet as kToMutableSet
import kotlin.collections.joinToString as kJoinToString
import kotlin.collections.filterIsInstance as kFilterIsInstance
import kotlin.collections.reversed as kReversed
import kotlin.collections.all as kAll
import kotlin.collections.any as kAny
import kotlin.collections.chunked as kChunked
import kotlin.collections.filter as kFilter
import kotlin.collections.sortedByDescending as kSortedByDescending
import kotlin.collections.sortedBy as kSortedBy

actual inline fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit) = kForEachIndexed(block)
actual inline fun <T> Iterable<T>.forEach(block: (item: T) -> Unit) = kForEach(block)
actual inline fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T? = kFind(predicate)
actual inline fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = kAssociate(fn)

actual inline fun <T,V> Iterable<T>.associateWith(fn: (item: T) -> V): Map<T, V> = kAssociateWith(fn)
actual inline fun <K, T> Iterable<T>.associateBy(fn: (item: T) -> K): Map<K, T> = kAssociateBy(fn)


actual fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean = kAll(predicate)

actual fun <T> Iterable<T>.any(predicate: (item: T) -> Boolean): Boolean = kAny(predicate)

actual fun <T> Iterable<T>.joinToString(
    separator: CharSequence,
    prefix: CharSequence,
    postfix: CharSequence,
    limit: Int,
    truncated: CharSequence,
    transform: ((T) -> CharSequence)?
): String = kJoinToString(separator, prefix, postfix, limit, truncated, transform)

actual inline fun <reified R> Iterable<*>.filterIsInstance(): List<R> = kFilterIsInstance<R>()

actual inline fun <T> Iterable<T>.toList(): List<T> = kToList()

actual inline fun <T> Iterable<T>.toMutableList(): MutableList<T> = kToMutableList()

actual inline fun <T> Iterable<T>.toSet(): Set<T> = kToSet()
actual inline fun <T> Iterable<T>.toMutableSet(): MutableSet<T> = kToMutableSet()

actual inline fun <T> Iterable<T>.reversed() : List<T> = kReversed()

actual inline fun <T> Iterable<T>.chunked(size: Int) : List<List<T>> = kChunked(size)

actual inline fun <T> Iterable<T>.first(): T = kFirst()

actual inline fun <T> Iterable<T>.firstOrNull(): T? = kFirstOrNull()

actual inline fun <T> Iterable<T>.first(predicate: (item: T) -> Boolean): T = kFirst(predicate)
actual inline fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T? = kFirstOrNull(predicate)

actual inline fun <T> Iterable<T>.last(): T = kLast()

actual inline fun <T> Iterable<T>.lastOrNull(): T? = kLastOrNull()

actual inline fun <T> Iterable<T>.last(predicate: (item: T) -> Boolean): T = kLast(predicate)
actual inline fun <T> Iterable<T>.lastOrNull(predicate: (item: T) -> Boolean): T? = kLast(predicate)
actual inline fun <T> Iterable<T>.filter(predicate: (item: T) -> Boolean) = kFilter(predicate)

actual inline fun <T, R : Comparable<R>> Iterable<T>.sortedBy(crossinline selector: (T) -> R?):List<T> = kSortedBy(selector)
actual inline fun <T, R : Comparable<R>> Iterable<T>.sortedByDescending(crossinline selector: (T) -> R?) = kSortedByDescending(selector)