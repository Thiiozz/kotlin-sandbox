package fr.thiiozz

import fr.thiiozz.fizzbuzz.Fizzbuzz

class Main {
    companion object {
        @JvmStatic
        public fun main(args: Array<String>) {
            Fizzbuzz().playInRange(1000).forEach { s -> println(s) }
        }
    }
}
