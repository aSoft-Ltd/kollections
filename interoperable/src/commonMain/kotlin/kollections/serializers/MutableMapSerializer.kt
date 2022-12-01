@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kollections.MutableMap
import kollections.internal.MutableMapWrapper
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.mapSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.builtins.MapSerializer as KMapSerializer

@Serializer(forClass = MutableMap::class)
internal class MutableMapSerializer<K, V>(
    keySerializer: KSerializer<K>,
    valueSerializer: KSerializer<V>
) : KSerializer<MutableMap<K, V>> {
    private val surrogateSerializer = KMapSerializer(keySerializer, valueSerializer)

    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.MutableMap",
        kind = StructureKind.MAP
    )

    override fun serialize(encoder: Encoder, value: MutableMap<K, V>) {
        encoder.encodeSerializableValue(surrogateSerializer, value)
    }

    override fun deserialize(decoder: Decoder): MutableMap<K, V> {
        val kmap = decoder.decodeSerializableValue(surrogateSerializer)
        return MutableMapWrapper(kmap.toMutableMap())
    }
}