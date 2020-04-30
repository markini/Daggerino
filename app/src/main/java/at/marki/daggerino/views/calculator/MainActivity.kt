package at.marki.daggerino.views.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import at.marki.daggerino.app.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.content,
                    CalculatorFragment.newInstance(), "calculator")
                .commit()
        }
    }
}
