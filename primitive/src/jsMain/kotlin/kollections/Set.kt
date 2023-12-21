@file:Suppress(
    "ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING",
    "ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_SUPERTYPES_AS_NON_FINAL_EXPECT_CLASSIFIER_WARNING"
)

package kollections

import kollections.serializers.SetSerializer
import kotlinx.JsName
import kotlinx.serialization.Serializable

@Serializable(SetSerializer::class)
@JsName("Set")
actual external interface Set<out T> : Collection<T> {
    val size: Int
}

actual val <T> Set<T>.size get() = size

actual operator fun <T> Set<T>.iterator(): Iterator<T> = toList().iterator()

actual inline fun <reified T> Set<T>.toTypedArray() = toList().unsafeCast<Array<T>>()