//import kommander.*
//import kollections.mutableAtomicListOf
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.withContext
//import kotlin.test.Test
//
//class ListConcurrencyTest {
//    val numbers: MutableList<Int> = mutableAtomicListOf(1)
//
//    @Test
//    fun should_add_items_to_list() {
//        numbers.add(1)
//    }
//
//    @Test
//    fun should_add_items_in_different_threads() = runTest {
//        val chars: MutableList<Char> = mutableAtomicListOf('A')
//        withContext(Dispatchers.Default) {
//            chars.add('B')
//        }
//        withContext(Dispatchers.Unconfined) {
//            chars.add('C')
//        }
//        expectCollection(chars).toContain('A', 'B', 'C')
//    }
//
//    @Test
//    fun should_add_multiple_items_in_different_threads() = runTest {
//        val chars: MutableList<Char> = mutableAtomicListOf('A')
//        withContext(Dispatchers.Default) {
//            chars.addAll(listOf('B'))
//        }
//        withContext(Dispatchers.Unconfined) {
//            chars.addAll(listOf('C'))
//        }
//        expectCollection(chars).toContain('A', 'B', 'C')
//    }
//
//    @Test
//    fun should_remove_items_in_any_thread() = runTest {
//        val chars: MutableList<Char> = mutableAtomicListOf('A', 'B', 'C')
//        withContext(Dispatchers.Default) {
//            chars.remove('B')
//        }
//        withContext(Dispatchers.Unconfined) {
//            chars.remove('C')
//        }
//        expectCollection(chars).toContain('A')
//    }
//}