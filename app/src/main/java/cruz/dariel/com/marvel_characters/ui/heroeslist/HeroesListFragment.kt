package cruz.dariel.com.marvel_characters.ui.heroeslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cruz.dariel.com.marvel_characters.R
import cruz.dariel.com.marvel_characters.databinding.FragmentHeroesListBinding
import cruz.dariel.com.marvel_characters.factory.HeroesViewModelFactory
import cruz.dariel.com.marvel_characters.network.RetrofitClient
import cruz.dariel.com.marvel_characters.repository.HeroeRepository
import kotlin.math.absoluteValue

class HeroesListFragment : Fragment(), HeroesAdapter.HeroeItemListener {

    private lateinit var heroesViewModel: HeroesViewModel
    private lateinit var adapter: HeroesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHeroesListBinding.inflate(inflater)

        adapter = HeroesAdapter(this)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvHeroesList.layoutManager = layoutManager
        binding.rvHeroesList.adapter = adapter
        heroesViewModel = requireActivity().run {
            ViewModelProvider(this).get(HeroesViewModel::class.java)
        }
        heroesViewModel.heroes.observe(viewLifecycleOwner, Observer {
            adapter.setItems(it)
        })
        return binding.root
    }

    override fun onMovieClicked(id: Int) {
        heroesViewModel.setHeroId(id)
        findNavController().navigate(R.id.action_heroesListFragment_to_heroDetailsFragment)
    }
}
