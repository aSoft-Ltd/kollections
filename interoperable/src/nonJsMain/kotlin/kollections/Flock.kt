@file:Suppress("ACTUAL_WITHOUT_EXPECT", "EXTENSION_SHADOWED_BY_MEMBER")

package kollections

actual typealias Flock<T> = java.util.List<T>

actual val <T> Flock<T>.size get() = size

actual operator fun <T> Flock<T>.get(index: Int) : T = get(index)

actual operator fun <T> Flock<T>.iterator(): Iterator<T> = iterator()