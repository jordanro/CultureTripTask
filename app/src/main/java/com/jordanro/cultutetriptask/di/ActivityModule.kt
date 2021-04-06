package com.jordanro.cultutetriptask.di

import android.app.Activity
import com.jordanro.cultutetriptask.application.NavigationComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule {

    @Provides
    fun provideCallback(activity: Activity) =
        activity as NavigationComponent


}