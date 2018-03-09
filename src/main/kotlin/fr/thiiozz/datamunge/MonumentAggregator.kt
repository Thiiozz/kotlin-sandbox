package fr.thiiozz.datamunge

data class Monument(
        val ref: String,
        val study: String,
        val region: String,
        val state: String,
        val city: String,
        val insee: String,
        val name: String,
        val adress: String,
        val owner: String,
        val affe: String,
        val ppro: String,
        val dpro: String,
        val autr: String,
        val epoch: String
)

class MonumentAggregator {
    private var data: List<Monument> = mapToMonument(CsvLoader().readAsLinesOfWords("/merimee-MH-valid.csv.utf", "\n", false, "|"))

    private fun mapToMonument(lines: List<List<String>>): List<Monument> {
        return lines
                .filter { l -> l.size == 14 }
                .map { l ->
                    Monument(
                            l[0].toLowerCase().trim(),
                            l[1].toLowerCase().trim(),
                            l[2].toLowerCase().trim(),
                            l[3].toLowerCase().trim(),
                            l[4].toLowerCase().trim(),
                            l[5].toLowerCase().trim(),
                            l[6].toLowerCase().trim(),
                            l[7].toLowerCase().trim(),
                            l[8].toLowerCase().trim(),
                            l[9].toLowerCase().trim(),
                            l[10].toLowerCase().trim(),
                            l[11].toLowerCase().trim(),
                            l[12].toLowerCase().trim(),
                            l[13].toLowerCase().trim()
                    )
                }
    }

    fun findMonumentByCity(city: String): List<Monument> = data.filter { m -> m.city == city.toLowerCase() }

    private fun findAllCity(): List<String> = data.map { m -> m.city }.distinct()

    fun groupByCityWithNumberOfMonuments(): Map<String, Int> = findAllCity().map { it to findMonumentByCity(it).size }.sortedByDescending { (_,v) -> v }.toMap()
}
