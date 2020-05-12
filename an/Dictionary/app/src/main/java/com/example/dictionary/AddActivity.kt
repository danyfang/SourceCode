package com.example.dictionary

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class AddActivity : AppCompatActivity() {

    private lateinit var dbOpenHelper: DBOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        dbOpenHelper = DBOpenHelper(this)
        val etWord = findViewById<EditText>(R.id.add_word)
        val etExplain = findViewById<EditText>(R.id.add_interpret)
        val btnSave = findViewById<ImageButton>(R.id.save_btn)
        val btnCancel = findViewById<ImageButton>(R.id.cancel_btn1)


        btnSave.setOnClickListener(View.OnClickListener {
            val word = etWord.text.toString()
            val explain = etExplain.text.toString()
             if(word == "" || explain == "") {
                 Toast.makeText(this, "Word or Explanation can not be empty",
                     Toast.LENGTH_SHORT).show()
             } else {
                 insertData(dbOpenHelper.readableDatabase, word,explain)
                 Toast.makeText(this, "Add word sucess",Toast.LENGTH_LONG).show()
             }
        })

        btnCancel.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun insertData(readableDatabase: SQLiteDatabase, word: String, explain: String) {
        val values = ContentValues()
        values.put("word", word)
        values.put("detail", explain)
        readableDatabase.insert("dict", null, values)
    }

    override fun onDestroy() {
        super.onDestroy()
        dbOpenHelper.close()
    }
}
