package kollections

inline fun <reified T> buildFlock(builder: MutableFlock<T>.() -> Unit): Flock<T> = mutableFlockOf<T>().apply(builder) as Flock<T> // Fails to compile if you remove this cast

inline fun <T, reified R> Flock<T>.map(transform: (T) -> R): Flock<R> = buildFlock { for (item in this@map) add(transform(item)) }

inline fun <T, reified R> Flock<T>.flatMap(transform: (T) -> Flock<R>): Flock<R> = buildFlock { for (item in this@flatMap) addAll(transform(item)) }