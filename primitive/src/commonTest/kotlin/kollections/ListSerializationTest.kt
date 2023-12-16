package kollections

import kommander.expect
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class ListSerializationTest {

    @Serializable
    class Person(val names: MutableList<String>)
    @Test
    fun should_be_able_to_serialize() {
        val person = Person(mutableListOf("Anderson","Lameck"))
        val codec = Json {  }
        expect(codec.encodeToString(person)).toBe("""{"names":["Anderson","Lameck"]}""")
    }
}