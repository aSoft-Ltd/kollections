package kollections

import kotlinx.serialization.KSerializer

actual inline fun <T> ListSerializer(element: KSerializer<T>) : KSerializer<List<T>> = kotlinx.serialization.builtins.ListSerializer(element)

actual inline fun <T> SetSerializer(element: KSerializer<T>) : KSerializer<Set<T>> = kotlinx.serialization.builtins.SetSerializer(element)