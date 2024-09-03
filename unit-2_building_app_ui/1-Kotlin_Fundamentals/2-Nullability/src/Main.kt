fun main() {
    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor.length) // Error: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type 'kotlin/String?'.
    println(favoriteActor?.length)

    favoriteActor = null
    println(favoriteActor?.length)

    favoriteActor = "Sandra Oh"
    println(favoriteActor!!.length)

    favoriteActor = null
    // !! -> not-null assertion operator (usage not encouraged)
//    println(favoriteActor!!.length) // Error: Exception in thread "main" java.lang.NullPointerException

    // ?: -> Elvis operator (adds a default value in the presence of null)
    println(favoriteActor?.length ?: 0)
}