package kollections

import kommander.expect
import kotlin.test.Test

class LinearlyTraversableStackTest {

    @Test
    fun should_be_able_to_push_an_element_to_the_stack() {
        val stack = traversableStackOf<Int>()
        stack.push(0)
        expect(stack).toBeOfSize(1)
        expect(stack.first()).toBe(0)
        expect(stack.firstOrNull()).toBe(0)
    }

    @Test
    fun should_be_able_to_push_multiple_elements_to_the_stack() {
        val stack = traversableStackOf<Int>()
        stack.push(0)
        stack.push(1)
        stack.push(2)
        expect(stack).toBeOfSize(3)
        expect(stack.top()).toBe(2)
    }

    @Test
    fun should_be_able_to_pop_an_element_out_of_the_stack() {
        val stack = traversableStackOf<Int>()
        stack.push(0)
        stack.push(1)
        stack.push(2)
        val canPop = stack.canPop()
        expect(canPop).toBe(true)
        val element = stack.pop()
        expect(stack).toBeOfSize(2)
        expect(stack.top()).toBe(1)
        expect(element).toBe(2)
    }

    @Test
    fun should_be_able_to_traverse_the_stack_backward() {
        val stack = traversableStackOf<Int>()
        stack.push(0)
        stack.push(1)
        stack.push(2)
        val el = stack.back()
        expect(stack).toBeOfSize(3)
        expect(stack.top()).toBe(2)
        expect(el).toBe(1)
    }

    @Test
    fun should_be_able_to_traverse_the_stack_forward_after_it_has_been_traversed_backwards() {
        val stack = traversableStackOf<Int>()
        stack.push(0)
        stack.push(1)
        stack.push(2)
        stack.back()
        stack.back()
        val el = stack.forward()
        expect(stack).toBeOfSize(3)
        expect(stack.top()).toBe(2)
        expect(el).toBe(1)
    }

    @Test
    fun should_be_able_to_traverse_the_stack_multiple_steps_backwards() {
        val stack = traversableStackOf<Int>()
        repeat(10) { stack.push(it) }
        val el = stack.go(-5)
        expect(stack).toBeOfSize(10)
        expect(stack.top()).toBe(9)
        expect(el).toBe(4)
    }

    @Test
    fun should_be_able_to_traverse_the_stack_multiple_steps_forward() {
        val stack = traversableStackOf<Int>()
        repeat(10) { stack.push(it) }
        stack.go(-7)
        val el = stack.go(5)
        expect(stack).toBeOfSize(10)
        expect(stack.top()).toBe(9)
        expect(el).toBe(7)
    }

    @Test
    fun should_be_able_to_stand_in_position_when_told_to_zero_steps() {
        val stack = traversableStackOf<Int>()
        repeat(10) { stack.push(it) }
        val el = stack.go(0)
        expect(stack).toBeOfSize(10)
        expect(stack.top()).toBe(9)
        expect(el).toBe(9)
    }
}