package com.example.wechat

import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment

class Wechat_Fragment : Fragment() {
    override fun onCreateView(inflator : LayoutInflater, container : ViewGroup?,  savedInstanceState : Bundle?) : View?{
        val view = inflator.inflate(R.layout.wechat_fragment, null)
        return view
    }
}