package kollections.serializers

import kollections.toIMutableSet
import kotlinx.serialization.KSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.MutableSet
import kollections.Set

internal class SetSerializer<E>(elementSerializer: KSerializer<E>) : CollectionSerializer<E, Set<E>>(elementSerializer) {
    override fun deserialize(decoder: Decoder): Set<E> = decoder.decodeSerializableValue(SetSerializer(elementSerializer))
}

internal class MutableSetSerializer<E>(elementSerializer: KSerializer<E>) : CollectionSerializer<E, MutableSet<E>>(elementSerializer) {
    override fun deserialize(decoder: Decoder): MutableSet<E> = decoder.decodeSerializableValue(SetSerializer(elementSerializer)).toIMutableSet()
}