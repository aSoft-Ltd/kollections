package kollections

import kotlinx.serialization.KSerializer

expect inline fun <T> ListSerializer(element: KSerializer<T>) : KSerializer<List<T>>

expect inline fun <T> SetSerializer(element: KSerializer<T>) : KSerializer<Set<T>>