@file:Suppress("ACTUAL_WITHOUT_EXPECT", "EXTENSION_SHADOWED_BY_MEMBER", "ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

actual typealias Flock<T> = kotlin.collections.List<T>

actual val <T> Flock<T>.size get() = size

actual operator fun <T> Flock<T>.get(index: Int): T = get(index)

actual operator fun <T> Flock<T>.iterator(): Iterator<T> = iterator()