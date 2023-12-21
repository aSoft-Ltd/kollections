package kollections

import kotlin.collections.Map as KMap
inline fun <K,V> buildMap(builder: MutableMap<K,V>.() -> Unit): Map<K,V> = mutableMapOf<K,V>().apply(builder) as Map<K, V> // Fails to compile in K1 if you remove this cast

inline fun <K,V> Map<K,V>.filter(crossinline predicate: (MapEntry<K,V>) -> Boolean) : Map<K,V> = buildMap {
    this@filter.entries.forEach { if(predicate(it)) put(it.key,it.value) }
}

inline fun <K,V> Map<K,V>.filterKeys(crossinline predicate: (K) -> Boolean) : Map<K,V> = buildMap {
    this@filterKeys.entries.forEach { if(predicate(it.key)) put(it.key,it.value) }
}

inline fun <K,V> Map<K,V>.filterValues(crossinline predicate: (V) -> Boolean) : Map<K,V> = buildMap {
    this@filterValues.entries.forEach { if(predicate(it.value)) put(it.key,it.value) }
}

inline fun <K,V> KMap<K,V>.toMap() : Map<K,V> = buildMap {
    this@toMap.entries.forEach { put(it.key,it.value) }
}