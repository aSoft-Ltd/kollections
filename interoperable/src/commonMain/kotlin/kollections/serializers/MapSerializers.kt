package kollections.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.Map
import kollections.MutableMap
import kollections.internal.MutableMapWrapper
import kotlinx.serialization.builtins.MapSerializer as KMapSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.mapSerialDescriptor
import kotlinx.serialization.encoding.Encoder

internal class MapSerializer<K, V>(
    keySerializer: KSerializer<K>,
    valueSerializer: KSerializer<V>
) : MapLikeSerializer<K, V, Map<K, V>>(keySerializer, valueSerializer) {
    override fun deserialize(decoder: Decoder): Map<K, V> {
        val kmap = decoder.decodeSerializableValue(surrogateSerializer)
        return MutableMapWrapper(kmap.toMutableMap())
    }
}

internal class MutableMapSerializer<K, V>(
    keySerializer: KSerializer<K>,
    valueSerializer: KSerializer<V>
) : MapLikeSerializer<K, V, MutableMap<K, V>>(keySerializer, valueSerializer) {
    override fun deserialize(decoder: Decoder): MutableMap<K, V> {
        val kmap = decoder.decodeSerializableValue(surrogateSerializer)
        return MutableMapWrapper(kmap.toMutableMap())
    }
}

internal abstract class MapLikeSerializer<K, V, M : Map<K, V>>(keySerializer: KSerializer<K>, valueSerializer: KSerializer<V>) : KSerializer<M> {
    val surrogateSerializer = KMapSerializer(keySerializer, valueSerializer)
    override val descriptor: SerialDescriptor = mapSerialDescriptor(keySerializer.descriptor, valueSerializer.descriptor)

    override fun serialize(encoder: Encoder, value: M) {
        encoder.encodeSerializableValue(surrogateSerializer, value)
    }
}
