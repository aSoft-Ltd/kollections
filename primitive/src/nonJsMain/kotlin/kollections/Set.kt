@file:Suppress("EXTENSION_SHADOWED_BY_MEMBER", "ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

import kotlin.collections.toList as kToList
import kotlin.collections.toTypedArray as kToTypedArray

actual typealias Set<T> = kotlin.collections.Set<T>

actual val <T> Set<T>.size get() = size

actual fun <T> Set<T>.toList() : List<T> = kToList()

actual operator fun <T> Set<T>.iterator(): Iterator<T> = iterator()

actual inline fun <reified T> Set<T>.toTypedArray() = kToTypedArray()