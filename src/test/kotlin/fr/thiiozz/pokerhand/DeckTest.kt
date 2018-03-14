package fr.thiiozz.pokerhand

import fr.thiiozz.pokerhand.model.cards.Card
import fr.thiiozz.pokerhand.model.cards.Deck
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals


@RunWith(JUnitPlatform::class)
class DeckTest : Spek({
    describe("A card deck"){
        it("must have 52 cards"){
            Deck.initialize()
            assertEquals(52, Deck.cards.size)
        }

        it("can shuffle cards"){
            val initialFirstCard : Card = Deck.cards.elementAt(0)
            Deck.shuffle()
            val postShufflingFirstCard : Card = Deck.cards.elementAt(0)

            assertNotEquals(initialFirstCard, postShufflingFirstCard)
        }

        it("can distribute cards"){

            val firstCard : Card =  Deck.distribute()
            val secondCard : Card = Deck.distribute()

            assertNotEquals(firstCard, secondCard)
            assertEquals(50, Deck.cards.size)
        }
    }
})