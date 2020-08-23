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
import kotlinx.android.synthetic.main.item_heroe.view.*

class HeroesAdapter(): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    private val heroesList = ArrayList<Character>()

    fun setItems(items: ArrayList<Character>) {
        this.heroesList.clear()
        this.heroesList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val itemView = ItemHeroeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeroesViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val character = this.heroesList.get(position)
        holder.bindData(character)
    }

    inner class HeroesViewHolder(private val itemHeroeBinding: ItemHeroeBinding) : RecyclerView.ViewHolder(itemHeroeBinding.root){

        fun bindData(character: Character){
            val url = "${character.thumbnail.path}/portrait_medium.${character.thumbnail.extension}".replace("http", "https")
            itemHeroeBinding.heroeTv.text = character.name
            Glide.with(itemHeroeBinding.root)
                .load(url)
                .circleCrop()
                .into(itemHeroeBinding.heroeIv)
        }

    }
}