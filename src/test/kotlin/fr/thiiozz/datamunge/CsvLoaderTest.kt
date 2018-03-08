package fr.thiiozz.datamunge

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals


@RunWith(JUnitPlatform::class)
class FileHandlerTest : Spek({
    describe("A CSV File loader") {
        val l = CsvLoader()

        it("must read exactly 45192 lines from the resources file") {
            assertEquals(45192, l.readAsLines("/merimee-MH-valid.csv.utf").size)
        }

        it("can skip header line") {
            assertEquals(45191, l.readAsLines("/merimee-MH-valid.csv.utf", "\n", true).size)
        }

        it("can also explode lines into words and read 14 words from header line") {
            var linesAndWords = l.readAsLinesOfWords("/merimee-MH-valid.csv.utf", "\n", false, "|")

            assertEquals(45192, linesAndWords.size)
            assertEquals(14, linesAndWords[0].size)
        }
    }
})