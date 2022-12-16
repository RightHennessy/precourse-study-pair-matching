package pairmatching

import pairmatching.view.View

class MatchingService {
    private val view = View()

    fun choose(): String {
        return view.chooseService()
    }

    fun getMatching() {
        view.chooseCurriculum()
    }

    fun showPairs() {
        TODO("Not yet implemented")
    }

    fun initPairs() {
        TODO("Not yet implemented")
    }
}