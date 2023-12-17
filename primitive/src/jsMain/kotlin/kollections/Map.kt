@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")

package kollections

import kotlinx.JsName

@JsName("Map")
actual external interface Map<K,out V> {
    val size: Int
    fun get(key: K): V?
}

actual val <K,V> Map<K,V>.size get() = size

actual operator fun <K, V> Map<K, V>.get(key: K): V? = get(key)