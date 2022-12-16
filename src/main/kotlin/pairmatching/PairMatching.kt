package pairmatching

class PairMatching {
    private val data = Data()
    private val matchingService = MatchingService()

    fun start() {
        data.readFile()
        while (true) {
            when (matchingService.choose()) {
                Service.ONE.getChoice() -> matchingService.getMatching()
                Service.TWO.getChoice() -> matchingService.showPairs()
                Service.THREE.getChoice() -> matchingService.initPairs()
                Service.QUIT.getChoice() -> break
            }
        }
    }
}