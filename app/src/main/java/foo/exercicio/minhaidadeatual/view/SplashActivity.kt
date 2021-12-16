package foo.exercicio.minhaidadeatual.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import foo.exercicio.minhaidadeatual.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.myLooper()!!).postDelayed(

            {
            val telaprincipal = Intent (this, MainActivity::class.java)
            startActivity(telaprincipal)
            finish()


            },10000

        )


    }
}