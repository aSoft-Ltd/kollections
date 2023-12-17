@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.Set
import kollections.toKSet
import kollections.toSet
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class SetSerializer<T>(serializer: KSerializer<T>) : KSerializer<Set<T>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.Set",
        kind = StructureKind.LIST,
    )

    private val surrogate = SetSerializer(serializer)

    override fun deserialize(decoder: Decoder): Set<T> = surrogate.deserialize(decoder).toSet()

    override fun serialize(encoder: Encoder, value: Set<T>) = surrogate.serialize(encoder, value.toKSet())
}