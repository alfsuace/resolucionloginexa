package edu.iesam.loginexam1eval.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.loginexam1eval.databinding.FragmentSingupBinding
import edu.iesam.loginexam1eval.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel

class SingupFragment : Fragment() {

    private var _binding: FragmentSingupBinding? = null
    private val binding get() = _binding!!
    private val viewModel:SingupViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSingupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.register.setOnClickListener {
            val user = User(
                email = binding.username.toString(),
                password = binding.password.toString()
            )
            viewModel.userExists(user)
            val userExists = viewModel.uiState.value?.userExists
            userExists?.let {
                if (it==true){
                    Log.d("@dev", "el usuario existe")
                }else{
                    viewModel.saveUser(user)

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}