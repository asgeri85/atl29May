package net.asgeri.atl29may.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import net.asgeri.atl29may.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getLocalData()
        binding.button.setOnClickListener {
            setLocalData()
        }
    }

    private fun setLocalData() {
        val sp = requireActivity().getSharedPreferences("local_shared", Context.MODE_PRIVATE)

        sp.edit().putString("name",null).apply()


    }

    private fun getLocalData() {
        val sp = requireActivity().getSharedPreferences("local_shared", Context.MODE_PRIVATE)

        val name = sp.getString("name", null)

        name?.let {
            binding.textView.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}