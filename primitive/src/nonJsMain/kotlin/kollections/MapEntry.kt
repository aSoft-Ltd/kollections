@file:Suppress("ACTUAL_TYPE_ALIAS_TO_CLASS_WITH_DECLARATION_SITE_VARIANCE")

package kollections

actual typealias MapEntry<K, V> = kotlin.collections.Map.Entry<K, V>

actual inline val <K, V> MapEntry<K, V>.key get() = key
actual inline val <K, V> MapEntry<K, V>.value get() = value