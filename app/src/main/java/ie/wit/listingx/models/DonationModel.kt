package ie.wit.donationx.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class DonationModel(
    var id: Long = 0,
    val paymentmethod: String = "N/A",
    val amount: Int = 0,
    val jobmethod: String = "",
    val area: String = "",
    val username: String = "",
    val description: String = "",
) : Parcelable