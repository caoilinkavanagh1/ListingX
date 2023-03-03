package ie.wit.donationx.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ie.wit.donationx.R
import ie.wit.donationx.databinding.FragmentDonationDetailBinding
import ie.wit.donationx.models.DonationManager


class DonationDetailFragment : Fragment() {

    companion object {
        fun newInstance() = DonationDetailFragment()
    }

    private lateinit var viewModel: DonationDetailViewModel
    private val args by navArgs<DonationDetailFragmentArgs>()
    private var _fragBinding: FragmentDonationDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val fragBinding get() = _fragBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       // val view = inflater.inflate(R.layout.fragment_donation_detail, container, false)
        _fragBinding = FragmentDonationDetailBinding.inflate(inflater, container, false)
        val root = fragBinding.root
        activity?.title = getString(R.string.editTitle)
        var foundDonation = DonationManager.findById(args.donationid)
        if (foundDonation != null) {
            fragBinding.description.text = foundDonation.description
            fragBinding.amount.text = foundDonation.amount.toString()
            fragBinding.jobmethod.text = foundDonation.jobmethod
            fragBinding.editPaymenttype.text = foundDonation.paymentmethod
            fragBinding.username.text = foundDonation.username
            fragBinding.area.text = foundDonation.area
            //add listener edit + delete - oncreateview() -toast
        }

    Toast.makeText(context,"Task Selected",Toast.LENGTH_LONG).show()

        return root
    }
}