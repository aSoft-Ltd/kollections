package kollections

actual external interface MapEntry<out K, out V>

actual inline val <K,V> MapEntry<K,V>.key : K get() = asDynamic()[0]
actual inline val <K,V> MapEntry<K,V>.value : V get() = asDynamic()[1]