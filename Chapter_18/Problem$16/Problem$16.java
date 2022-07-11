package chapter_eighteen;

import java.util.Arrays;

/**
 * *18.16 Write a recursive method public static int pos(int[] a, int l,
 * int r) that positions a[l] at its rank if the array a were sorted between l and r,
 * and that returns this rank. That is, we assume that a is an unsorted array of int,
 * l and r are int such that 0 6= l 6= r 6 a.length, after this call : k = pos(a, l, r); a
 * contains the same elements before and after this call, but it is such that a[k] 7=
 * a[i] for all i in [l, k-1] and a[k] 6 a[j] for all j in [k+1, r].
 * For instance, consider this fragment:
 *
 *          int[] a = {8,7,4,1,9,6,2,5,3,0};
 *          System.out.println(Arrays.toString(a));
 *          // [8, 7, 4, 1, 9, 6, 2, 5, 3, 0]
 *          pos(a, 2, 7); // a[2..7] = {4, 1, 9, 6, 2, 5}
 *          System.out.println(Arrays.toString(a));
 *          [8, 7, 1, 2, 4, 6, 5, 9, 3, 0] is possible because
 *          4 >= 2, 4 >= 1, 4 < 6, 4 < 5, 4 < 9.
 *          But It could also be [8, 7, 2, 1, 4, 6, 5, 9, 3, 0], or
 *          [8, 7, 2, 1, 4, 9, 5, 6, 3, 0]
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$16
{
    public static void main(String[] args)
    {
        int[] a = {8,7,4,1,9,6,2,5,3,0};

        System.out.println(pos(a,2, 7)); // 4
        /* l = 4, r = 5 */
        System.out.println(Arrays.toString(a)); // [8, 7, 2, 1, 4, 6, 9, 5, 3, 0]

        System.out.println(pos(a, 2, 8)); // 3
        /* l = 2, r = 3 */
        System.out.println(Arrays.toString(a)); // [8, 7, 1, 2, 4, 6, 9, 5, 3, 0]
    }

    public static int pos(int[] a,
                          int l, int r)
    {
        return pos(a, l, r, l+1, l+1);
    }

    public static int pos(int[] a,
                          int l, int r,
                           int currentPosition, int i)
    {
        if (i > r)
        {
            int temp = a[currentPosition-1];
            a[currentPosition-1] = a[l];
            a[l] = temp;
            return currentPosition-1;
        }

        if (a[l] >= a[i])
        {
            int temp = a[currentPosition];
            a[currentPosition] = a[i];
            a[i] = temp;
            currentPosition++;
        }
        return pos(a, l, r,currentPosition, i+1);
    }
}
