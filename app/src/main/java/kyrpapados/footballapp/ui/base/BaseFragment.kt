package kyrpapados.footballapp.ui.base

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import kyrpapados.footballapp.R
import kyrpapados.footballapp.R.string.hello_blank_fragment


abstract class BaseFragment : DaggerFragment(), BaseContract.IView {
    /**
     * A dialog showing a progress indicator and an optional text message or
     * view.
     */
    protected var mProgressDialog: ProgressDialog? = null

    @LayoutRes
    abstract fun setLayout():Int
    abstract fun attachView()
    abstract fun detachView()
    abstract fun handleArguments()
    abstract fun init(savedInstanceState: Bundle?)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachView()
        handleArguments()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(setLayout(), container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialzeProgressDialoge()
        init(savedInstanceState)
    }

    fun initialzeProgressDialoge() {

        if (mProgressDialog == null) {

            mProgressDialog = ProgressDialog(context)
            //mProgressDialog?.setMessage(resources.getString(R.string.hello_blank_fragment))
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        detachView()
        dismissProgress()
        mProgressDialog = null
    }

    fun showProgress(msgResId: Int,
                     keyListener: DialogInterface.OnKeyListener?) {

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
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }


    /*
    Improper handling in real case
     */

    protected fun showHttpError(e: Throwable) {
        loadError(e.localizedMessage)
    }
}