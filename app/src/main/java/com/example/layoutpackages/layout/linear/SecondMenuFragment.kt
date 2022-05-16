package com.example.layoutpackages.layout.linear

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.layoutpackages.layout.constraint.FirstMenuFragment
import com.example.layoutpackages.R
import com.example.layoutpackages.databinding.FragmentSecondMenuBinding


class SecondMenuFragment : Fragment() {

    private lateinit var binding: FragmentSecondMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity?.window?.statusBarColor = activity?.getColor(R.color.toolbar_color_menu)!!
        }
        binding.apply {
            nextMenu.setOnClickListener {
                navigate(FirstMenuFragment())
            }
            previousMenu.setOnClickListener {
                navigate(FirstMenuFragment())
            }
            profileButton.setOnClickListener {
                navigate(TelegrammProfile())
            }
            playerButton.setOnClickListener {
                navigate(AudioPlayer())
            }
            calculatorButton.setOnClickListener {
                navigate(Calculator())
            }
            authorizationButton.setOnClickListener {
                navigate(Facebook())
            }

        }
    }

    private fun navigate (fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
    }
}