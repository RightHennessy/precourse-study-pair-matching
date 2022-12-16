package pairmatching

import pairmatching.view.View

class MatchingService {
    private val view = View()

    fun choose() {
        view.chooseService()
    }
}