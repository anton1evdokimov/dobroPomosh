package com.dobro.dobro.domain.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dobro.dobro.data.api.models.EventsApiModel
import com.dobro.dobro.databinding.EventItemBinding

class EventsAdapter(private val eventsList: ArrayList<EventsApiModel>) :
    RecyclerView.Adapter<EventsAdapter.EventsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsHolder {
        val binding: EventItemBinding =
            EventItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventsHolder(binding)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    override fun onBindViewHolder(holder: EventsHolder, position: Int) {
        holder.bind(eventsList[position])
    }

    class EventsHolder(val binding: EventItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            events: EventsApiModel
        ) {

            val idCategory = events.id
            binding.idCategory.text = idCategory.toString()
            binding.nameCategory.text = events.name
        }
    }
}