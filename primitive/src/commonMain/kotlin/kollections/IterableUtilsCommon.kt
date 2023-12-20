package kollections

import kotlin.collections.List as KList
import kotlin.collections.buildList as kBuildList
inline fun <T> Iterable<T>.contains(item: T): Boolean = find { it == item } != null

inline fun <T> Iterable<T>.toKList() : KList<T> = kBuildList { this@toKList.forEach { add(it) } }