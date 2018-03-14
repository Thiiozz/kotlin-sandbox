package fr.thiiozz.pokerhand.rules

import fr.thiiozz.pokerhand.model.player.Player

object GameResolver {
    fun play(nbOfPlayers: Int) {
        println("*****************************************************")
        println("**                  NEW GAME                       **")
        println("*****************************************************")

        (0..nbOfPlayers)
                .map { (Player(it.toString())) }
                .sortedByDescending { p -> p.hand.computeScore() }
                .forEach {
                    println("____________________________________________")
                    println("name: ${it.name}")
                    it.hand.cards.forEach { print("$it |") }
                    println("")
                    println("score: ${it.hand.computeScore()}")
                    println("____________________________________________")
                }
    }
}

fun main(args: Array<String>) {
    GameResolver.play(5)
}