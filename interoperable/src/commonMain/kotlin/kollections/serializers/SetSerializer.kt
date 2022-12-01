@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.toIMutableSet
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.MutableSet
import kollections.Set
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = Set::class)
class SetSerializer<E>(private val elementSerializer: KSerializer<E>) : KSerializer<Set<E>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.Set",
        kind = StructureKind.LIST
    )

    override fun serialize(encoder: Encoder, value: Set<E>) {
        encoder.encodeSerializableValue(ListSerializer(elementSerializer), value.toList())
    }

    override fun deserialize(decoder: Decoder): Set<E> = decoder.decodeSerializableValue(SetSerializer(elementSerializer))
}