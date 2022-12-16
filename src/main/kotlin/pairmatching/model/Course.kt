package pairmatching.model

enum class Course(private val value: String) {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    companion object {
        private const val COURSE = "과정: "
        private const val VERTICAL_LINE = " | "

        fun names() = listOf(BACKEND.value, FRONTEND.value)

        fun getCourseNames(): StringBuilder {
            val stringBuilder = StringBuilder()
            stringBuilder.append(COURSE)
            stringBuilder.append(BACKEND.value)
            stringBuilder.append(VERTICAL_LINE)
            stringBuilder.append(FRONTEND.value)
            return stringBuilder
        }
    }
}