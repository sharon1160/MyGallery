package com.example.mygallery.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.mygallery.PhotoAdapter
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

        binding.slider.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        binding.slider.adapter = PhotoAdapter(imagesList)

        val snapHelper:SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.slider)

        return binding.root
    }
}
