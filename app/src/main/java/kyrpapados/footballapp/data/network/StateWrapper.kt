package kyrpapados.footballapp.data.network

import kyrpapados.footballapp.data.network.StateWrapper.Status.ERROR
import kyrpapados.footballapp.data.network.StateWrapper.Status.LOADING
import kyrpapados.footballapp.data.network.StateWrapper.Status.NO_INTERNET
import kyrpapados.footballapp.data.network.StateWrapper.Status.SUCCESS


class StateWrapper<T> constructor(var status: Status,var data: T?,var throwable: Throwable?){
   /* val status: Status
    val data: T?
    val throwable: Throwable?
*/
   /* constructor(status: Status, data: T?, throwable: Throwable?) {
        this.status = status
        this.data = data
        this.throwable = throwable
    }*/


    /*constructor(status: Status) : this() {
        this.status = status
    }*/

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        NO_INTERNET
    }

    companion object {

        fun <T> success(data: T?): StateWrapper<T> {
            return StateWrapper(SUCCESS, data, null)
        }

        fun <T> error(throwable: Throwable, data: T?): StateWrapper<T> {
            return StateWrapper(ERROR, data, throwable)
        }

       /* fun <T> noInternetError(): StateWrapper<Any> {
            return StateWrapper<Any>(NO_INTERNET)
        }*/

        fun <T> loading(data: T?): StateWrapper<T> {
            return StateWrapper(LOADING, data, null)
        }
    }
}