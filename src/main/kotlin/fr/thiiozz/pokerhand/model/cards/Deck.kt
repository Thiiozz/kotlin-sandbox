package fr.thiiozz.pokerhand.model.cards

import java.util.*

object Deck {
    var cards: MutableSet<Card> = HashSet()

    init {
        println("Constructing a new deck !")
        fill()

        println("Deck of ${cards.size} constructed")
        shuffle()

        println("Shuffling cards")
        println("Deck ready !")
    }

    private fun fill() {
        Color.values().forEach { c -> Value.values().forEach { v -> cards.add(Card(c, v)) } }
    }

    fun shuffle() {
        cards = cards.shuffled().toMutableSet()
    }

    fun distribute(): Card {
        val c = cards.elementAt(0)
        cards.remove(c)
        return c
    }
}