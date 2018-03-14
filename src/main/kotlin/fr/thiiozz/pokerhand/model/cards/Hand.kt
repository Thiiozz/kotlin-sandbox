package fr.thiiozz.pokerhand.model.cards

import fr.thiiozz.pokerhand.rules.ScoreCalculator

class Hand {
    val cards : MutableList<Card> = ArrayList()

    init {
        (0..4).forEach{ this.cards.add(Deck.distribute())}
    }

    fun computeScore(): Int = ScoreCalculator.computeScore(cards)
}