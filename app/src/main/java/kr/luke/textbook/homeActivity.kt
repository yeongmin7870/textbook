package kr.luke.textbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.luke.textbook.databinding.ActivityHomeBinding

class homeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityHomeBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val book_item = mutableListOf<book>()
        book_item.add(book("파이썬","박영민","30,000"))


        val listview = findViewById<ListView>(R.id.lv_textbook)

        val bookAdapter = bookListAdapter(book_item)

        listview.adapter = bookAdapter


        val logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            Firebase.auth.signOut()
            startActivity(intent)
            finish()
        }

    }
}