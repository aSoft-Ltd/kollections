package kollections

expect interface List<out T> : Collection<T>


expect val <T> List<T>.size: Int

expect operator fun <T> List<T>.get(index: Int): T

expect fun <T> List<T>.indexOf(item: T) : Int

expect operator fun <T> List<T>.iterator(): Iterator<T>

expect inline fun <reified T> List<T>.toTypedArray(): Array<T>