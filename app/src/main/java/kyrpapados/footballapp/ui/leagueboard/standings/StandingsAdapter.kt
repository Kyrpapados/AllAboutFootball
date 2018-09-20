package kyrpapados.footballapp.ui.leagueboard.standings

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_standing.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.TableItem

class StandingsAdapter(private val mContext: Context, private val dataList: List<TableItem>, private val listener: Listener) : RecyclerView.Adapter<StandingsAdapter.ViewHolder>() {
    interface Listener {

        fun onItemClick(tableItem: TableItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_standing, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position], listener)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(tableItem: TableItem, listener: Listener) {
            if(tableItem.position != -1){
                itemView.teamPosition.text = tableItem.position.toString() + "."
                itemView.teamName.text = tableItem.team!!.name
                itemView.teamGames.text = tableItem.playedGames.toString()
                itemView.teamWon.text = tableItem.won.toString()
                itemView.teamDraws.text = tableItem.draw.toString()
                itemView.teamlost.text = tableItem.lost.toString()
                itemView.teamPoints.text = tableItem.points.toString()

                itemView.setOnClickListener{ listener.onItemClick(tableItem) }
            }
        }
    }
}