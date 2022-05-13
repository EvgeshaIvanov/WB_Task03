package com.example.layoutpackages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.apply {
            authorizationButton.setOnClickListener {
                navigate(Authorization())
            }
            nextArrow.setOnClickListener {
                navigate(MenuFragment())
            }
            previousArrow.setOnClickListener {
                navigate(MenuFragment())
            }
            profileButton.setOnClickListener {
                navigate(ProfilePageCl())
            }
            playerButton.setOnClickListener {
                navigate(AudioPlayerCl())
            }
        }
    }
    private fun navigate (fragment: Fragment) {
        parentFragmentManager.beginTransaction().replace(R.id.containerView, fragment).commit()
    }
}