package kollections

import kotlin.collections.Collection as KCollection
import kollections.internal.MutableListWrapper
import kollections.internal.MutableMapWrapper
import kollections.internal.MutableSetWrapper
import kotlin.collections.Map as KMap

inline fun <E> KCollection<E>.toIMutableList(): MutableList<E> = MutableListWrapper(toMutableList())

inline fun <E> KCollection<E>.toIList(): List<E> = MutableListWrapper(toMutableList())

inline fun <E> KCollection<E>.toIMutableSet(): MutableSet<E> = MutableSetWrapper(toMutableSet())

inline fun <E> KCollection<E>.toISet(): Set<E> = MutableSetWrapper(toMutableSet())

inline fun <K, V> KMap<K, V>.toIMap(): Map<K, V> = MutableMapWrapper(toMutableMap())

inline fun <K, V> KMap<K, V>.toIMutableMap(): MutableMap<K, V> = MutableMapWrapper(toMutableMap())