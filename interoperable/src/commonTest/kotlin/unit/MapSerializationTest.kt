package unit

import expect.expect
import kollections.MutableMap
import kollections.Map
import kollections.iMutableListOf
import kollections.iMutableMapOf
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.test.Ignore
import kotlin.test.Test
import kollections.pairOf

class MapSerializationTest {
    @Serializable
    data class Person(
        val name: String, val friends: Map<String, Person> = iMutableMapOf()
    )

    val person = Person(
        name = "Anderson", friends = iMutableMapOf(
            pairOf("One", Person("One")),
            pairOf("Two", Person("two"))
        )
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
        val p = Json.decodeFromString<Person>("""{"name":"Anderson","friends":{"One":{"name":"One"},"Two":{"name":"two"}}}""")
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