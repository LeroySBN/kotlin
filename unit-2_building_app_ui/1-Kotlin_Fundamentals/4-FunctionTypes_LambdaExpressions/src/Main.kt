fun main() {
//    val trickFunction = trick // Error: Function invocation 'trick()' expected
    val trickFun = ::trickfcn // this is a reference operator
    trickFun()

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val coinsShorthand: (Int) -> String = {
        "$it quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

    // Passing a function to another function as an arg
    var trickFunction = trickOrTreat(true, cupcake)
    trickFunction()

    val treatFunction = trickOrTreat(false, coins)
    treatFunction()

    // Nullable function type
    trickFunction = trickOrTreat(true, null)

    // Using shorthand
    val treatFunctionInShorthand = trickOrTreat(false, { "$it quarters only" })
    treatFunctionInShorthand()

    val treatFunctionWithTrailingLambda = trickOrTreat(false) { "$it quarters more" }

    repeat(4) {
        trickFunction()
    }
    treatFunctionWithTrailingLambda()
}

fun trickfcn() {
    println("No treats!")
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

// This is a Lambda expression
// it uses the val/var keyword followed by a pair of curly braces
val trick = {
    println("No treats!")
}

// This is another Lambda expression with a function type
val treat: () -> Unit = {
    println("Have a treat!") // Lambda function
}