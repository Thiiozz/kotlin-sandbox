package fr.thiiozz.fizzbuzz

class Fizzbuzz {
    fun play(number: Int): String = if (number % 3 == 0 && number % 5 == 0) "fizzbuzz" else if (number % 3 == 0) "fizz" else if (number % 5 == 0) "buzz" else number.toString()
    fun playInRange(bound: Int): List<String> = (1..bound).map { i -> play(i) }.toList()
}