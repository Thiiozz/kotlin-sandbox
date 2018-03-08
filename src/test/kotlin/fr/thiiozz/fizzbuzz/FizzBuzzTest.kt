package fr.thiiozz.fizzbuzz


import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class FileHandlerTest : Spek ({
    describe("the fizzbuzz game"){
        val f = Fizzbuzz()

        it(" must return fizz when a number is divisible by 3"){
            assertEquals("fizz", f.play(3))
        }

        it(" must return buzz when a number is divisible by 5"){
            assertEquals("buzz", f.play(5))
        }

        it(" must return fizzbuzz when a number is divisible by both 5 and 3"){
            assertEquals("fizzbuzz", f.play(15))
        }

        it(" must return the input number if it's a diviser of 3 or 5"){
            assertEquals("8", f.play(8))
        }

        it(" can play for many inputs"){
            assertEquals(100, f.playInRange(100).size)
        }
    }
})