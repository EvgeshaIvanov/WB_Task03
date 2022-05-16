package com.example.layoutpackages.layout.constraint


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.layoutpackages.R
import com.example.layoutpackages.databinding.FragmentTelegrammProfileCLBinding


class TelegrammProfileCL : Fragment() {

    private lateinit var binding: FragmentTelegrammProfileCLBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTelegrammProfileCLBinding.inflate(inflater, container, false)
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
                    .replace(R.id.containerView, FirstMenuFragment()).commit()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
        binding.backButton.setOnClickListener { launchFragment(FirstMenuFragment()) }
    }

    private fun launchFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
    }
}