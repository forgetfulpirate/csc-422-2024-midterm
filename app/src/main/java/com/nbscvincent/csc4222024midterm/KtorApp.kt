package com.nbscvincent.csc4222024midterm


import android.app.Application
import com.nbscvincent.csc4222024midterm.data.model.user.UserLoggedIn

class KtorApplication : Application() {

    /**
     * AppContainer instance used by the rest of classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        UserLoggedIn.init(this)
        container = AppDataContainer(this)
    }
}