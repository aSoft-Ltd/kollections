@file:Suppress(
    "ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING",
    "ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_SUPERTYPES_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING"
)

package kollections

import kollections.serializers.ListSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(ListSerializer::class)
@JsName("Array")
actual external interface List<out T> : Collection<T> {
    val length: Int
    fun at(index: Int): T?

    fun indexOf(item: @UnsafeVariance T): Int

    fun filter(predicate: (item: T) -> Boolean): List<T>
}

actual val <T> List<T>.size get() = length

actual operator fun <T> List<T>.get(index: Int): T = at(index) ?: throw IndexOutOfBoundsException()

actual inline fun <T> List<T>.indexOf(item: T) = indexOf(item)

actual operator fun <T> List<T>.iterator(): Iterator<T> = unsafeCast<Array<T>>().iterator()

actual inline fun <reified T> List<T>.toTypedArray() = unsafeCast<Array<T>>()