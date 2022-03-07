package kr.luke.textbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kr.luke.textbook.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()

         val currentUser = auth.currentUser
         val intent = Intent(this,homeActivity::class.java)

        if(currentUser != null){
            startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        auth = Firebase.auth



        binding.btnLogin.setOnClickListener {
            var email = binding.etEmail.text.toString()
            var password = binding.etPasswd.text.toString()


            if (email.equals("") || password.equals("")) {
                Toast.makeText(this, "빈칸 없이 입력해주세요", Toast.LENGTH_SHORT).show()

            } else {

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "로그인 성공했습니다.", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, homeActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "아이디나 비밀번호가 틀리셨습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        binding.btnRegister.setOnClickListener {

            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

    }
}