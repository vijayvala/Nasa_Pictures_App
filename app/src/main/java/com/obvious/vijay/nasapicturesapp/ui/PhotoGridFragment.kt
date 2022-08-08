package com.obvious.vijay.nasapicturesapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.GsonBuilder
import com.obvious.vijay.nasapicturesapp.R

import com.obvious.vijay.nasapicturesapp.databinding.PhotoGridFragmentBinding
import com.obvious.vijay.nasapicturesapp.model.NasaModel
import com.obvious.vijay.nasapicturesapp.model.Utils
import com.obvious.vijay.nasapicturesapp.ui.adapter.PhotoAdapter
import com.obvious.vijay.nasapicturesapp.ui.listener.OnItemClick


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PhotoGridFragment : Fragment(),OnItemClick {

    private var _binding: PhotoGridFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    private lateinit var  photoAdapter: PhotoAdapter
    private var dataList = mutableListOf<NasaModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PhotoGridFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.layoutManager = GridLayoutManager(requireActivity().application,2)
        photoAdapter = PhotoAdapter(requireActivity().application,this)
        binding.recyclerView.adapter = photoAdapter

        val jsonString = Utils.getJsonDataFromAsset(requireActivity().applicationContext, "data.json")
        jsonString?.let {
            val dataList=GsonBuilder().create().fromJson(it,Array<NasaModel>::class.java)
            photoAdapter.setDataList(dataList)
        }


//        binding.recyclerView.setOnClickListener {
//
//        }
    }

    override fun <T> onClick(data: T) {
          findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundleOf("DATA" to  (data as NasaModel) ))
    }

    /* override fun onDestroyView() {
         super.onDestroyView()
         _binding = null
     }*/
}