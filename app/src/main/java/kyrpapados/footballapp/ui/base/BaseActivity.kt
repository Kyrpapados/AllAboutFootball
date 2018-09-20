package kyrpapados.footballapp.ui.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.View
import android.widget.Toast
import com.bumptech.glide.request.target.Target
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.utils.GlideApp


abstract class BaseActivity : DaggerAppCompatActivity(), BaseContract.IView {
    /**
     * A dialog showing a progress indicator and an optional text message or
     * view.
     */
    private var mProgressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this) // Call before super!
        super.onCreate(savedInstanceState)
        attachView()
        setContentView(setLayout())
        handleIntent(intent)
        setupAppbar(getActivityTitle(), getActivityLogo(), getLocalLogo())
        initialzeProgressDialoge()
        init(savedInstanceState)

    }

    protected fun setupAppbar(title: String?, logoUrl: String?, logoLocal: Int) {
        if (toolbar != null) {

            if (logoUrl != null) {
                logo!!.visibility = View.VISIBLE

                GlideApp.with(this)
                        .load(logoUrl)
                        .error(logoLocal)
                        .override(Target.SIZE_ORIGINAL)
                        .into(logo)
            } else if (logoLocal != 0) {
                logo!!.visibility = View.VISIBLE

                GlideApp.with(this)
                        .load(logoLocal)
                        .override(Target.SIZE_ORIGINAL)
                        .into(logo)
            }

            setSupportActionBar(toolbar)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
            toolbar!!.setNavigationOnClickListener({ v -> onBackPressed() })
        }
    }

    fun initialzeProgressDialoge() {

        if (mProgressDialog == null) {

            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        detachView()
        System.runFinalization()
        dismissProgress()
        mProgressDialog = null
    }


    @LayoutRes
    abstract fun setLayout(): Int

    abstract fun attachView()
    abstract fun detachView()
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun handleIntent(intent: Intent)
    abstract fun getActivityTitle(): String
    abstract fun getActivityLogo(): String
    abstract fun getLocalLogo(): Int

    fun showProgress(msgResId: Int,
                     keyListener: DialogInterface.OnKeyListener?) {
        if (isFinishing)
            return

        if (mProgressDialog!!.isShowing) {
            return
        }

        if (msgResId != 0) {
            mProgressDialog?.setMessage(resources.getString(msgResId))
        }

        if (keyListener != null) {
            mProgressDialog?.setOnKeyListener(keyListener)

        } else {
            mProgressDialog?.setCancelable(false)
        }
        mProgressDialog?.show()
    }

    /**
     * @param isCancel
     */
    fun setCancelableProgress(isCancel: Boolean) {
        if (mProgressDialog != null) {
            mProgressDialog?.setCancelable(true)
        }
    }

    /**
     * cancel progress dialog.
     */
    fun dismissProgress() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.dismiss()
        }
    }


    override fun hideLoading() {
        dismissProgress()
    }

    override fun showLoading() {
        showProgress(R.string.loading, null)
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


    /*
    Improper handling in real case
     */

    protected fun showHttpError(e: Throwable) {
        loadError(e.localizedMessage)
    }
}