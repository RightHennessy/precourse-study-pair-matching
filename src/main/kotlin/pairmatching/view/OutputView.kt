package pairmatching.view

import pairmatching.Service

class OutputView {
    fun requestChooseService() {
        println(REQUEST_OPTION)
        println(Service.getOptions())
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e)
    }

    companion object {
        const val REQUEST_OPTION ="기능을 선택하세요."
    }
}