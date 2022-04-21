package com.hexalitics.testproject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.hexalitics.testproject.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (binding == null) {
            binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
            mContext = requireActivity()
            initViews()
        }
        return binding!!.root
    }

    private fun initViews() {
        val stringArrayList = ArrayList<String>()

        val imageList = ArrayList<SlideModel>() // Create image list

       // imageList.add(SlideModel("String Url" or R.drawable)
       // imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(SlideModel("https://cdn.lifehack.org/wp-content/uploads/2014/10/best-entrepreneur-books.jpeg", ""))
        imageList.add(SlideModel("https://cdn.lifehack.org/wp-content/uploads/2014/10/best-entrepreneur-books.jpeg", ""))
        imageList.add(SlideModel("https://cdn.lifehack.org/wp-content/uploads/2014/10/best-entrepreneur-books.jpeg", ""))


        binding!!.imageSlider.setImageList(imageList)

        binding!!.rvList.layoutManager = GridLayoutManager(mContext, 2,  GridLayoutManager.HORIZONTAL,  false)
        val topStoreListAdapter = TopStoreListAdapter(mContext, stringArrayList)
        binding!!.rvList.adapter = topStoreListAdapter
        topStoreListAdapter!!.setOnItemClickLitener(object :
            TopStoreListAdapter.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {

            }
        })
    }
}