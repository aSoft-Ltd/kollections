@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER", "ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

actual typealias List<T> = kotlin.collections.List<T>

actual val <T> List<T>.size get() = size

actual operator fun <T> List<T>.get(index: Int): T = get(index)

actual operator fun <T> List<T>.iterator(): Iterator<T> = iterator()