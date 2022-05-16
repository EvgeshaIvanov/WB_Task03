package com.example.layoutpackages.layout.linear

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.layoutpackages.R
import com.example.layoutpackages.databinding.FragmentTelegrammProfileBinding


class TelegrammProfile : Fragment() {

    private lateinit var binding: FragmentTelegrammProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTelegrammProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            activity?.window?.statusBarColor = activity?.getColor(R.color.telegramm_color)!!
        }
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.containerView, SecondMenuFragment()).commit()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
        binding.backButton.setOnClickListener { navigate(SecondMenuFragment()) }
    }

    private fun navigate(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
    }
}