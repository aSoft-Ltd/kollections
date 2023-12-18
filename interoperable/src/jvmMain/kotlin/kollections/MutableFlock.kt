@file:Suppress("ACTUAL_WITHOUT_EXPECT", "NOTHING_TO_INLINE", "EXTENSION_SHADOWED_BY_MEMBER","ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

import kotlin.collections.MutableList

actual typealias MutableFlock<T> = MutableList<T>

actual inline fun <T> MutableFlock<T>.add(item: T) {
    add(element = item)
}

actual inline fun <T> MutableFlock<T>.addAll(vararg items: T) {
    addAll(items)
}

actual inline fun <T> MutableFlock<T>.addAll(items: Flock<T>) {
    addAll(items)
}