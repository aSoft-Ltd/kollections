package kollections

import kotlinx.serialization.KSerializer

actual inline fun <T> ListSerializer(element: KSerializer<T>) : KSerializer<List<T>> = kollections.serializers.ListSerializer(element)

actual inline fun <T> SetSerializer(element: KSerializer<T>) : KSerializer<Set<T>> = kollections.serializers.SetSerializer(element)