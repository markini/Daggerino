package at.marki.daggerino.tools

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.GERMANY
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TimeLogger @Inject constructor() {

    private val DATE_FORMAT = SimpleDateFormat("EE dd. MMM, HH:mm", GERMANY)

    fun logCurrentTime() {
        Timber.e("Date and Time: ${DATE_FORMAT.format(Date())}")
    }
}
