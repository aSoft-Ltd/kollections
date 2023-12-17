@file:Suppress("ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

actual typealias Map<K, V> = kotlin.collections.Map<K, V>

actual val <K, V> Map<K, V>.size get() = size

actual operator fun <K, V> Map<K, V>.get(key: K): V? = get(key)