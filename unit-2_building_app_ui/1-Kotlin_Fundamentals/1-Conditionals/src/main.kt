fun main() {
    var trafficLightColor: String? = "Red"
    when (trafficLightColor) {
        "Red" -> println("Stop")
        "Yellow" -> println("Slow")
        "Green" -> println("Go")
        else -> println("Invalid TrafficLightColor")
    }

    trafficLightColor = null
    var message =
        if (trafficLightColor == "Red") "Stop"
        else if (trafficLightColor == "Yellow") "Slow"
        else if (trafficLightColor == "Green") "Go"
        else "Invalid TrafficLightColor"
    println(message)

    trafficLightColor = "Amber"
    message = when (trafficLightColor) {
        "Red" -> "Stop"
        "Yellow", "Amber" -> "Slow"
        "Green" -> "Go"
        else -> "Invalid TrafficLightColor"
    }
    println(message)

    val x: Any = 14
    when (x) {
        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
        in 1..10 -> println("x isn't a prime number but is between 1 and 10")
        is Int -> println("x is an integer number but not between 1 and 10")
        else -> println("x isn't a prime number between 1 and 10")
    }
}