package pairmatching

class Exceptions {
    fun validateServiceOption(input: String) {
        require(input in Service.options()) { throw IllegalArgumentException(ERROR_MESSAGE + WRONG_OPTION_INPUT)}
    }

    companion object {
        const val ERROR_MESSAGE = "[ERROR] "
        const val WRONG_OPTION_INPUT = "기능 선택은 1, 2, 3, Q 중에서 선택가능합니다."
    }
}