package com.obvious.vijay.nasapicturesapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.obvious.vijay.nasapicturesapp.R
import com.obvious.vijay.nasapicturesapp.databinding.FragmentDetailPagerBinding
import com.obvious.vijay.nasapicturesapp.model.NasaModel

class PhotoDetailPagerFragment: Fragment() {

    private var _binding: FragmentDetailPagerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPagerBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//binding.buttonSecond.setText(arguments?.getParcelable<NasaModel>("DATA")?.title)
        val media = arguments?.get("hdurl")
        if (media !== null) {
            Glide.with(requireActivity())
                .load(media)
                .into(binding.imageView)
        } else {
            binding.imageView.setImageResource(R.drawable.ic_launcher_background)
        }
//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_DetailFragment_to_GridFragment)
//        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {

        // Method for creating new instances of the fragment
        fun newInstance(data: NasaModel): PhotoDetailPagerFragment {

            // Store the movie data in a Bundle object
            val args = Bundle()
            args.putString("hdurl", data.hdurl)


            // Create a new MovieFragment and set the Bundle as the arguments
            // to be retrieved and displayed when the view is created
            val fragment = PhotoDetailPagerFragment()
            fragment.arguments = args
            return fragment
        }
    }
}