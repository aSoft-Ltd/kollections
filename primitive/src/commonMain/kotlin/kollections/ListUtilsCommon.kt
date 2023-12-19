package kollections

inline operator fun <T> List<T>.component1() = get(0)
inline operator fun <T> List<T>.component2() = get(1)