package fr.thiiozz.pokerhand

import fr.thiiozz.pokerhand.model.player.Player
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(JUnitPlatform::class)
class PlayerTest : Spek({
    describe("A player") {
        val alice = Player("Alice")

        it("must have a name") {
            assertEquals("Alice", alice.name)
        }

        it("can have a cards hand") {
            assertEquals(5, alice.hand.cards.size)
        }
    }
})