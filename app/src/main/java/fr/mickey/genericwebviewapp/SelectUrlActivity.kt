package fr.mickey.genericwebviewapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import mickey.genericwebviewapp.R

class SelectUrlActivity : Activity() {
    // binding.etName.setText("9er9oura") // binding
    private val valueContainer: TextView by lazy { findViewById(R.id.editTextTextPersonName) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_url)
        val sharedPref = getSharedPreferences("localstorage", MODE_PRIVATE)
        valueContainer.text = sharedPref.getString("url", "")

    }

    fun saveUrl() {
        val sharedPref = getSharedPreferences("localstorage", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.apply {
            putString("url", valueContainer.text.toString())
            apply()
        }
    }

    fun hundleClick(view: android.view.View) {
        saveUrl()
        Intent(this@SelectUrlActivity, MainActivity::class.java).also {
            startActivity(it)
        }
        Toast.makeText(this, "new link ${valueContainer.text}", Toast.LENGTH_SHORT).show()

    }
}