package at.marki.daggerino.views

import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

abstract class BasePresenter {
    @Inject
    lateinit var bus: EventBus

    fun register() {
        bus.register(this)
    }

    fun unregister() {
        bus.unregister(this)
    }
}
