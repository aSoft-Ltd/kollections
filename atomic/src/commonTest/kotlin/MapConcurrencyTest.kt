import kommander.*
import kollections.mutableAtomicMapOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import kotlin.test.Test

class MapConcurrencyTest {
    val numbers: MutableMap<String, Int> = mutableAtomicMapOf()

    @Test
    fun should_add_items_to_list() {
        numbers["one"] = 1
    }

    @Test
    fun should_add_items_in_different_threads() = runTest {
        val chars: MutableMap<String, Char> = mutableAtomicMapOf("A" to 'A')
        withContext(Dispatchers.Default) {
            chars["B"] = 'B'
        }
        withContext(Dispatchers.Unconfined) {
            chars["C"] = 'C'
        }
        expectCollection(chars.values).toContain('A', 'B', 'C')
    }

    @Test
    fun should_add_multiple_items_in_different_threads() = runTest {
        val chars: MutableMap<String, Char> = mutableAtomicMapOf("A" to 'A')
        withContext(Dispatchers.Default) {
            chars.putAll(listOf("B" to 'B'))
        }
        withContext(Dispatchers.Unconfined) {
            chars.putAll(listOf("C" to 'C'))
        }
        expectCollection(chars.values).toContain('A', 'B', 'C')
    }

    @Test
    fun should_remove_items_in_any_thread() = runTest {
        val chars: MutableMap<String, Char> = mutableAtomicMapOf("A" to 'A', "B" to 'B', "C" to 'C')
        withContext(Dispatchers.Default) {
            chars.remove("B")
        }
        withContext(Dispatchers.Unconfined) {
            chars.remove("C")
        }
        expectCollection(chars.values).toContain('A')
        expectCollection(chars.values).toBeOfSize(1)
    }
}