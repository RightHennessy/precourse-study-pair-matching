package pairmatching.view

import camp.nextstep.edu.missionutils.Console.readLine
import pairmatching.exceptions.Exceptions

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
        // exceptions.isExistPair(input)
        return input.split(", ")
    }
}