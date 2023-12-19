package kollections

import kollections.Iterable
import kotlin.collections.find as kFind
import kotlin.collections.firstOrNull as kFirstOrNull
import kotlin.collections.forEach as kForEach
import kotlin.collections.forEachIndexed as kForEachIndexed
import kotlin.collections.associate as kAssociate
import kotlin.collections.toList as kToList
import kotlin.collections.toMutableList as kToMutableList
import kotlin.collections.toSet as kToSet
import kotlin.collections.toMutableSet as kToMutableSet
import kotlin.collections.joinToString as kJoinToString
import kotlin.collections.filterIsInstance as kFilterIsInstance
import kotlin.collections.reversed as kReversed
import kotlin.collections.all as kAll

actual inline fun <T> Iterable<T>.forEachIndexed(block: (index: Int, item: T) -> Unit) = kForEachIndexed(block)
actual inline fun <T> Iterable<T>.forEach(block: (item: T) -> Unit) = kForEach(block)
actual inline fun <T> Iterable<T>.firstOrNull(predicate: (item: T) -> Boolean): T? = kFirstOrNull(predicate)
actual inline fun <T> Iterable<T>.find(predicate: (item: T) -> Boolean): T? = kFind(predicate)
actual fun <T, K, V> Iterable<T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = kAssociate(fn)

actual fun <T> Iterable<T>.all(predicate: (item: T) -> Boolean): Boolean = kAll(predicate)

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