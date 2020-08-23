package cruz.dariel.com.marvel_characters.ui.herodetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import cruz.dariel.com.marvel_characters.R
import cruz.dariel.com.marvel_characters.databinding.FragmentHeroeDetailsBinding
import cruz.dariel.com.marvel_characters.factory.HeroesViewModelFactory
import cruz.dariel.com.marvel_characters.model.Character
import cruz.dariel.com.marvel_characters.network.RetrofitClient
import cruz.dariel.com.marvel_characters.repository.HeroeRepository
import cruz.dariel.com.marvel_characters.ui.heroeslist.HeroesViewModel
import cruz.dariel.com.marvel_characters.util.getPath

class HeroDetailsFragment : Fragment() {

    private lateinit var heroesViewModel: HeroesViewModel
    private lateinit var binding: FragmentHeroeDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHeroeDetailsBinding.inflate(inflater)

        heroesViewModel = requireActivity().run {
            ViewModelProvider(this).get(HeroesViewModel::class.java)
        }

        heroesViewModel.hero.observe(viewLifecycleOwner, Observer {
            bindData(it)
        })

        return binding.root
    }

    fun bindData(character: Character?) {
        character?.let {

            if(it.description != ""){
                binding.heroeDetailTv.text = it.description
            }

            Glide.with(binding.root)
                .load(character.thumbnail?.getPath())
                .into(binding.heroeDetailIv)
        }
    }

}
