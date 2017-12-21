package com.example.lynas.listviewdemo

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import org.jetbrains.anko.*

class CustomAdapter(private val list : List<AppUser>) : BaseAdapter(){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val appUser = getItem(position)

        return with(parent!!.context){
            relativeLayout {
                val imageView = imageView {
                    id = 1
                }.lparams {
                    alignParentTop()
                    alignParentLeft()
                    width = 200
                    height = 200
                }
                val textView1 = textView {
                    id = 2
                }.lparams {
                    alignParentTop()
                    alignParentRight()
                    width = parent.width - 200
                    topMargin = 20
                    leftMargin = 20
                }
                val textView2 = textView {
                    id = 3
                }.lparams {
                    below(2)
                    alignParentRight()
                    width = parent.width - 200
                    topMargin = 20
                    leftMargin = 20
                }

                textView1.text = appUser.name
                textView2.text = appUser.description
                imageView.image = resources.getDrawable(R.drawable.p1)

            }
        }
    }

    override fun getItem(position: Int): AppUser {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getCount(): Int {
        return list.size
    }

}