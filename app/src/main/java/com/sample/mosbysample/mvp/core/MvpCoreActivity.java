package com.sample.mosbysample.mvp.core;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

/**
 * Created by Shahanur on 19-Mar-18.
 */

public abstract class MvpCoreActivity<V extends MvpCoreView, P extends MvpCorePresenter<V>> extends MvpActivity<V,P>{
}
