package kyrpapados.footballapp.ui.home

import kyrpapados.footballapp.data.model.local.Competition

interface ItemClickListener {
    fun onItemClick(competition: Competition)
}