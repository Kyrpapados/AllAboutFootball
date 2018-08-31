package kyrpapados.footballapp.ui.home

import android.support.v7.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_home.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.Competition
import kyrpapados.footballapp.utils.GlideApp

class HomeAdapter(private val mContext : Context, private val competitions: List<Competition>, val clickListener: (Competition) -> Unit) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(mContext, competitions[position], clickListener)
    }


    override fun getItemCount(): Int = competitions.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(mContext: Context, competition: Competition, clickListener: (Competition) -> Unit){
            itemView.name_competition.text = competition.name
            itemView.area_competition.text = competition.area!!.name

            if(competition.id == 2001){
                GlideApp.with(mContext)
                        .load(R.drawable.logo_cl)
                        .into(itemView.thumb_competition)
            }else if (competition.id == 2021){
                GlideApp.with(mContext)
                        .load(R.drawable.logo_premier_league)
                        .into(itemView.thumb_competition)
            }else if (competition.id == 2015){
                GlideApp.with(mContext)
                        .load(R.drawable.logo_ligue_1)
                        .into(itemView.thumb_competition)
            }else if (competition.id == 2002){
                GlideApp.with(mContext)
                        .load(R.drawable.logo_bundesliga)
                        .into(itemView.thumb_competition)
            }else if (competition.id == 2019){
                GlideApp.with(mContext)
                        .load(R.drawable.logo_serie_a)
                        .into(itemView.thumb_competition)
            }else{
                GlideApp.with(mContext)
                        .load(R.drawable.logo_laliga)
                        .into(itemView.thumb_competition)
            }

            itemView.setOnClickListener{ clickListener(competition) }
        }
    }
}