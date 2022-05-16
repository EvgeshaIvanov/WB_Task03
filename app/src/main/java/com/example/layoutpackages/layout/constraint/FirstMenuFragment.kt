package com.example.layoutpackages.layout.constraint

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.layoutpackages.R
import com.example.layoutpackages.databinding.FragmentFirstMenuBinding
import com.example.layoutpackages.layout.linear.SecondMenuFragment


class FirstMenuFragment : Fragment() {
    private lateinit var binding: FragmentFirstMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity?.window?.statusBarColor = activity?.getColor(R.color.toolbar_color_menu)!!
        }
        binding.apply {
            authorizationButton.setOnClickListener { launchFragment(FacebookCL()) }

            nextMenu.setOnClickListener { launchFragment(SecondMenuFragment()) }

            previousMenu.setOnClickListener { launchFragment(SecondMenuFragment()) }

            profileButton.setOnClickListener { launchFragment(TelegrammProfileCL()) }

            playerButton.setOnClickListener { launchFragment(AudioPlayerCL()) }

            calculatorButton.setOnClickListener { launchFragment(CalculatorCL()) }
        }

    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.containerView, fragment)
            .commit()
    }



}