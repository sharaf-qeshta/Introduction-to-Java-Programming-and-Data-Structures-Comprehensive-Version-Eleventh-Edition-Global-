package chapter_nineteen;

/**
 * 19.1 (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
 * it using an array rather than an ArrayList. You should check the array size
 * before adding a new element to the stack. If the array is full, create a new array that
 * doubles the current array size and copy the elements from the current array to the
 * new array.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01
{
    public static void main(String[] args)
    {
        GenericStack<Integer> stack = new GenericStack<>();
        System.out.println(stack.isEmpty()); // true
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(10);
        stack.push(11);

        System.out.println(stack.getSize()); // 13
        System.out.println(stack.isEmpty()); // false
        System.out.println(stack.peek()); // 11
        System.out.println(stack.pop()); // 11
        System.out.println(stack.peek()); // 10

        /* Stack: {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, } */
        System.out.println(stack);
    }
}
