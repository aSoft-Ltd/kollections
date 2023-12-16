@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.MutableList
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

actual class MutableListSerializer<T> actual constructor(serializer: KSerializer<T>) : KSerializer<MutableList<T>> {
    actual override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.List",
        kind = StructureKind.LIST,
    )

    private val surrogate = ListSerializer(serializer)

    actual override fun deserialize(decoder: Decoder): MutableList<T> = surrogate.deserialize(decoder).toMutableList()

    actual override fun serialize(encoder: Encoder, value: MutableList<T>) = surrogate.serialize(encoder, value)
}