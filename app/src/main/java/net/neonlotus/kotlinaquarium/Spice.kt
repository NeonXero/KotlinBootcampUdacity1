package net.neonlotus.kotlinaquarium

class Spice(val name: String, val spiciness: String = "mild") {
    var heat: Int = 0
        get() {
            return when (spiciness) {
                "mild" -> 1
                "medium" -> 5
                "hot" -> 10
                "turbo" -> 15
                else -> 0
            }
        }

    init {
        println("Init; Name: $name - Spiciness: $spiciness")
    }
}