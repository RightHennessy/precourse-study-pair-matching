package pairmatching

enum class Service(val choice: String, val option: String) {
    ONE("1","페어 매칭"),
    TWO("2", "페어 조회"),
    THREE("3", "페어 초기화"),
    QUIT("Q", "종료");
}