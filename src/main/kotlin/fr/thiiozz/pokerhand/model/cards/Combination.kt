package fr.thiiozz.pokerhand.model.cards

enum class Combination(val score: Int) {
    NOTHING(0),
    PAIR(100),
    TWO_PAIR(200),
    THREE_OF_A_KIND(300),
    STRAIGHT(400),
    FLUSH(500),
    FULL_HOUSE(600),
    FOUR_OF_A_KIND(700),
    STRAIGHT_FLUSH(800),
    ROYAL_FLUSH(900)
}