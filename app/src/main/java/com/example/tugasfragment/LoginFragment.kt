package com.example.tugasfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tugasfragment.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater)
        with(binding){
            SubmitButton.setOnClickListener(){
                if (InputEmail.text.equals("")){
                    Toast.makeText(requireActivity(), "Mohon masukan email", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (InputPassword.text.equals("")){
                    Toast.makeText(requireActivity(), "Mohon masukan password", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val SharedData = requireActivity().getSharedPreferences("Data", 0)

                val dataEmail = SharedData.getString("email", "")
                val dataPassword = SharedData.getString("password", "")

                if (InputEmail.text.toString() != dataEmail){
                    Toast.makeText(requireActivity(), "Email tidak terdaftar", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (InputPassword.text.toString() != dataPassword){
                    Toast.makeText(requireActivity(), "Password salah", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val intentToDashboardActivity = Intent(requireActivity(), DashboardActivity::class.java)

                intentToDashboardActivity.putExtra("email", InputEmail.text.toString())
                intentToDashboardActivity.putExtra("password", InputPassword.text.toString())
                intentToDashboardActivity.putExtra("fullname", SharedData.getString("fullname", ""))
                intentToDashboardActivity.putExtra("username", SharedData.getString("username", ""))

                startActivity(intentToDashboardActivity)


            }
        }
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




}