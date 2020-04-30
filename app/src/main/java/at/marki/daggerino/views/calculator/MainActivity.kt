package at.marki.daggerino.views.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import at.marki.daggerino.app.R
import at.marki.daggerino.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(
                    R.id.content,
                    CalculatorFragment.newInstance(), "calculator"
                )
                .commit()
        }

        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Just in case
    }
}
