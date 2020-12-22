package mastermind

const val NO_WRONG_POSITION = 0
const val ALL_RIGHT_POSITION = 4

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    if (secret == guess) return Evaluation(ALL_RIGHT_POSITION, NO_WRONG_POSITION)

    var rightPosition = 0
    var wrongPosition = 0
    val guessChars = guess.toMutableList()
    for ((index, char) in secret.withIndex()) {
        if (char == guess[index]) rightPosition++
        if (char in guessChars) wrongPosition++
        guessChars.remove(char)
    }
    return Evaluation(rightPosition, wrongPosition - rightPosition)
}
