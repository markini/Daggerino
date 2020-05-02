package at.marki.daggerino.worker

import androidx.work.Worker
import dagger.android.AndroidInjector

interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<Worker>
}
