package kollections.serializers

import kollections.toIMutableSet
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.MutableSet
import kollections.Set
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Encoder

@OptIn(InternalSerializationApi::class)
internal class MutableSetSerializer<E>(private val elementSerializer: KSerializer<E>) : KSerializer<MutableSet<E>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.MutableSet",
        kind = StructureKind.LIST
    )

    override fun serialize(encoder: Encoder, value: MutableSet<E>) {
        encoder.encodeSerializableValue(ListSerializer(elementSerializer), value.toList())
    }

    override fun deserialize(decoder: Decoder): MutableSet<E> = decoder.decodeSerializableValue(SetSerializer(elementSerializer)).toIMutableSet()
}