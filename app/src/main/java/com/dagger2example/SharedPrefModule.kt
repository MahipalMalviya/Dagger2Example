package com.dagger2example

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module
class SharedPrefModule @Inject constructor(private val context: Context) {

    companion object {
        const val FILE_NAME = "shared"
    }

//    @Singleton
//    @Provides
//    fun provideContext() = context

    @Singleton
    @Provides
    fun provideSharedPref(): SharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
}