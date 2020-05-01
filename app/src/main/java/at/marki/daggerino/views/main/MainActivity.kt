package at.marki.daggerino.views.main

import android.os.Bundle
import at.marki.daggerino.R
import at.marki.daggerino.databinding.ActivityMainBinding
import at.marki.daggerino.views.BaseActivity
import at.marki.daggerino.views.calculator.CalculatorFragment

class MainActivity : BaseActivity() {

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
