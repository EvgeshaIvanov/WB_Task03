package com.example.layoutpackages

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.layoutpackages.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity?.window?.statusBarColor = activity?.getColor(R.color.black)!!
        }
        binding.apply {
            authorizationButton.setOnClickListener {
                navigate(FacebookCL())
            }
            nextArrow.setOnClickListener {
                navigate(MenuFragment())
            }
            previousArrow.setOnClickListener {
                navigate(MenuFragment())
            }
            profileButton.setOnClickListener {
                navigate(TelegrammProfileCL())
            }
            playerButton.setOnClickListener {
                navigate(AudioPlayerCL())
            }
            calculatorButton.setOnClickListener {
                navigate(CalculatorCL())
            }
        }
    }


    private fun navigate (fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
    }
}