package com.obvious.vijay.nasapicturesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.obvious.vijay.nasapicturesapp.R
import com.obvious.vijay.nasapicturesapp.databinding.PhotoDetailFragmentBinding

import com.obvious.vijay.nasapicturesapp.model.NasaModel
import com.obvious.vijay.nasapicturesapp.ui.adapter.PhotoDetailPagerAdapter


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class PhotoDetailFragment : Fragment() {
    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: PhotoDetailPagerAdapter
    private var _binding: PhotoDetailFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = PhotoDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    viewPager = binding.pager


 val data = arguments?.getParcelableArray("DATA")
        val position  = arguments?.getInt("position")

        pagerAdapter= PhotoDetailPagerAdapter(getParentFragmentManager(),data as Array<NasaModel>)
     viewPager.adapter=pagerAdapter
        if (position != null) {
            viewPager.setCurrentItem(position,true)
        }
//binding.buttonSecond.setText(arguments?.getParcelable<NasaModel>("DATA")?.title)
//        val media = arguments?.getParcelable<NasaModel>("DATA")?.hdurl
//        if (media !== null) {
//            Glide.with(requireActivity())
//                .load(media)
//                .into(binding.imageView)
//        } else {
//            binding.imageView.setImageResource(R.drawable.ic_launcher_background)
//        }
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_DetailFragment_to_GridFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}