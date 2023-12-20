package kollections

inline operator fun <K,V> MapEntry<K,V>.component1() : K = key
inline operator fun <K,V> MapEntry<K,V>.component2() : V = value