package com.mauriciobenigno.todoapp.fragments.add

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.mauriciobenigno.todoapp.R
import com.mauriciobenigno.todoapp.data.models.Priority
import com.mauriciobenigno.todoapp.data.models.ToDoData
import com.mauriciobenigno.todoapp.data.viewmodel.ToDoViewModel
import com.mauriciobenigno.todoapp.databinding.FragmentAddBinding

class AddFragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    private val mToDoViewModel: ToDoViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(inflater, container, false)

        configureMenu()

        return binding.root
    }

    private fun configureMenu(){
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object: MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.add_fragment_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

                when(menuItem.itemId){

                    R.id.menu_add -> {
                        insertToDo()
                    }

                    android.R.id.home ->  requireActivity().onBackPressedDispatcher.onBackPressed()
                }

                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun insertToDo(){
        val mTitle = binding.edtAddTitulo.text.toString()
        val mPriority = binding.spnAddPrioridade.selectedItem.toString()
        val mDescription = binding.edtAddDescricao.text.toString()

        if(validateTodo(mTitle, mDescription)){
            val toDo = ToDoData(
                0,
                mTitle,
                Priority.valueOf(mPriority),
                mDescription
            )

            mToDoViewModel.insertToDo(toDo)

            Toast.makeText(requireContext(), "A fazer adicionado com sucesso.", Toast.LENGTH_SHORT).show()

            // Vavegar de volta
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validateTodo(title: String, description: String) : Boolean{
        return !(TextUtils.isEmpty(title) || TextUtils.isEmpty(description))
    }
}