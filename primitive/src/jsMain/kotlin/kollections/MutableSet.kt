@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")
package kollections

import kollections.serializers.MutableSetSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(MutableSetSerializer::class)
@JsName("Set")
actual external interface MutableSet<T> : Set<T> {
    fun add(item: T): Int

    fun clear()
}

actual inline fun <T> MutableSet<T>.add(item: T) {
    add(item)
}

actual inline fun <T> MutableSet<T>.addAll(vararg items: T) {
    for (item in items) add(item)
}

actual inline fun <T> MutableSet<T>.addAll(items: Set<T>) {
    for (item in items) add(item)
}

actual inline fun <T> MutableSet<T>.addAll(iterable: Iterable<T>) {
    for (item in iterable) add(item)
}