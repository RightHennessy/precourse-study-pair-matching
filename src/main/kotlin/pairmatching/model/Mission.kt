package pairmatching.model

enum class Mission(private val value: String, private val level: Level) {
    CAR_RACING("자동차경주", Level.LEVEL1),
    LOTTO("로또", Level.LEVEL1),
    BASEBALL("숫자야구게임", Level.LEVEL1),
    CART("장바구니", Level.LEVEL2),
    PAYMENT("결제", Level.LEVEL2),
    SUBWAY("지하철노선도", Level.LEVEL2),
    PERFORMANCE("성능개선" , Level.LEVEL4),
    PUBLISHING("배포", Level.LEVEL4);

    fun getValue() = this.value
    fun getLevel() = this.level

    companion object {
        private const val VERTICAL_LINE = " | "

        fun getMissionNames(): StringBuilder {
            val stringBuilder = StringBuilder()
            stringBuilder.append("미션: \n")
            for (level in Level.values()) {
                stringBuilder.append("  - " + level.value + ": " + getMission(level))
            }
            return stringBuilder
        }

        private fun getMission(level: Level): String {
            val names = mutableListOf<String>()
            for(mission in Mission.values()) {
                if (mission.level == level) {
                    names.add(mission.value)
                }
            }
            return names.joinToString(VERTICAL_LINE) + "\n"
        }
    }

}