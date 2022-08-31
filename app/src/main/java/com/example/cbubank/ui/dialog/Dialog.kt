package com.example.cbubank.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cbubank.R
import com.example.cbubank.data.models.ValyutData
import com.example.cbubank.databinding.ScreenDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Dialog(private val valyutData: ValyutData) : BottomSheetDialogFragment() {
    private lateinit var binding: ScreenDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = ScreenDialogBinding.inflate(inflater, container, false)

        binding.apply {
            tvName.text = valyutData.name
            secondName.text = valyutData.shortName
            tvDate.text = valyutData.date
            tvRate.text = valyutData.rate
            if (valyutData.diff.toDouble() > 0) {
                tvImg.setImageResource(R.drawable.profit)
            } else {
                tvImg.setImageResource(R.drawable.arrow)
            }
        }
        return binding.root
    }
}

