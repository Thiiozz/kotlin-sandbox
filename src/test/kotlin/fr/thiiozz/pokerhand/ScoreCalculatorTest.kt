package fr.thiiozz.pokerhand

import fr.thiiozz.pokerhand.model.cards.Card
import fr.thiiozz.pokerhand.model.cards.Color
import fr.thiiozz.pokerhand.model.cards.Value
import fr.thiiozz.pokerhand.rules.ScoreCalculator
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class ScoreCalculatorTest : Spek({
    describe("a score calculator") {
        it("can get highest card score") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.SPADE, Value.ACE))
            cards.add(Card(Color.DIAMOND, Value.TWO))
            cards.add(Card(Color.DIAMOND, Value.THREE))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))

            assertEquals(14, ScoreCalculator.computeScore(cards))
        }

        it("can detect single pairs") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.CLUB, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.THREE))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))

            assertEquals(113, ScoreCalculator.computeScore(cards))
        }

        it("can detect double pairs") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.CLUB, Value.ACE))
            cards.add(Card(Color.CLUB, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))

            assertEquals(214, ScoreCalculator.computeScore(cards))
        }

        it("can detect three of a kind") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.CLUB, Value.QUEEN))
            cards.add(Card(Color.HEART, Value.QUEEN))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))

            assertEquals(312, ScoreCalculator.computeScore(cards))
        }

        it("can detect a simple straight") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.HEART, Value.EIGHT))
            cards.add(Card(Color.CLUB, Value.NINE))
            cards.add(Card(Color.SPADE, Value.TEN))
            cards.add(Card(Color.DIAMOND, Value.JACK))
            cards.add(Card(Color.CLUB, Value.QUEEN))

            assertEquals(412, ScoreCalculator.computeScore(cards))
        }

        it("can detect flush") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.THREE))
            cards.add(Card(Color.DIAMOND, Value.FOUR))
            cards.add(Card(Color.DIAMOND, Value.SIX))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.ACE))

            assertEquals(514, ScoreCalculator.computeScore(cards))
        }

        it("can detect full house") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.CLUB, Value.ACE))
            cards.add(Card(Color.SPADE, Value.ACE))
            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.HEART, Value.KING))

            assertEquals(614, ScoreCalculator.computeScore(cards))
        }

        it("can detect four of a kind") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.CLUB, Value.JACK))
            cards.add(Card(Color.HEART, Value.JACK))
            cards.add(Card(Color.SPADE, Value.JACK))
            cards.add(Card(Color.DIAMOND, Value.JACK))

            assertEquals(711, ScoreCalculator.computeScore(cards))
        }

        it("can detect straight flush") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.EIGHT))
            cards.add(Card(Color.DIAMOND, Value.NINE))
            cards.add(Card(Color.DIAMOND, Value.TEN))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))
            cards.add(Card(Color.DIAMOND, Value.JACK))

            assertEquals(812, ScoreCalculator.computeScore(cards))
        }

        it("can detect royal flush") {
            val cards : MutableList<Card>  = ArrayList()

            cards.add(Card(Color.DIAMOND, Value.JACK))
            cards.add(Card(Color.DIAMOND, Value.KING))
            cards.add(Card(Color.DIAMOND, Value.TEN))
            cards.add(Card(Color.DIAMOND, Value.ACE))
            cards.add(Card(Color.DIAMOND, Value.QUEEN))

            assertEquals(914, ScoreCalculator.computeScore(cards))
        }
    }
})