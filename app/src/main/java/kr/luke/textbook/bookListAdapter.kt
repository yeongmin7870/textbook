package kr.luke.textbook
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class bookListAdapter(val List:MutableList<book>) : BaseAdapter(){
    override fun getCount(): Int {
       return List.size
    }

    override fun getItem(p0: Int): Any {
        return List[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
        var converView = converView

        if(converView == null){
            converView=
                LayoutInflater.from(parent?.context).inflate(R.layout.home_lv_item,parent,false)
        }

        val title = converView!!.findViewById<TextView>(R.id.tv_title)
        val author = converView!!.findViewById<TextView>(R.id.tv_author)
        val price = converView!!.findViewById<TextView>(R.id.tv_price)
        title.text = List[position].title
        author.text = List[position].author
        price.text = List[position].price


        return converView!!
    }

}