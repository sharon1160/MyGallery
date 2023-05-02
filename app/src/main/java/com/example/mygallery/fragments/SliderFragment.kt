package com.example.mygallery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mygallery.ViewPagerAdapter
import com.example.mygallery.databinding.FragmentSliderBinding

class SliderFragment : Fragment() {

    private var _binding: FragmentSliderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSliderBinding.inflate(inflater, container, false)
        val imagesList: ArrayList<String> = arguments?.getStringArrayList("imagesList") ?: arrayListOf()

        val viewPager: ViewPager2 = binding.slider
        viewPager.adapter = ViewPagerAdapter(imagesList)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.indicator.setViewPager(viewPager)


        return binding.root
    }
}