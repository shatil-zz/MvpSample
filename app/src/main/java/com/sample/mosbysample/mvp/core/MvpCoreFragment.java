package com.sample.mosbysample.mvp.core;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public abstract class MvpCoreFragment<V extends MvpCoreView, P extends MvpCorePresenter<V>> extends MvpFragment<V,P>{
}
