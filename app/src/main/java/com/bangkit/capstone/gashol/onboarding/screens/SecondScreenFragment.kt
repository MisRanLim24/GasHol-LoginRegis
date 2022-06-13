package com.bangkit.capstone.gashol.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.capstone.gashol.R
import com.bangkit.capstone.gashol.databinding.FragmentSecondScreenBinding

@Suppress("DEPRECATION")
class SecondScreenFragment : Fragment() {

    private lateinit var binding : FragmentSecondScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondScreenBinding.inflate(layoutInflater)

        /*val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        *//*binding.buttonNextScreen2.setOnClickListener {
            viewPager?.currentItem = 2
        }*/

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        (requireActivity() as AppCompatActivity).window.statusBarColor = this.resources.getColor(R.color.bright_yellow)
        (requireActivity() as AppCompatActivity).window.navigationBarColor = this.resources.getColor(R.color.white)
    }

}