package kollections

expect interface MutableFlock<T> : Flock<T>

expect fun <T> MutableFlock<T>.add(item: T)

expect fun <T> MutableFlock<T>.addAll(vararg items: T)

expect fun <T> MutableFlock<T>.addAll(items: Flock<T>)