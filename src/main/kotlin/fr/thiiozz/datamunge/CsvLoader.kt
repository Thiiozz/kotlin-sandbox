package fr.thiiozz.datamunge

class CsvLoader {
    fun readAsLinesOfWords(filePath: String, linesBreaker: String = "\n", skeepHeader: Boolean = false, wordDelimiter: String): List<List<String>> {
        return readAsLines(filePath, linesBreaker, skeepHeader)
                .map { l -> l.split(wordDelimiter) }
    }

    fun readAsLines(filePath: String, linesBreaker: String = "\n", skeepHeader: Boolean = false): List<String> {
        var lines = readFileAsCsv(filePath, linesBreaker)

        if (skeepHeader) {
            lines = lines.subList(1, lines.size)
        }

        return lines
    }

    private fun readFileAsCsv(filePath: String, delimiter: String): List<String> = this::class.java.getResource(filePath).readText(charset = Charsets.UTF_8).split(delimiter)
}