package fr.thiiozz.datamunge

class MonumentAggregator {
    private var data: List<List<String>> = CsvLoader().readAsLinesOfWords("/merimee-MH-valid.csv.utf", "\n", false, "|")

    fun findMonumentByType(type: String): List<List<String>> {
        return data.filter { l -> l[6].trim().toLowerCase().equals(type.toLowerCase()) }
    }
}
