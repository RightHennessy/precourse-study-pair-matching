package pairmatching.model

import camp.nextstep.edu.missionutils.Randoms.shuffle

class PairResult(course: String, level: String, mission: String) {
    private val pairs = mutableListOf<String>()

    fun makePairs(curriculum: List<String>) {
        val randomPair = shuffle(curriculum)

        for (random in randomPair) {
            pairs.add(random)
        }
    }

    fun getPairs() {
        val stringBuilder = StringBuilder()
        for (i in pairs.indices) {
            stringBuilder.append(pairs[i] + " : " + pairs[i+1])
        }
    }
}