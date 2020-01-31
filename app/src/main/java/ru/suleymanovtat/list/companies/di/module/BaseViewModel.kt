package ru.suleymanovtat.list.companies.di.module

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.exceptions.CompositeException
import retrofit2.HttpException
import ru.suleymanovtat.list.companies.App
import ru.suleymanovtat.list.companies.R
import java.net.UnknownHostException

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    var disposable: CompositeDisposable = CompositeDisposable()
    fun getContext() = getApplication<App>()
    fun getString(@StringRes id: Int): String = getContext().getString(id)
    fun getString(@StringRes id: Int, text: String): String = getContext().getString(id, text)

    fun onError(throwable: Throwable): String {
        var localThrowable = throwable
        if (localThrowable is CompositeException) {
            localThrowable = localThrowable.exceptions.first()
        }
        return when (localThrowable) {
            is UnknownHostException -> getString(R.string.no_internet_connection)
            is HttpException -> when {
                localThrowable.code() >= 500 -> getString(R.string.server_error)
                localThrowable.code() == 400 -> getString(R.string.unknown_error_has_occurred)
                else -> getString(R.string.unknown_error_has_occurred)
            }
            else -> getString(R.string.unknown_error_has_occurred)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}