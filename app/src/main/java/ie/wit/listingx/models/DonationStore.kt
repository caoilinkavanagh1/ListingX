package ie.wit.donationx.models

import androidx.lifecycle.MutableLiveData

interface DonationStore {
    fun findAll() : List<DonationModel>
    fun findById(id: Long) : DonationModel?
    fun create(donation: DonationModel)

   // fun update(donation: DonationModel)
    //fun deleteById(id: Long)

  //  fun findById(email:String, id: String, donation: MutableLiveData<DonationModel>)
    // fun deleteById(id: Long) : DonationModel?
}