package com.example.mygallery.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mygallery.GridItemAdapter
import com.example.mygallery.R
import com.example.mygallery.databinding.FragmentGalleryBinding
import java.io.File

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    companion object {
        var selectedImagesList = mutableListOf<String>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        val folder = Environment.getExternalStorageDirectory()
        var imagesList =
            File(folder, "Pictures/CameraX-image/").listFiles()?.map { it.path }?.toTypedArray()
                ?.reversedArray()

        imagesList = imagesList ?: arrayOf()
        val adapter = GridItemAdapter(imagesList)

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

        binding.seeView.setOnClickListener { view: View ->
            if (selectedImagesList.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putStringArrayList("imagesList", ArrayList(selectedImagesList))
                Navigation.findNavController(view)
                    .navigate(R.id.action_galleryFragment_to_sliderFragment, bundle)
            } else {
                Toast.makeText(requireContext(), "No images selected", Toast.LENGTH_LONG).show()
            }
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        selectedImagesList = mutableListOf<String>()
    }
}
