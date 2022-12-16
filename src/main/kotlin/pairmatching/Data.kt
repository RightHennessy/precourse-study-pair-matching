package pairmatching

import java.io.FileReader

class Data {
    private var frontCrewNames = listOf<String>()
    private var backCrewNames = listOf<String>()
    val matchingResult = listOf<Map<List<String>, List<Pair<String, String>>>>()

    fun readFile() {
        val backCrewPath = "src\\main\\kotlin\\resources\\backend-crew.md"
        val frontCrewPath = "src\\main\\kotlin\\resources\\frontend-crew.md"
        backCrewNames = getNames(backCrewPath)
        frontCrewNames = getNames(frontCrewPath)
    }

    private fun getNames(path: String): List<String> {
        return try {
            val read = FileReader(path)
            read.readText().split("\n")
        } catch(e: Exception) {
            throw IllegalArgumentException(e)
        }
    }
}