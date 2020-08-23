package cruz.dariel.com.marvel_characters.ui.heroeslist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import cruz.dariel.com.marvel_characters.R
import cruz.dariel.com.marvel_characters.databinding.ItemHeroeBinding
import cruz.dariel.com.marvel_characters.model.Character
import cruz.dariel.com.marvel_characters.util.getPath
import kotlinx.android.synthetic.main.item_heroe.view.*

class HeroesAdapter(private val itemListener: HeroeItemListener): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    interface HeroeItemListener {
        fun onMovieClicked(id: Int)
    }

    private val heroesList = ArrayList<Character>()

    fun setItems(items: ArrayList<Character>) {
        this.heroesList.clear()
        this.heroesList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemView = ItemHeroeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroesViewHolder(itemView, itemListener)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val character = this.heroesList.get(position)
        holder.bindData(character)
    }

    inner class HeroesViewHolder(private val itemHeroeBinding: ItemHeroeBinding, itemListener: HeroeItemListener) : RecyclerView.ViewHolder(itemHeroeBinding.root), View.OnClickListener{

        init {
            itemHeroeBinding.root.setOnClickListener(this)
        }

        private lateinit var heroe: Character

        fun bindData(character: Character){
            this.heroe = character
            itemHeroeBinding.heroeTv.text = character.name
            Glide.with(itemHeroeBinding.root)
                .load(character.thumbnail?.getPath())
                .circleCrop()
                .into(itemHeroeBinding.heroeIv)
        }

        override fun onClick(p0: View?) {
            itemListener.onMovieClicked(heroe.id)
        }
    }
}