import java.time.LocalDate

fun main() {
    println("Enter your First name: ")
    val firstName = readlnOrNull()

    println("Enter your Sir name: ")
    val lastName = readlnOrNull()

    println("Hello $firstName $lastName! What is your current age? ")

    val age: Int = getAge()
    val currentYear = LocalDate.now().year
    println("Your Birth Year is: ${currentYear - age}")
}

fun getAge(): Int {
    var age = readlnOrNull()?.toIntOrNull()

    while (age == null && age !is Int) {
        println("You didn't enter a valid age. Try again!")
        age = readlnOrNull()?.toIntOrNull()
    }
    return age
}
