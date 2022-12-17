package pairmatching

import pairmatching.model.PairResult
import pairmatching.view.View

class MatchingService {
    private val view = View()

    fun choose(): String {
        return view.chooseService()
    }

    fun getMatching() {
        val curriculum = view.chooseCurriculum()
        PairResult(curriculum[0], curriculum[1], curriculum[2]).makePairs(curriculum)
        view.printPairs(curriculum)
    }

    fun showPairs() {
        TODO("Not yet implemented")
    }

    fun initPairs() {
        TODO("Not yet implemented")
    }
}