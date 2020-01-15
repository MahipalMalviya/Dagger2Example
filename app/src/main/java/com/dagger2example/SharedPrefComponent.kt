package com.dagger2example

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SharedPrefModule::class])
interface SharedPrefComponent {
    fun inject(context: MainActivity)
}