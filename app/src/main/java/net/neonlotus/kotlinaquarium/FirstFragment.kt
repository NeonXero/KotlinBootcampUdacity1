package net.neonlotus.kotlinaquarium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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
        //Testing reading from array
        //println("${args.asList().toString()}")
        //println("yuh ${args[0]}")

        //Forget lesson
        //dayOfWeek()

        //Lesson 3 item 4??
        //dingus()

        //Lesson 3 item 5, time of day
        //lesson35(Calendar.getInstance().get(Calendar.HOUR_OF_DAY).toString())
        //lesson35("4")

        //lesson 3-6
        //feedTheFish()

        //Less 3-7 quiz
        //println("Your fortune is: ${getFortuneCookie()}")

        //Quiz 3-9
        var fortune: String
        for (i in 1..10) {
            fortune = getFortuneCookie(getBirthday())
            println("\nYour fortune is: $fortune")
            if (fortune.contains("Take it easy")) break;
        }

    }

    fun dingus() {
        val isUnit = println("This is an expression")
        println(isUnit)

        val temp = 10
        val isHot = temp >50
        //println(isHot)

        val message = "You are ${ if(isHot) "too hot" else "alright"}"
        println(message)
    }

    fun lesson35(time: String) {
        var intTime = time.toInt()
        println(when (intTime) {
            in 0..12 -> "good morning"
            else -> "good night"
        })
        //their advanced solution
        //println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good night, Kotlin"}")
    }

    fun dayOfWeek() {
        println("What day is it today?\n")
        //println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))
        println (when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            1 -> "Sunday"
            2 -> "Monday"
            3 -> "Tuesday"
            4 -> "Wednesday"
            5 -> "Thursday"
            6 -> "Friday"
            7 -> "Saturday"
            else -> "got problems"
        })
    }

    //Less 3-6
    fun feedTheFish() {
        val day = randomDay()
        val food = fishFood(day)
        println("Today is $day and the fish eat $food")
    }

    fun randomDay(): String {
        val week = listOf<String>("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        return week[Random().nextInt(7)]
    }

    fun fishFood(day: String) : String {
        var food = "fasting"

        return when (day) {
            "Monday" -> "flakes"
            "Tuesday" -> "pellets"
            "Wednesday" -> "redworms"
            "Thursday" -> "granules"
            "Friday" -> "mosquitoes"
            "Saturday" -> "lettuce"
            "Sunday" -> "plankton"
            else -> "fasting"
        }
    }

    //Lesson 3 quiz 7
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
    //trying to get this on github for these test function tracking things. Nope. Actually yes, just looking at wrong branch :(
}