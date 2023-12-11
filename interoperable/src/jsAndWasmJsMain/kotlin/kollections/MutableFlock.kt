@file:Suppress("ACTUAL_WITHOUT_EXPECT", "WRONG_JS_INTEROP_TYPE")

package kollections

import kotlinx.JsName

@JsName("Array")
actual external interface MutableFlock<T> : Flock<T> {
    fun push(item: T): Int
}

actual inline fun <T> MutableFlock<T>.add(item: T) {
    push(item)
}

actual inline fun <T> MutableFlock<T>.addAll(vararg items: T) {
    for (item in items) push(item)
}

actual inline fun <T> MutableFlock<T>.addAll(items: Flock<T>) {
    for (item in items) push(item)
}