package kollections

expect interface Flock<out T>


expect val <T> Flock<T>.size: Int

expect operator fun <T> Flock<T>.get(index: Int): T


expect operator fun <T> Flock<T>.iterator(): Iterator<T>