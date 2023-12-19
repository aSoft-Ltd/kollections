@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.MutableSet
import kollections.toMutableSet
import kollections.toKSet
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class MutableSetSerializer<T>(serializer: KSerializer<T>) : KSerializer<MutableSet<T>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.MutableSet",
        kind = StructureKind.LIST,
    )

    private val surrogate = SetSerializer(serializer)

    override fun deserialize(decoder: Decoder): MutableSet<T> = surrogate.deserialize(decoder).toMutableSet()

    override fun serialize(encoder: Encoder, value: MutableSet<T>) = surrogate.serialize(encoder, value.toKSet())
}