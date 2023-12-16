@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")
package kollections

import kollections.serializers.MutableListSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(MutableListSerializer::class)
@JsName("Array")
actual external interface MutableList<T> : List<T> {
    fun push(item: T): Int
}

actual inline fun <T> MutableList<T>.add(item: T) {
    push(item)
}

actual inline fun <T> MutableList<T>.addAll(vararg items: T) {
    for (item in items) push(item)
}

actual inline fun <T> MutableList<T>.addAll(items: List<T>) {
    for (item in items) push(item)
}

actual inline fun <T> MutableList<T>.addAll(iterable: Iterable<T>) {
    for (item in iterable) push(item)
}