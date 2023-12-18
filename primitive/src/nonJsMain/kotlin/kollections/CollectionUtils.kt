package kollections

import kotlin.collections.isNotEmpty as kIsNotEmpty

actual inline fun <T> Collection<T>.isEmpty() : Boolean = isEmpty()
actual inline fun <T> Collection<T>.isNotEmpty() = kIsNotEmpty()

fun tmp() {
    val col = kotlin.collections.listOf(0) as kotlin.collections.Collection<Int>
    col.joinToString()
}