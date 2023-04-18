package unit

import kommander.expect
import kollections.MutableList
import kollections.iMutableListOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Ignore
import kotlin.test.Test

class ListSerializationTest {
    @Serializable
    data class Person(
        val name: String, val friends: MutableList<Person>
    )

    val person = Person(
        name = "Anderson", friends = iMutableListOf(Person("Lameck", iMutableListOf()))
    )

    @Test
    fun should_obey_to_string_literals() {
        println(person)
    }

    @Test
    fun should_serialize_without_stating_a_serializer_explicitly() {
        println(Json.encodeToString(person))
    }

    @Test
    fun should_deserialize_from_json() {
        val p = Json.decodeFromString<Person>("""{"name":"Anderson","friends":[{"name":"Lameck","friends":[]}]}""")
        println(p)
        expect(p.name).toBe("Anderson")
    }

    @Ignore // doesn't work for custom serializers
    @Test
    fun serializing_things_is_tight() {
        val zer = serializer<List<Int>>()
        println(zer)
    }
}