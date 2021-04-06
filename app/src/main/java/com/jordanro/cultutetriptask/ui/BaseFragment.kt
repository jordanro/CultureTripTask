package com.jordanro.cultutetriptask.ui

import androidx.fragment.app.Fragment
import com.jordanro.cultutetriptask.application.NavigationComponent
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    @Inject
    lateinit var navComponent: NavigationComponent;
}