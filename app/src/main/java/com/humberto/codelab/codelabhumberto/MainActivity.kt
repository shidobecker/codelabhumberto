package com.humberto.codelab.codelabhumberto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
    }


    companion object {
        const val MAIN_ACTIVITY_EXTRA = "MAIN_ACTIVITY_EXTRA"
    }


    private fun setupViews() {
        button_go_to_screen.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra(MAIN_ACTIVITY_EXTRA, getString(R.string.whos_gonna_participate))
            startActivity(intent)
        }

    }


}
