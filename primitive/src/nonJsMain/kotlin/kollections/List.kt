@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER", "ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

import kotlin.collections.toTypedArray as kToTypedArray

actual typealias List<T> = kotlin.collections.List<@UnsafeVariance T>

actual inline val <T> List<T>.size get() = size

actual operator fun <T> List<T>.get(index: Int): T = get(index)

actual inline fun <T> List<T>.indexOf(item: T) = indexOf(item)
actual operator fun <T> List<T>.iterator(): Iterator<T> = iterator()

actual inline fun <reified T> List<T>.toTypedArray() = kToTypedArray()