package kyrpapados.footballapp.ui.leagueboard.results

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_match.view.*
import kotlinx.android.synthetic.main.item_result_header.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.matches.Matches
import kyrpapados.footballapp.utils.Statics

class ResultsAdapter(private val mContext: Context, private val matchLis: List<Matches>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return Statics.VIEW_TITLE
        } else {
            return if (matchLis[position].matchday != matchLis[position - 1].matchday) {
                Statics.VIEW_TITLE
            } else {
                Statics.VIEW_ITEM
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View

        return if (viewType == Statics.VIEW_TITLE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_result_header, parent, false)
            ResultsAdapter.ViewHeaderHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
            ResultsAdapter.ViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType == Statics.VIEW_TITLE) {
            (holder as ResultsAdapter.ViewHeaderHolder).bindItems(mContext, matchLis[position])
        } else {
            (holder as ResultsAdapter.ViewHolder).bindItems(mContext, matchLis[position])
        }
    }

    override fun getItemCount(): Int = matchLis.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(mContext: Context, match: Matches) {
            itemView.homeTeam.text = match.homeTeam!!.name
            itemView.awayTeam.text = match.awayTeam!!.name
            itemView.score.text = match.score!!.fullTime!!.homeTeam.toString() + " - " + match.score!!.fullTime!!.awayTeam.toString()

        }
    }

    class ViewHeaderHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(mContext: Context, match: Matches) {
            itemView.day.text = mContext.getString(R.string.matchday, match.matchday.toString())


        }
    }
}