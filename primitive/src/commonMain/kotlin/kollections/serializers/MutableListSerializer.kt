package kollections.serializers

import kollections.MutableList
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

expect class MutableListSerializer<T>(serializer: KSerializer<T>) : KSerializer<MutableList<T>> {
    override val descriptor: SerialDescriptor
    override fun deserialize(decoder: Decoder): MutableList<T>
    override fun serialize(encoder: Encoder, value: MutableList<T>)
}