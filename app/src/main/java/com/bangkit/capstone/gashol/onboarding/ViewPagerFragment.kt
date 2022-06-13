package com.bangkit.capstone.gashol.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.capstone.gashol.databinding.FragmentViewPagerBinding
import com.bangkit.capstone.gashol.onboarding.screens.FirstScreenFragment
import com.bangkit.capstone.gashol.onboarding.screens.SecondScreenFragment
import com.bangkit.capstone.gashol.onboarding.screens.ThirdScreenFragment

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentViewPagerBinding.inflate(layoutInflater)

        val fragmentList = arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment(),
        )

        val viewPagerAdapter = ViewPagerAdapter (
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = viewPagerAdapter

        return binding.root
    }

}