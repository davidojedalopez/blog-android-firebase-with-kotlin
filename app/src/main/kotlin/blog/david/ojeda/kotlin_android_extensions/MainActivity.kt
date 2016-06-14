package blog.david.ojeda.kotlin_android_extensions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // Do something...
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // Do something...
            }

            override fun afterTextChanged(s: Editable) {
                // Do something...
            }
        })

        button!!.setOnClickListener {
            // Do something...
        }

        switch1!!.setOnCheckedChangeListener { buttonView, isChecked ->
            // Do something...
        }

        switch2!!.setOnCheckedChangeListener { buttonView, isChecked ->
            // Do something...
        }

        switch3!!.setOnCheckedChangeListener { buttonView, isChecked ->
            // Do something...
        }

        textView!!.text = "Woh, a ListView!"

        val items = ArrayList<String>()
        items.add("first")
        items.add("second")
        items.add("third")
        items.add("fourth")
        items.add("fifth")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listView!!.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener {
            adapter, v, position, arg3 -> // Do something...
        }

        button2!!.setOnClickListener {
            // Do something...
        }
    }
}
