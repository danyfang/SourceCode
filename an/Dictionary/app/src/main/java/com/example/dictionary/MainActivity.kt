package com.example.dictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var dbOpenHelper : DBOpenHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dbOpenHelper = DBOpenHelper(this)
        val listView = findViewById<ListView>(R.id.result_listView)
        val etSearch = findViewById<EditText>(R.id.search_et)
        val btnSearch = findViewById<Button>(R.id.search_btn)
        val btnAdd = findViewById<Button>(R.id.btn_add)


        btnAdd.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        })


        btnSearch.setOnClickListener(View.OnClickListener {
            val key = etSearch.text.toString()
            val cursor = dbOpenHelper.readableDatabase.query("dict",
                null, "word = ?", arrayOf<String>(key), null, null, null)
            val resultList = ArrayList<Map<String, String>>()
            while (cursor.moveToNext()) {
                val map = HashMap<String, String>()
                map.put("word", cursor.getString(1))
                map.put("explain", cursor.getString(2))
                resultList.add(map)
            }

            if (!etSearch.isFocused) {
                if(resultList == null || resultList.size == 0) {
                    Toast.makeText(this, "No such word found!", Toast.LENGTH_LONG).show()
                } else {
                    val simpleAdapter = SimpleAdapter(this, resultList, R.layout.result_main,
                        arrayOf("word","explain"), intArrayOf(R.id.result_word, R.id.result_interpret))
                    listView.adapter = simpleAdapter
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        dbOpenHelper.close()
    }
}
