package ie.wit.donationx.models

import timber.log.Timber

var lastId = 10L

internal fun getId(): Long {
    return lastId++
}

object DonationManager : DonationStore {

    private val donations = ArrayList<DonationModel>()

    override fun findAll(): List<DonationModel> {
        return donations
    }

    override fun create(donation: DonationModel) {
        donation.id = getId()
        donations.add(donation)
        logAll()
    }

    /*   override fun update(donation: DonationModel) {
           val index = donations.indexOfFirst { it.id == donation.id }
           if (index >= 0) {
               donations[index] = donation
               logAll()
           }
       }

       override fun deleteById(id: Long) {
           val index = donations.indexOfFirst { it.id == id }
           if (index >= 0) {
               donations.removeAt(index)
               logAll()
           }
       }*/

    override fun findById(id:Long) : DonationModel? {
        val foundDonation: DonationModel? = donations.find { it.id == id }
        return foundDonation
    }
//create 2 - dimension - store

    //edit - pass donationmodel - findbyid , update founddon.description= don.desc
    //delete- pass donatim - find, remove from list

    private fun logAll() {
        Timber.v("** Donations List **")
        donations.forEach { Timber.v("Donate ${it}") }
    }
}