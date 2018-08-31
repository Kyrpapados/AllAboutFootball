package kyrpapados.footballapp.ui.teams

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_squad.view.*
import kyrpapados.footballapp.R
import kyrpapados.footballapp.data.model.local.teams.SquadItem
import kyrpapados.footballapp.utils.helper.FormatHelper

class TeamsAdapter (private val mContext : Context, private val squadList: List<SquadItem>) : RecyclerView.Adapter<TeamsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_squad, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(mContext, squadList[position])
    }


    override fun getItemCount(): Int = squadList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(mContext: Context, squadList: SquadItem){
            itemView.role.text = squadList.position
            itemView.name.text = squadList.name
            itemView.birthday.text = FormatHelper.getDate(squadList.dateOfBirth!!)

        }
    }
}