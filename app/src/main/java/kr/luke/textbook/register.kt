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
import kr.luke.textbook.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        val intent = Intent(this, MainActivity::class.java)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        super.onCreate(savedInstanceState)
        setContentView(view)

        binding.btnEmPw.setOnClickListener {

            var email = binding.etEmail.text.toString()
            var password = binding.etPasswd.text.toString()

            if (email.equals("") || password.equals("")) {
                Toast.makeText(this, "빈칸없이 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(this, "회원가입 되셨습니다.", Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(this, "회원가입 실패하셨습니다.", Toast.LENGTH_SHORT).show()

                        }
                    }
            }
        }

            binding.tvBack.setOnClickListener {
                finish()
            }



    }
}