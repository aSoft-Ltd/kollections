package kollections

inline fun <T> buildMutableSet(builder: MutableSet<T>.() -> Unit) = mutableSetOf<T>().apply(builder)
inline fun <T> buildSet(builder: MutableSet<T>.() -> Unit): Set<T> = buildMutableSet(builder) as Set<T> // Fails to compile in K1 if you remove this cast

inline fun <T, R> Set<T>.map(transform: (T) -> R): Set<R> = buildSet { for (item in this@map) add(transform(item)) }

inline fun <T, R> Set<T>.flatMap(transform: (T) -> Set<R>): Set<R> = buildSet { for (item in this@flatMap) addAll(transform(item)) }

//inline fun <T> List<T>.toSet(): Set<T> = buildSet { this@toSet.forEach { add(it) } }