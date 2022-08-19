package chapter_twenty_four;

import java.util.Stack;

/**
 * 24.4 (Use the GenericStack class) Write a program that displays the first 100 prime
 * numbers in descending order. Use a stack to store the prime numbers.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$04
{
    public static void main(String[] args)
    {
        Stack<Integer> primes = new Stack<>();
        int current = 2;
        while (primes.size() != 100)
        {
            boolean prime = true;
            for (int i = 2; i < current; i++)
                if (current % i == 0)
                {
                    prime = false;
                    break;
                }
            if (prime)
                primes.push(current);
            current++;
        }
        /*
        * 541 523 521 509 503 499 491 487 479 467 463 461 457 449 443 439 433 431 421
        * 419 409 401 397 389 383 379 373 367 359 353 349 347 337 331 317 313 311 307
        * 293 283 281 277 271 269 263 257 251 241 239 233 229 227 223 211 199 197 193
        * 191 181 179 173 167 163 157 151 149 139 137 131 127 113 109 107 103 101 97 89
        * 83 79 73 71 67 61 59 53 47 43 41 37 31 29 23 19 17 13 11 7 5 3 2
         */
        for (int i = 99; i > -1; i--)
            System.out.print(primes.get(i) + " ");
    }
}
