package com.techyourchance.dagger2course.screens.questiondetails

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techyourchance.dagger2course.R
import com.techyourchance.dagger2course.screens.base.BaseViewMvc
import com.techyourchance.dagger2course.screens.common.toolbar.MyToolbar

class QuestionDetailViewMvc(layoutInflater: LayoutInflater, parent: ViewGroup?, layoutId: Int) :
    BaseViewMvc(layoutInflater, parent, layoutId) {

    private val txtQuestionBody: TextView
    private val toolbar: MyToolbar
    private val swipeRefresh: SwipeRefreshLayout

    interface Listener {
        fun onNavigationUpClicked()
    }

    private val listeners = HashSet<Listener>()

    init {

        txtQuestionBody = findViewById(R.id.txt_question_body)

        // init toolbar
        toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigateUpListener {
            for (listener in listeners) {
                listener.onNavigationUpClicked()
            }
        }

        // init pull-down-to-refresh (used as a progress indicator)
        swipeRefresh = findViewById(R.id.swipeRefresh)
        swipeRefresh.isEnabled = false
    }


    public fun setQuestionBodyText(questionBody: String) {
        txtQuestionBody.text = questionBody
    }


    fun registerListener(listner: Listener) {
        listeners.add(listner)
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }


    fun showProgressIndication() {
        swipeRefresh.isRefreshing = true
    }

    fun hideProgressIndication() {
        swipeRefresh.isRefreshing = false
    }

}