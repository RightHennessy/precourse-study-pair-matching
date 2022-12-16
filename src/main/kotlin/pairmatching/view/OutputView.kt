package pairmatching.view

import pairmatching.model.Course
import pairmatching.model.Mission
import pairmatching.model.Service

class OutputView {
    fun requestChooseService() {
        println(REQUEST_OPTION_MESSAGE)
        println(Service.getOptions())
    }

    fun printErrorMessage(e: IllegalArgumentException) {
        println(e)
    }

    fun printCurriculumOptions() {
        val stringBuilder = StringBuilder()
        stringBuilder.append(HORIZONTAL_LINE + LINE_BREAK)
        stringBuilder.append(Course.getCourseNames().toString() + LINE_BREAK)
        stringBuilder.append(Mission.getMissionNames().toString() + LINE_BREAK)
        stringBuilder.append(HORIZONTAL_LINE + LINE_BREAK)
        stringBuilder.append(REQUEST_CURRICULUM_MESSAGE + LINE_BREAK)
        stringBuilder.append(INPUT_EXAMPLE_MESSAGE + LINE_BREAK)
        println(stringBuilder)
    }

    companion object {
        const val REQUEST_OPTION_MESSAGE = "기능을 선택하세요."
        const val HORIZONTAL_LINE = "#############################################"
        const val REQUEST_CURRICULUM_MESSAGE = "과정, 레벨, 미션을 선택하세요."
        const val INPUT_EXAMPLE_MESSAGE = "ex) 백엔드, 레벨1, 자동차경주"
        const val LINE_BREAK = "\n"
    }
}