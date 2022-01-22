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
        //feedTheFish()

        //Test cases for fitting more fish
        //fitMoreFish(10.0, listOf(3,3,3))
        //fitMoreFish(8.0, listOf(2,2,2), hasDecorations = false)
        //fitMoreFish(9.0, listOf(1,1,3), 3)
        //fitMoreFish(10.0, listOf(), 7, true)

        //3-13
        //println(whatShouldIDoToday("sad"))
        //println(whatShouldIDoToday("happy"))
        //println(whatShouldIDoToday("wat"))
    }

    //default first, no default next
    fun shouldChangeWater(
        day: String,
        temperature: Int = 22,
        dirty: Int = 20): Boolean {
        return true
    }

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
            mood == "happy" && weather == "sunny" -> "go for a walk"
            mood == "wat" -> "do wat"
            else -> "Stay home and read."
        }

    }

}