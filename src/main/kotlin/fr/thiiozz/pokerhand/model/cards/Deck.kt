package fr.thiiozz.pokerhand.model.cards

object Deck {
    var cards: MutableSet<Card> = HashSet()

    init {
        initialize()
    }

    fun initialize() {
        cards = HashSet()
        fill()
        shuffle()
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