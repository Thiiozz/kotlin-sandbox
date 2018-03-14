package fr.thiiozz.pokerhand.rules

import fr.thiiozz.pokerhand.model.cards.Card
import fr.thiiozz.pokerhand.model.cards.Combination
import fr.thiiozz.pokerhand.model.cards.Value

object ScoreCalculator {
    fun computeScore(cards: List<Card>): Int = when {
        hasRoyalFlush(cards) -> Combination.ROYAL_FLUSH.score + getSingleHighestCardValue(cards)
        hasStraightFlush(cards) -> Combination.STRAIGHT_FLUSH.score + getSingleHighestCardValue(cards)
        hasFlush(cards) -> Combination.FLUSH.score + getSingleHighestCardValue(cards)
        hasStraight(cards) -> Combination.STRAIGHT.score + getSingleHighestCardValue(cards)
        hasFullHouse(cards) -> Combination.FULL_HOUSE.score + (getHighestGroupValue(cards)?.value ?: 0)
        hasNTimeTheSameCard(cards, 4) -> Combination.FOUR_OF_A_KIND.score + (getHighestGroupValue(cards)?.value ?: 0)
        hasNTimeTheSameCard(cards, 3) -> Combination.THREE_OF_A_KIND.score + (getHighestGroupValue(cards)?.value ?: 0)
        hasTwoPairs(cards) -> Combination.TWO_PAIR.score + (getHighestGroupValue(cards)?.value ?: 0)
        hasNTimeTheSameCard(cards, 2) -> Combination.PAIR.score + (getHighestGroupValue(cards)?.value ?: 0)
        else -> Combination.NOTHING.score + getSingleHighestCardValue(cards)
    }

    private fun hasRoyalFlush(cards: List<Card>): Boolean =
            hasStraightFlush(cards) && getSingleHighestCardValue(cards) == 14

    private fun hasStraightFlush(cards: List<Card>): Boolean =
            hasStraight(cards) && hasFlush(cards)

    private fun hasFlush(cards: List<Card>): Boolean =
            cards
                    .map { it.color }
                    .distinct()
                    .size == 1

    private fun hasStraight(cards: List<Card>): Boolean =
            getSequenceOfFiveCardsFromHighestCard(getSingleHighestCardValue(cards))
                    .containsAll(cards.map { c -> c.value.value })
                    .and(
                            cards
                                    .map { c -> c.value.value }
                                    .distinct()
                                    .size == 5
                    )

    private fun hasFullHouse(cards: List<Card>): Boolean =
            groupCardsByValues(cards)
                    .containsValue(3)
                    .and(
                            groupCardsByValues(cards).containsValue(2)
                    )

    private fun hasNTimeTheSameCard(cards: List<Card>, N: Int): Boolean =
            groupCardsByValues(cards)
                    .containsValue(N)

    private fun hasTwoPairs(cards: List<Card>): Boolean =
            groupCardsByValues(cards)
                    .filter { it.value == 2 }
                    .size == 2

    private fun getSingleHighestCardValue(cards: List<Card>) =
            cards
                    .sortedBy { v -> v.value.value }
                    .last()
                    .value.value

    private fun groupCardsByValues(cards: List<Card>): Map<Value, Int> =
            cards
                    .asSequence()
                    .groupingBy { it.value }
                    .eachCount()

    private fun getSequenceOfFiveCardsFromHighestCard(i: Int): List<Int> =
            ((i - 4)..(i)).toList()

    private fun getHighestGroupValue(cards: List<Card>): Value? =
            groupCardsByValues(cards)
                    .maxBy { it.value }
                    ?.key
}