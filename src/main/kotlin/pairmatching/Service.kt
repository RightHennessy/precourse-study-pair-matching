package pairmatching

import kotlin.text.StringBuilder

enum class Service(private val choice: String, private val option: String) {
    ONE("1","페어 매칭"),
    TWO("2", "페어 조회"),
    THREE("3", "페어 초기화"),
    QUIT("Q", "종료");

    fun getChoice() = this.choice

    companion object {
        fun options() = listOf(ONE.choice, TWO.choice, THREE.choice, QUIT.choice)

        fun getOptions(): StringBuilder {
            val stringBuilder = StringBuilder()
            for (service in Service.values()) {
                stringBuilder.append(service.choice)
                stringBuilder.append(". ")
                stringBuilder.append(service.option)
                stringBuilder.append("\n")
            }
            return stringBuilder
        }
    }
}