@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.MutableList
import kollections.toMutableList
import kollections.toKList
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class MutableListSerializer<T>(serializer: KSerializer<T>) : KSerializer<MutableList<T>> {
    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.MutableList",
        kind = StructureKind.LIST,
    )

    private val surrogate = ListSerializer(serializer)

    override fun deserialize(decoder: Decoder): MutableList<T> = surrogate.deserialize(decoder).toMutableList()

    override fun serialize(encoder: Encoder, value: MutableList<T>) = surrogate.serialize(encoder, value.toKList())
}