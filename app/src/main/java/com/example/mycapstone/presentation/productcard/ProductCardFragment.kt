package com.example.mycapstone.presentation.productcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.mycapstone.R
import com.example.mycapstone.databinding.FragmentProductCardBinding
import com.example.mycapstone.presentation.productcard.ForegroundWorker.Companion.ARG_PROGRESS


class ProductCardFragment : Fragment() {

    private lateinit var fragmentProductCardBinding: FragmentProductCardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductCardBinding=
            DataBindingUtil.inflate(inflater,R.layout.fragment_product_card,container,false)

        return fragmentProductCardBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fragmentProductCardBinding.back2.setOnClickListener {
            findNavController().navigate(R.id.action_productCardFragment_to_fashionSaleFragment)
        }

        val workManager = WorkManager.getInstance(getActivity()!!)

        fragmentProductCardBinding.button6.setOnClickListener {
            val workRequest = OneTimeWorkRequest.from(ForegroundWorker::class.java)
            workManager.getWorkInfoByIdLiveData(workRequest.id)
                .observe(getActivity()!!){ workInfo ->
                    if (workInfo != null){
                        val progress = workInfo.progress
                        val value = progress.getInt(ARG_PROGRESS,0)
                     //   fragmentProductCardBinding.progressBar.progress = value
                        if (workInfo.state == WorkInfo.State.SUCCEEDED){
                            fragmentProductCardBinding.button6.isEnabled = true
                        }
                    }
                }

            workManager.enqueue(workRequest)
            fragmentProductCardBinding.button6.isEnabled = false

        }
    }
}