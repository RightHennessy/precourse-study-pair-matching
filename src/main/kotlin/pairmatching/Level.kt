package pairmatching

enum class Level(val value: String) {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    companion object {
        fun names() = listOf(LEVEL1.value, LEVEL2.value, LEVEL3.value, LEVEL4.value, LEVEL5.value)
    }
}