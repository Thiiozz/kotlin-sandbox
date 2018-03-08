package fr.thiiozz.datamunge

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

//7701

@RunWith(JUnitPlatform::class)
class MonumentAggregatorTest : Spek({
    describe("A Monument aggregator") {
        val m = MonumentAggregator()

        it("must count 2876 building") {
            assertEquals(2876, m.findMonumentByType("Immeuble").size)
        }
    }
})