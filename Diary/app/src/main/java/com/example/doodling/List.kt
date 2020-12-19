package com.example.doodling

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.list.*

data class  Card(val date_list : String, val content_list : String )

class List : Fragment(){

    val CardList = ArrayList<Card>()
    private lateinit var listAdater : listAdapter

    override fun getContext(): Context? {
        return super.getContext()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.list,container,false)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CardList.add(Card("date","content"))
        CardList.add(Card("date","content"))
        CardList.add(Card("date","content"))
        CardList.add(Card("date","content"))
        CardList.add(Card("date","content"))
        listAdater = listAdapter(this.requireActivity(),CardList)
        list.adapter = listAdater

        list.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this.requireActivity(), position.toString(), Toast.LENGTH_SHORT).show()

        }


    }

}