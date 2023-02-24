package ie.wit.donationx.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ie.wit.donationx.R
import ie.wit.donationx.databinding.CardDonationBinding
import ie.wit.donationx.models.DonationModel

interface DonationClickListener {
    fun onDonationClick(donation: DonationModel)
}

class DonationAdapter constructor(private var donations: List<DonationModel>,
                                  private val listener: DonationClickListener)
    : RecyclerView.Adapter<DonationAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardDonationBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val donation = donations[holder.adapterPosition]
        holder.bind(donation,listener)
    }

    override fun getItemCount(): Int = donations.size

    inner class MainHolder(val binding : CardDonationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(donation: DonationModel, listener: DonationClickListener) {
//            binding.paymentamount.text = donation.amount.toString()
//            binding.paymentmethod.text = donation.paymentmethod
            binding.jobmethod.text = donation.jobmethod
            binding.area.text = donation.area
            binding.username.text = donation.username
            binding.description.text = donation.description
            binding.donation = donation
           // binding.imageIcon.setImageResource(R.drawable.ic_menu_aboutus)
            binding.root.setOnClickListener { listener.onDonationClick(donation) }
            binding.executePendingBindings()
        }
    }
}