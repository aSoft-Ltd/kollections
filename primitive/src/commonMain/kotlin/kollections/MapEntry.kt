package kollections

expect interface MapEntry<out K, out V>

expect val <K,V> MapEntry<K,V>.key: K

expect val <K,V> MapEntry<K,V>.value: V