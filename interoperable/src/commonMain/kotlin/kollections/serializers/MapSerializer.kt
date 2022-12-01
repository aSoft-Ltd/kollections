@file:OptIn(InternalSerializationApi::class)

package kollections.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.Map
import kollections.MutableMap
import kollections.internal.MutableMapWrapper
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.Serializer
import kotlinx.serialization.builtins.MapSerializer as KMapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.descriptors.mapSerialDescriptor
import kotlinx.serialization.encoding.Encoder

@Serializer(forClass = Map::class)
internal class MapSerializer<K, V>(
    keySerializer: KSerializer<K>,
    valueSerializer: KSerializer<V>
) : KSerializer<Map<K, V>> {
    private val surrogateSerializer = KMapSerializer(keySerializer, valueSerializer)

    override val descriptor: SerialDescriptor = buildSerialDescriptor(
        serialName = "kollections.Map",
        kind = StructureKind.MAP
    )

    override fun serialize(encoder: Encoder, value: Map<K, V>) {
        encoder.encodeSerializableValue(surrogateSerializer, value)
    }

    override fun deserialize(decoder: Decoder): Map<K, V> {
        val kmap = decoder.decodeSerializableValue(surrogateSerializer)
        return MutableMapWrapper(kmap.toMutableMap())
    }
}