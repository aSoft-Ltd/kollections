package kollections

expect interface Set<out T> : Collection<T>


expect val <T> Set<T>.size: Int


expect operator fun <T> Set<T>.iterator(): Iterator<T>

expect inline fun <reified T> Set<T>.toTypedArray() : Array<T>