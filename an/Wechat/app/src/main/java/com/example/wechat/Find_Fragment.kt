package com.example.wechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Find_Fragment : Fragment() {
    override fun onCreateView(inflator : LayoutInflater, container : ViewGroup?,  savedInstanceState : Bundle?) : View?{
        val view = inflator.inflate(R.layout.find_fragment, null)
        return view
    }
}
