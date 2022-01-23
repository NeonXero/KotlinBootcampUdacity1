package net.neonlotus.kotlinaquarium

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import net.neonlotus.kotlinaquarium.aquarium.Aquarium
import net.neonlotus.kotlinaquarium.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        //Using this as the jump off point for lesson 4
        fishMain()
    }

    fun fishMain() {
        buildAquarium()
    }

    private fun buildAquarium() {
        val myAquarium = Aquarium()

        println("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} " +
            "Height: ${myAquarium.height}")

        myAquarium.height = 80
        println("New height: ${myAquarium.height} cm")
        println("Volume: ${myAquarium.volume} liters")

        val smallAquarium = Aquarium(length = 20,width = 15,height = 30)
        println("Volume small: ${smallAquarium.volume} liters")


        val myAquarium2 = Aquarium(numberOfFish = 9)
        println("Small aquarium2: ${myAquarium2.volume} liters with " +
                "Length: ${myAquarium2.length} " +
                "Width: ${myAquarium2.width} " +
                "Height: ${myAquarium2.height}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}