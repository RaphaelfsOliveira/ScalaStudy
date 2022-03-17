package part1basics

import scala.annotation.tailrec

object Recursion extends App {

    def factorial(n: Int): Int = {
        if (n <= 0) {
            1
        } else {
            println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
            var result = n * factorial(n - 1)
            println("Computed factorial of " + n)

            result
        }
    }

    println(factorial(10))

    
    def anotherFactorial(n: Int): BigInt = {

        @tailrec
        def factHelper(x: Int, accumulator: BigInt): BigInt = {
            if (x <= 1) accumulator
            else factHelper(x - 1, x * accumulator)
        }

        factHelper(n, 1)
    }
    
    /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1 -> 10)
    = factHelper(8, 9 * 10 * 1 -> 90)
    = factHelper(7, 8 * 9 * 10 * 1 -> 720)
    = factHelper(6, 7 * 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 1 * 2 * ... * 10 * 1)
    = 1 * 2 * ... * 10 * 1
    */

    // println(anotherFactorial(5000))

    @tailrec
    def concatenaceTailrec(aString: String, n: Int, accumulator: String): String = {
        if (n <= 0) accumulator
        else concatenaceTailrec(aString, n - 1, aString + accumulator)
    }

    println(concatenaceTailrec("Hello", 5, ""))

    def isPrime(n: Int): Boolean = {

        @tailrec
        def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
            if (!isStillPrime) false
            else if (t <= 1) true
            else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)
        }

        isPrimeTailrec(n / 2, true)
    }

    println(isPrime(2003))
    println(isPrime(629))

    
    
    

  
}