package com.example.mygallery

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygallery.databinding.FragmentGalleryBinding
import java.io.File

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    companion object{
        var selectedIdsList = mutableListOf<Int>()
        var selectedImagesList = mutableListOf<String>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val folder = Environment.getExternalStorageDirectory()
        val imagesList =
            File(folder, "Pictures/CameraX-image/").listFiles()?.map { it.path }?.toTypedArray()
                ?.reversedArray()

        val adapter = if (imagesList != null) {
            GridItemAdapter(imagesList)
        } else {
            GridItemAdapter(arrayOf())
        }

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
