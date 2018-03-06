package org.hrytsiuk.deviantart.deviantartkotlin.base

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import org.hrytsiuk.deviantart.deviantartkotlin.base.mvp.BaseView

@SuppressLint("Registered")
 open class BaseActivity : AppCompatActivity(), BaseView {
    override fun showProgress(visible: Boolean) {
        //--
    }
}