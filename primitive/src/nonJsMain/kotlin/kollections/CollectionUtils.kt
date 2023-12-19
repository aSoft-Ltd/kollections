package kollections

import kotlin.collections.isNotEmpty as kIsNotEmpty

actual inline fun <T> Collection<T>.isEmpty() : Boolean = isEmpty()
actual inline fun <T> Collection<T>.isNotEmpty() = kIsNotEmpty()
actual inline val <T> Collection<T>.size get() = size