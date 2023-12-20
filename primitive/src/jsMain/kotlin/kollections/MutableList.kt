@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")

package kollections

import kollections.serializers.MutableListSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(MutableListSerializer::class)
@JsName("Array")
actual external interface MutableList<T> : List<T> {
    override var length: Int
    fun push(item: T): Int
    fun splice(index: Int, deleteCount: Int, vararg items: T)
}

actual inline fun <T> MutableList<T>.add(item: T) {
    push(item)
}

actual inline fun <T> MutableList<T>.add(index: Int, item: T) {
    splice(index, 0, item)
}

actual inline fun <T> MutableList<T>.addAll(vararg items: T) {
    for (item in items) push(item)
}

actual inline fun <T> MutableList<T>.addAll(items: List<T>) {
    for (item in items) push(item)
}

actual inline fun <T> MutableList<T>.addAll(items: Iterable<T>) {
    items.forEach { push(it) }
}

actual inline fun <T> MutableList<T>.addAll(items: Array<T>) {
    items.forEach { push(it) }
}
actual fun <T> MutableList<T>.remove(item: T): T? {
    val idx = indexOf(item)
    if (idx <= 0) return null
    splice(idx, 1)
    return item
}

actual inline fun <T> MutableList<T>.removeAll(items: Iterable<T>) {
    items.forEach { remove(it) }
}

actual inline fun <T> MutableList<T>.clear() {
    length = 0
}