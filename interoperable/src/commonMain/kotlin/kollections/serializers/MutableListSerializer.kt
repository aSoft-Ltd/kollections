@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kollections.MutableList
import kollections.toIMutableList

@Serializer(forClass = MutableList::class)
class MutableListSerializer<E>(private val elementSerializer: KSerializer<E>) : KSerializer<MutableList<E>> {

    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.MutableList",
        kind = StructureKind.LIST
    )

    override fun serialize(encoder: Encoder, value: MutableList<E>) {
        encoder.encodeSerializableValue(ListSerializer(elementSerializer), value)
    }

    override fun deserialize(decoder: Decoder): MutableList<E> = decoder.decodeSerializableValue(ListSerializer(elementSerializer)).toIMutableList()
}