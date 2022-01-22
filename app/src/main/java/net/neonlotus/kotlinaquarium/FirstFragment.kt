package net.neonlotus.kotlinaquarium

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.neonlotus.kotlinaquarium.databinding.FragmentFirstBinding
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
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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



        var fortune: String = ""
//        repeat (10) {
//            fortune = getFortuneCookie(getBirthday())
//            println("\nYour fortune is: $fortune")
//            //if (fortune.contains("Take it easy")) break; //no break in a repeat
//        }
        while (!fortune.contains("Take it easy")) {
            fortune = getFortuneCookie(getBirthday())
            println("\nYour fortune is: $fortune")
            //ends in the 'take it easy' one, correct good
        }

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