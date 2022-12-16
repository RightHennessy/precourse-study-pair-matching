package pairmatching.view

import camp.nextstep.edu.missionutils.Console.readLine
import pairmatching.Exceptions

class InputView {
    private val exceptions = Exceptions()

    fun getService(): String {
        val input = readLine()
        exceptions.validateServiceOption(input)
        return input
    }

    fun getCurriculum(): List<String> {
        val input = readLine()
        exceptions.validateCurriculumInput(input)
        return input.split(", ")
    }
}