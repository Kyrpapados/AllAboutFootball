package kyrpapados.footballapp.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePreseneter<V : BaseContract.IView> : BaseContract.Presenter<V> {
    lateinit var mView : V

    override fun onAttach(view: V) {
        mView = view
    }

    override fun onDetach() {
        compositeDisposables.clear()
        compositeDisposables.dispose()
        //mView = null
    }


    companion object {

        /*
        var compositeDisposables: CompositeDisposable
        Every method which will be part of presenter lyer will be added in it so we could dispose off them once they are no more in our use
        */
        var compositeDisposables: CompositeDisposable = CompositeDisposable()


    }


    init {


    }


    protected fun view(): V? {
        return mView
    }

    /*@CallSuper
    fun unbindView() {
        compositeDisposables.clear()
        compositeDisposables.dispose()
        this.view = null
    }*/

    fun addDisposable(disposable: Disposable) {
        compositeDisposables.add(disposable)
    }


}