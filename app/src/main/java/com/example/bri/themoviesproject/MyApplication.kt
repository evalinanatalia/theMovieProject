package com.example.bri.themoviesproject

import android.app.Application

import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by BRI on 10/10/2018.
 */

class MyApplication : Application() {

    override fun onCreate() {

        super.onCreate()
        Realm.init(applicationContext)
        val realmConfiguration = RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)

    }
}
