package kollections.serializers

import kollections.List
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

expect class ListSerializer<T>(serializer: KSerializer<T>) : KSerializer<List<T>> {
    override val descriptor: SerialDescriptor
    override fun deserialize(decoder: Decoder): List<T>
    override fun serialize(encoder: Encoder, value: List<T>)
}