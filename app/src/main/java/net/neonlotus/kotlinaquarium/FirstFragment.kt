package net.neonlotus.kotlinaquarium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.neonlotus.kotlinaquarium.databinding.FragmentFirstBinding
import java.lang.Math.random
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            //findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            //Let the games begin
            //val params: Array<String> = arrayOf("Pass-me")
            fishMain()
            //repl316()
            //quiz317()
            //repl318()
            quiz319()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //FILTER
    fun repl316() {
        val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flower pot")
        //println(decorations.filter { true })
        //println(decorations.filter { it[0] == 'p' })

        //eager or lazy
        val eager = decorations.filter { it[0] == 'p' }
        println(eager)

        val filtered = decorations.asSequence().filter { it[0] == 'p' }
        println(filtered)
        println(filtered.toList())

        //apply map lazily
        val lazyMap = decorations.asSequence().map {
            println("map: $it")
            it
        }
        println(lazyMap)
        println("first: ${lazyMap.first()}")
        println("all: ${lazyMap.toList()}")
    }

    fun quiz317() {
        val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
        //                  5           6          7        6           9       11              10
        val sortedSpices = spices.filter { it.contains("curry") }.sortedBy { it.length }
        println("Curry length $sortedSpices")

        val CE = spices.filter { it[0] == 'c' && it[it.length-1] == 'e' }
        println("CE $CE")
        val CE2 = spices.filter { it.first() == 'c' && it.last() == 'e' }
        println("CE2 $CE2")

        val first = spices.subList(0,3).filter { it.first() == 'c' }
        println("First $first")
    }

    fun repl318() {
        { println("Hello")}()
        val swim = { println("swim \n")}
        swim()

        val dirty = 20
        //val waterFilter = { dirty:Int -> dirty/2}
        val waterFilter: (Int) -> Int = { dirty -> dirty / 2}
        println(waterFilter(dirty))
    }

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }
    fun dirtyProcessor() {
        var dirty = 20
        val waterFilter: (Int) -> Int = { dirty -> dirty / 2}
        fun feedFish(dirty: Int) = dirty + 10

        dirty = updateDirty(dirty, waterFilter)
        dirty = updateDirty(dirty, ::feedFish)
        dirty = updateDirty(dirty) { dirty ->
            dirty + 50
        }
    }
    //whew

    //Practice Quiz 3-19
    /*
    val random1 = random() VS val random2 = {random()} =second will generate random number every time random2 is accessed
     */
    fun quiz319() {
        val random1 = random() //decided at compile time
        val random2 = {random()} //decided any time random2 is accessed

        quiz319lambda()
    }

    fun quiz319lambda() {
        /*
        Create a lambda and assign it to rollDice, which returns a dice roll (number between 1 and 12).
        Extend the lambda to take an argument indicating the number of sides of the dice used for the roll.
        If you haven't done so, fix the lambda to return 0 if the number of sides passed in is 0.
        Create a new variable, rollDice2, for this same lambda using the function type notation.
         */

        val rollDice = { Random().nextInt(12) + 1}
//        println("1. $rollDice")
        val rollDice2 = {sides: Int -> Random().nextInt(sides) + 1}
//        println("2. $rollDice2")
        val rollDice3 = {sides: Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1}
//        println("3. $rollDice3")

        val rrooll: (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) + 1}
//        println("4. $rrooll")

        gamePlay(rrooll(4))
        gamePlay(rrooll(8))
        gamePlay(rrooll(12))
        gamePlay(rrooll(16))
    }
    fun gamePlay(diceRoll: Int){
        // do something with the dice roll
        println(diceRoll)
    }

    fun fishMain() {
        //Lesson 3 10 changing water
        //Also lesson 3 11 fit more fish
        feedTheFish()

        //Test cases for fitting more fish
        //fitMoreFish(10.0, listOf(3,3,3))
        //fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false)
        //fitMoreFish(9.0, listOf(1,1,3), 3)
        //fitMoreFish(10.0, listOf(), 7, true)

        //3-13
//        println(whatShouldIDoToday("sad"))
//        println(whatShouldIDoToday("happy"))
//        println(whatShouldIDoToday("wat"))
//        println(whatShouldIDoToday("sad", "rainy", 0))
//        println(whatShouldIDoToday(mood = "somemood", temperature = 40))



//        var fortune: String = ""
////        repeat (10) {
////            fortune = getFortuneCookie(getBirthday())
////            println("\nYour fortune is: $fortune")
////            //if (fortune.contains("Take it easy")) break; //no break in a repeat
////        }
//        while (!fortune.contains("Take it easy")) {
//            fortune = getFortuneCookie(getBirthday())
//            println("\nYour fortune is: $fortune")
//            //ends in the 'take it easy' one, correct good
//        }

    }

    //prototype of dirty sensor
    fun getDirtySensorReading() = 20

    //default first, no default next
    fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = getDirtySensorReading()): Boolean {

        val isTooHot = temperature > 30
        val isDirty = dirty > 30
        val isSunday = day == "Sunday"

        return when {
            isTooHot(temperature) -> true
            isDirty(dirty) -> true
            isSunday(day) -> true
            else -> false
        }
    }

    //should change alternates, can do
    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty > 30
    fun isSunday(day: String) = day == "Sunday"

    fun feedTheFish() {
        val day = randomDay()
        val food = fishFood(day)
        println("Today is $day and the fish eat $food")

        if (shouldChangeWater(day)) {
            println("Change the water today")
        }

        dirtyProcessor()
    }

    fun randomDay(): String {
        val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        return week[Random().nextInt(7)]
    }

    fun fishFood(day: String): String {
        var food = "fasting"

        return when (day) {
            "Monday" -> "flakes"
            "Wednesday" -> "redworms"
            "Thursday" -> "granules"
            "Sunday" -> "plankton"
            else -> "fasting"
        }
    }

    //Exercise [3-10]
    fun fitMoreFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true) {
        /*
        Typically, a tank with decorations can contain a total length of fish (in inches) less than
        or equal to 80% of the tank size (in gallons). A tank without decorations can contain a
        total length of fish up to 100% of the tank size.
         */

        val existingFish = currentFish.sum()

        val maxSize = if (hasDecorations)  tankSize*.8 else tankSize

        println(existingFish + fishSize <= maxSize)
    }

    //Practice 3-13
    fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
        return when {
            isHappySunny(mood, weather) -> "go for a walk"
            isSadRainyCold(mood, weather, temperature) -> "stay in bed"
            isVeryHot(temperature) -> "go swimming"
            else -> "Stay home and read."
        }
    }
    //they want them single expression functions
    fun isVeryHot (temperature: Int) = temperature > 35
    fun isSadRainyCold(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
    fun isHappySunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"

    //Lesson 3 quiz 7
    //Modifying for 3-15
    fun getFortuneCookie(bday: Int): String {
        val fortunes = listOf("You will have a great day!", "Things will go well for you today.",
            "Enjoy a wonderful day of success.", "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

        /*
            If the birthday is 28 or 31...
            If the birthday is in the first week…
            else … return the calculated fortune as before.
         */

        var fortuneIndex = bday.rem(fortunes.size)
        fortuneIndex = when(bday) {
            in 1..7 -> 1
            in 8..15 -> 2
            30 -> 3
            else -> bday.rem(fortunes.size)
        }

        return fortunes[fortuneIndex]
    }

    //Quiz 3-9
    fun getBirthday(): Int {
        //print("Enter your birthday (number):") //this doesn't work in the current way I'm running this, but should be correct so whatever
        //val birthday = readLine()?.toIntOrNull() ?: 1
        val birthdays = listOf(1, 5, 9, 14, 19, 22, 30)
        return birthdays[Random().nextInt(7)]
    }

}