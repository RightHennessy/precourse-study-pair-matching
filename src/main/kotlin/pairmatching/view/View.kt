package pairmatching.view

class View {
    private val inputView = InputView()
    private val outputView = OutputView()

    fun chooseService(): String {
        outputView.requestChooseService()
        return try {
            inputView.getService()
        }
        catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            chooseService()
        }
    }

    fun chooseCurriculum(): List<String> {
        outputView.printCurriculumOptions()
        return try {
            inputView.getCurriculum()
        }
        catch (e: IllegalArgumentException) {
            outputView.printErrorMessage(e)
            chooseCurriculum()
        }
    }
}