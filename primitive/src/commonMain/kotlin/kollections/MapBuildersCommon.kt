package kollections

inline fun <K,V> buildMap(builder: MutableMap<K,V>.() -> Unit): Map<K,V> = mutableMapOf<K,V>().apply(builder) as Map<K, V> // Fails to compile in K1 if you remove this cast