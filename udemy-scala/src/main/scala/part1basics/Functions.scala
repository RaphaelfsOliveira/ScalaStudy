package part1basics

object Functions extends App {
    // functions

    def aFunction(a: String, b: Int): String = {
        a + " " + b
    }

    println(aFunction("Hello", 6))

    def aRepeatedFunction(aString: String, n: Int): String = {
        if (n == 1) {
            aString + " " + "Final" 
        } else {
            aString + "\n" + aRepeatedFunction(aString, n - 1)
        }
    }

    println(aRepeatedFunction("Hello", 5))


    def welcomeFunction(name: String, age: Int): String = {
        "Hi, my name is " + name + " and I am " + age + " years old." 
    }

    println(welcomeFunction("John", 35))

    def factorial(n: Int): Int = {
        if (n <= 0) {
            1
        } else {
            n * factorial(n - 1)
        }
    }

    println(factorial(6))

    def fibonacci(n: Int): Int = {
        if (n <= 2) 1
        else fibonacci(n - 1) + fibonacci(n - 2)
    }

    println(fibonacci(8))

    def isPrime(n: Int): Boolean = {
        
        def isPrimeUntil(t: Int): Boolean = {
            if (t <= 1) true
            else n % t != 0 && isPrimeUntil(t - 1)
        }

        isPrimeUntil(n / 2)
    }

    println(isPrime(37))
    println(isPrime(2003))
    println(isPrime(37 * 17))
}
