package com.alisson.mymoduleexample.feature.list

import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alisson.domain.entities.AndroidJob
import com.alisson.mymoduleexample.R
import com.alisson.mymoduleexample.extensions.inflate

class AndroidJobsAdapter: RecyclerView.Adapter<AndroidJobsAdapter.ViewHolder>() {

    var jobs: List<AndroidJob> = listOf()

    inner class ViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.item_android_job)) {

        fun bind(androidJob: AndroidJob) = with(itemView) {
            val txtTitle = this.findViewById<TextView>(R.id.txtTitle)
            val txtCountry = this.findViewById<TextView>(R.id.txtCountry)
            val txtYears = this.findViewById<TextView>(R.id.txtYears)
            val chkNative = this.findViewById<CheckBox>(R.id.chkNative)

            txtTitle.text = androidJob.title
            txtCountry.text = androidJob.country
            txtYears.text = androidJob.experienceTimeRequired.toString()

            chkNative.isChecked = androidJob.native
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent)
    override fun getItemCount(): Int = jobs.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(jobs[position])
}