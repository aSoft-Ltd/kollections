package kollections.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encoding.Decoder
import kollections.toIMutableList
import kollections.MutableList
import kollections.List
import kollections.internal.MutableListWrapper

class ListSerializer<E>(
    elementSerializer: KSerializer<E>
) : CollectionSerializer<E, List<E>>(elementSerializer), KSerializer<List<E>> {
    override fun deserialize(decoder: Decoder): List<E> = MutableListWrapper(decoder.decodeSerializableValue(ListSerializer(elementSerializer)).toMutableList())
}

internal class MutableListSerializer<E>(elementSerializer: KSerializer<E>) : CollectionSerializer<E, MutableList<E>>(elementSerializer) {
    override fun deserialize(decoder: Decoder): MutableList<E> = decoder.decodeSerializableValue(ListSerializer(elementSerializer)).toIMutableList()
}