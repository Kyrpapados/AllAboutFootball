package kyrpapados.footballapp.ui.leagueboard.fixtures.matchday

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_match.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.matches.Matches

class MatchDayAdapter (private val mContext : Context, private val matchLis: List<Matches>) : RecyclerView.Adapter<MatchDayAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(mContext, matchLis[position])
    }


    override fun getItemCount(): Int = matchLis.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(mContext: Context, match: Matches){
            itemView.homeTeam.text = match.homeTeam!!.name
            itemView.awayTeam.text = match.awayTeam!!.name
            itemView.score.text = " - "

        }
    }
}