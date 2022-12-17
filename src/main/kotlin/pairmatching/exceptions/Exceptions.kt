package pairmatching.exceptions

import pairmatching.model.*

class Exceptions {
    fun validateServiceOption(input: String) {
        require(input in Service.options()) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_OPTION_INPUT)}
    }

    fun validateCurriculumInput(input: String) {
        val inputs = input.split(", ")
        require(inputs.size == 3) {throw IllegalArgumentException(ERROR_MESSAGE + WRONG_CURRICULUM_SIZE_MESSAGE)}
        require(inputs[0] in Course.names()) {throw IllegalArgumentException(ERROR_MESSAGE + WRONG_CURRICULUM_INPUT_MESSAGE)}
        require(validateLevelMission(inputs)) { throw java.lang.IllegalArgumentException(ERROR_MESSAGE + WRONG_CURRICULUM_INPUT_MESSAGE)}
    }

    private fun validateLevelMission(inputs: List<String>): Boolean {
        if (inputs[1] !in Level.names()) {
            return false
        }
        for (mission in Mission.values()) {
            if (mission.getValue() == inputs[2] && mission.getLevel().value == inputs[1]) {
                return true
            }
        }
        return false
    }

/*
    fun isExistPair(input: String): Boolean {
        val inputs = input.split(", ")
        val pairResult = PairResult(inputs[0], inputs[1], inputs[2])
        if (pairResult.pairs.isEmpty()) {
            return false
        }
        return true
    }
*/

    companion object {
        const val ERROR_MESSAGE = "[ERROR] "
        const val WRONG_OPTION_INPUT = "기능 선택은 1, 2, 3, Q 중에서 선택가능합니다."
        const val WRONG_CURRICULUM_SIZE_MESSAGE = "과정, 레벨, 미션을 모두 선택해주세요."
        const val WRONG_CURRICULUM_INPUT_MESSAGE = "현재 선택하신 커리큘럼은 존재하지 않습니다."
    }
}