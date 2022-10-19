import kollections.iMutableListOf
import kotlin.test.Test
import kotlin.test.assertNotEquals

class ArrayInteroperabilityTest {
    data class Company(val name: String)

    @Test
    fun should_easily_convert_a_list_to_an_array() {
        val list = iMutableListOf(Company("google"), Company("asoft"))
        val array1 = list.toArray()
        list[0] = Company("netflix")
        println(list)
        println(array1)
        println("\n\n")
        val array2 = list.toArray()
        println(list)
        println(array2)
        assertNotEquals(array2, array1)
    }
}