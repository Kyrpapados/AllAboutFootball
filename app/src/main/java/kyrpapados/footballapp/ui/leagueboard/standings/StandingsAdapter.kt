package kyrpapados.footballapp.ui.leagueboard.standings

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_standing.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.TableItem
import kyrpapados.footballapp.utils.GlideApp
import kyrpapados.footballapp.utils.Statics.Companion.VIEW_ITEM
import kyrpapados.footballapp.utils.Statics.Companion.VIEW_TITLE

class StandingsAdapter(private val mContext: Context, private val dataList: List<TableItem>, private val listener: Listener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface Listener {

        fun onItemClick(tableItem: TableItem)
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataList[position].position == -1) {
            VIEW_TITLE
        } else {
            VIEW_ITEM
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view: View

        if (viewType == VIEW_TITLE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_standing_header, parent, false)
            return ViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_standing, parent, false)
            return ViewHolder(view)
        }


    }

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if(holder.itemViewType == VIEW_TITLE){
            (holder as ViewHeaderHolder)
        }else{
            (holder as ViewHolder).bind(dataList[position], position, mContext, listener)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(tableItem: TableItem, position: Int, mContext: Context, listener: Listener) {
            itemView.teamPosition.text = tableItem.position.toString() + "."
            itemView.teamName.text = tableItem.team!!.name
            itemView.teamGames.text = tableItem.playedGames.toString()
            itemView.teamWon.text = tableItem.won.toString()
            itemView.teamDraws.text = tableItem.draw.toString()
            itemView.teamlost.text = tableItem.lost.toString()
            itemView.teamPoints.text = tableItem.points.toString()

            GlideApp.with(mContext)
                    .load(tableItem.team.crestURI)
                    .override(60, 60)
                    .centerCrop()
                    .into(itemView.teamUri)

            itemView.setOnClickListener{ listener.onItemClick(tableItem) }
        }
    }

    class ViewHeaderHolder(view: View) : RecyclerView.ViewHolder(view)
}