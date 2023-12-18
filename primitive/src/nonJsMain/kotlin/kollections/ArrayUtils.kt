package kollections

import kotlin.collections.map as kMap
import kotlin.collections.mapIndexed as kMapIndexed
import kotlin.collections.associate as kAssociate
import kotlin.collections.toList as kToList
actual inline fun <T, R> Array<out T>.map(fn: (item: T) -> R): List<R> = kMap(fn)

actual inline fun <T, R> Array<out T>.mapIndexed(fn: (index: Int, item: T) -> R): List<R> = kMapIndexed(fn)

actual inline fun <T, K, V> Array<out T>.associate(fn: (item: T) -> Pair<K, V>): Map<K, V> = kAssociate(fn)

actual inline fun <T> Array<T>.toList() : List<T> = kToList()