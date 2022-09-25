import expect.expect
import kollections.chainOf
import kotlin.test.Test
import kotlin.test.assertEquals

class ChainTest {
    @Test
    fun chainOf_should_return_an_empty_array() {
        val c1 = chainOf<Int>()
        val c2 = chainOf<Int>()

        val a1 = arrayOf<Int>()
        val s1 = setOf<Int>()
        println(c1.equals(c2))
        assertEquals(c1, c2)
    }

    data class Pet(val name: String)
    data class PersonL(
        val name: String = "John L Doe",
        val pets: List<Pet> = listOf()
    )

    data class PersonA(
        val name: String = "John A Doe",
        val pets: Array<Pet> = arrayOf()
    )

    @Test
    fun array_data_class_equality() {
        expect(PersonA()).toBe(PersonA())
    }

    @Test
    fun list_data_class_equality() {
        expect(PersonL()).toBe(PersonL())
    }
}