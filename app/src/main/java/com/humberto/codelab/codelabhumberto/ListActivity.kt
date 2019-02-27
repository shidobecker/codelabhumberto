package com.humberto.codelab.codelabhumberto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var nameAdapter: ListNameAdapter

    companion object {
        const val NAME_EXTRA = "NAME_EXTRA"
        const val AGE_EXTRA = "AGE_EXTRA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val title = intent.getStringExtra(MainActivity.MAIN_ACTIVITY_EXTRA)

        whos_gonna_win_text.text = title

        createList()
    }


    private fun createList() {
        val names = mutableListOf<Pair<String, String>>()

        names.add(Pair("Julio", "29"))
        names.add(Pair("Ramon", "22"))
        names.add(Pair("Humberto", "23"))
        names.add(Pair("Igor", "50"))
        names.add(Pair("Rangel", "21"))
        names.add(Pair("Carol", "22"))
        names.add(Pair("Lais", "23"))

        nameAdapter = ListNameAdapter{
            Toast.makeText(this@ListActivity, "${it.first} || ${it.second}", Toast.LENGTH_LONG).show()
        }

        with(list_recycler_view){
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = nameAdapter
        }

        nameAdapter.namesList = names
        nameAdapter.notifyDataSetChanged()

    }


}
