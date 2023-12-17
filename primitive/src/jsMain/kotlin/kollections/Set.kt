@file:Suppress("ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING")

package kollections

import kollections.serializers.SetSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(SetSerializer::class)
@JsName("Set")
actual external interface Set<out T> {
    val size: Int
    fun forEach(looper: (item: T) -> Unit)
}

actual val <T> Set<T>.size get() = size

actual fun <T> Set<T>.toList(): List<T> = buildList { this@toList.forEach { add(it) } }

actual operator fun <T> Set<T>.iterator(): Iterator<T> = toList().iterator()

actual inline fun <reified T> Set<T>.toTypedArray() = toList().unsafeCast<Array<T>>()