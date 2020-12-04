package net.T4.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.T4.data.repository.AuthRepository
import net.T4.data.repository.BaseRepository
import net.T4.data.repository.UserRepository
import net.T4.ui.auth.AuthViewModel
import net.T4.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(AuthViewModel::class.java) -> AuthViewModel(repository as AuthRepository) as T
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository as UserRepository) as T
            else -> throw IllegalArgumentException("ViewModelClass Not Found")
        }
    }

}