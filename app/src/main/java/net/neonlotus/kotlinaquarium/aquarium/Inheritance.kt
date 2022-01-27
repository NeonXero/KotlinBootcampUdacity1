package net.neonlotus.kotlinaquarium.aquarium

class Inheritance {

    fun delegate() {
        val pleco = Plecostomus()
        println("Fish has color ${pleco.color}")
        pleco.eat()
    }

    interface FishAction {
        fun eat()
    }

    interface FishColor {
        val color: String
    }

    class Plecostomus(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("a lot of algae"),
        FishColor by fishColor
}

object GoldColor: Inheritance.FishColor {
    override val color = "gold"
}

object RedColor: Inheritance.FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String): Inheritance.FishAction {
    override fun eat() {
        println(food)
    }
}