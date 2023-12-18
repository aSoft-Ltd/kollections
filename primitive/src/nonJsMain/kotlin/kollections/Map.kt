@file:Suppress("ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

actual typealias Map<K, V> = kotlin.collections.Map<K, V>

actual inline val <K, V> Map<K, V>.keys get() = keys

actual inline val <K, V> Map<K, V>.values: Collection<V> get() = values

actual inline val <K,V> Map<K,V>.entries get() = entries

actual inline val <K, V> Map<K, V>.size get() = size

actual inline operator fun <K, V> Map<K, V>.get(key: K): V? = get(key)

actual inline fun <K, V> Map<K, V>.getValue(key: K): V = get(key) ?: throw NoSuchElementException("Element with key $key was not found")