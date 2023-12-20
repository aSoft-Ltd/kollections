@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")

package kollections

import kotlinx.JsName

@JsName("Map")
actual external interface Map<K, out V> {
    val size: Int

    fun get(key: K): V?

    fun entries(): Iterable<MapEntry<K, V>>

    fun keys(): Iterable<K>

    fun values(): Iterable<V>

    fun has(key: K): Boolean
    fun forEach(fn: (value: V, key: K) -> Unit)
}

actual inline val <K, V> Map<K, V>.size get() = size

actual inline val <K, V> Map<K, V>.keys get() = keys().toSet()
actual inline val <K, V> Map<K, V>.values: Collection<V> get() = values().toList()

actual inline val <K, V> Map<K, V>.entries: Set<MapEntry<K, V>> get() = entries().toSet()

actual inline operator fun <K, V> Map<K, V>.get(key: K): V? = get(key)

actual inline fun <K, V> Map<K, V>.containsKey(key: K) = has(key)

actual inline fun <K, V> Map<K, V>.getValue(key: K): V = get(key) ?: throw NoSuchElementException("Element was with key $key was not found")