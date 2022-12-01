@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.toIMutableList
import kollections.MutableList
import kollections.List
import kollections.internal.MutableListWrapper
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = List::class)
class ListSerializer<E>(private val elementSerializer: KSerializer<E>) : KSerializer<List<E>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.List",
        kind = StructureKind.LIST
    )

    override fun serialize(encoder: Encoder, value: List<E>) {
        encoder.encodeSerializableValue(ListSerializer(elementSerializer), value.toList())
    }

    override fun deserialize(decoder: Decoder): List<E> = MutableListWrapper(decoder.decodeSerializableValue(ListSerializer(elementSerializer)).toMutableList())
}

