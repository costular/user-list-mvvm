package io.keepcoding.userlist.presentation.userlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.keepcoding.userlist.R
import io.keepcoding.userlist.data.model.UserEntity
import io.keepcoding.userlist.presentation.userdetail.UserDetailActivity
import io.keepcoding.userlist.util.Navigator
import kotlinx.android.synthetic.main.activity_main.*

class UserListActivity : AppCompatActivity() {

    lateinit var userListViewModel: UserListViewModel

    private val adapter = UserListAdapter { onUserClicked(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecycler()
        setUpViewModel()
    }

    private fun setUpRecycler() {
        userListRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        userListRecycler.itemAnimator = DefaultItemAnimator()
        userListRecycler.adapter = adapter
    }

    private fun setUpViewModel() {
        userListViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)
        bindEvents()
        userListViewModel.loadUserList()
    }

    private fun bindEvents() {
        userListViewModel.isLoadingState.observe(this, Observer { isLoading ->
            isLoading?.let {
                showLoading(it)
            }
        })

        userListViewModel.userListState.observe(this, Observer { userList ->
            userList?.let {
                onUserListLoaded(it)
            }
        })
    }

    private fun onUserListLoaded(userList: List<UserEntity>) {
        adapter.submitList(userList)
    }

    private fun showLoading(isLoading: Boolean) {
        userListLoading.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    private fun onUserClicked(userEntity: UserEntity) {
        Navigator.openUserDetail(this, userEntity)
    }
}
