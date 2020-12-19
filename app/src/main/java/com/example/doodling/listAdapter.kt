package com.example.doodling

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.list_item.view.*;

class listAdapter(context: Context, private val CardList:ArrayList<Card>) :BaseAdapter(){

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = CardList.size
    override fun getItem(position: Int): Any = CardList[position]

    override fun getItemId(position: Int): Long =position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        view = inflater.inflate(R.layout.list_item, parent, false)
        view.date_list.text = CardList[position].date_list
        view.content_list.text = CardList[position].content_list

        return view
    }
}