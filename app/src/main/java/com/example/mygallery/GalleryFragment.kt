package com.example.mygallery

import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygallery.databinding.FragmentGalleryBinding
import com.google.android.material.tabs.TabLayout.TabGravity
import java.io.File

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val images: Array<String> = arrayOf(
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2",
            "https://picsum.photos/id/1060/536/354?blur=2"
        )

        val adapter = GridItemAdapter(images)

        val gridLayout = GridLayoutManager(requireContext(), 2).also {
            it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position % 3 == 0)
                        2
                    else
                        1
                }
            }
        }

        binding.gridItems.layoutManager = gridLayout
        binding.gridItems.adapter = adapter
        return binding.root
    }
}