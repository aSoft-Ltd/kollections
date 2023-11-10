@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER")

package kollections

@JsName("Array")
actual external interface Flock<out T> {

    val length: Int
    fun at(index: Int): T?
}

actual val <T> Flock<T>.size get() = length

actual operator fun <T> Flock<T>.get(index: Int): T = at(index) ?: throw IndexOutOfBoundsException()

actual operator fun <T> Flock<T>.iterator(): Iterator<T> = (this as Array<T>).iterator()