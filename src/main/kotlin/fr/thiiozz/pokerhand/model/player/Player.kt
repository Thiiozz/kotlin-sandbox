package fr.thiiozz.pokerhand.model.player

import fr.thiiozz.pokerhand.model.cards.Hand

data class Player(val name: String, val hand : Hand = Hand())