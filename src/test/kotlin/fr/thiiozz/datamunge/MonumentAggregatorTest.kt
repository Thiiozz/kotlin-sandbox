package fr.thiiozz.datamunge

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class MonumentAggregatorTest : Spek({
    describe("A Monument aggregator") {
        val m = MonumentAggregator()

        it("must count 376 monuments in Bordeaux city") {
            assertEquals(376, m.findMonumentByCity("Bordeaux").size)
        }

        it("know than Bordeaux is the best city ever !"){
            assertEquals(376,  m.groupByCityWithNumberOfMonuments()["bordeaux"])
        }
    }
})