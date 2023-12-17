package kollections

inline fun <T> buildList(builder: MutableList<T>.() -> Unit): List<T> = mutableListOf<T>().apply(builder) as List<T> // Fails to compile in K1 if you remove this cast

inline fun <T, R> List<T>.map(transform: (T) -> R): List<R> = buildList { for (item in this@map) add(transform(item)) }

inline fun <T, R> List<T>.flatMap(transform: (T) -> List<R>): List<R> = buildList { for (item in this@flatMap) addAll(transform(item)) }