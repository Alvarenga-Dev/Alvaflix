package com.alvarengadev.alvaflix.view.mylist.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.alvaflix.R
import com.alvarengadev.alvaflix.view.interfaces.MovieOnClickListener
import com.squareup.picasso.Picasso

class MyListViewHolder(itemView: View, onClickListener: MovieOnClickListener) : RecyclerView.ViewHolder(itemView) {

    init {
        itemView.setOnClickListener {
            val positionRcy = adapterPosition
            if (positionRcy != RecyclerView.NO_POSITION) {
                onClickListener.onItemClick()
            }
        }
    }

    fun bind() {
        val url = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/5dbd24df-035e-4073-8edd-b54260fb9f24/dbwbct5-8ab1afbe-1127-4ce8-9d8d-7a3c39cdce0c.jpg/v1/fill/w_1280,h_1810,q_75,strp/star_wars___the_last_jedi____fanmade_poster_by_bestwalker444-dbwbct5.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwic3ViIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS53YXRlcm1hcmsiXSwib2JqIjpbW3sicGF0aCI6Ii9mLzVkYmQyNGRmLTAzNWUtNDA3My04ZWRkLWI1NDI2MGZiOWYyNC9kYndiY3Q1LThhYjFhZmJlLTExMjctNGNlOC05ZDhkLTdhM2MzOWNkY2UwYy5qcGciLCJ3aWR0aCI6Ijw9MTI4MCIsImhlaWdodCI6Ijw9MTgxMCJ9XV0sIndtayI6eyJwYXRoIjoiL3dtLzVkYmQyNGRmLTAzNWUtNDA3My04ZWRkLWI1NDI2MGZiOWYyNC9iZXN0d2Fsa2VyNDQ0LTQucG5nIiwib3BhY2l0eSI6OTUsInByb3BvcnRpb25zIjowLjQ1LCJncmF2aXR5IjoiY2VudGVyIn19.eZeDnORwOUXydJ3EB-5y66P32871DicJvV_es--SkUI"

        val ivPoster = itemView.findViewById(R.id.iv_movie_poster) as ImageView
        Picasso.get()
            .load(url)
            .into(ivPoster)
    }

}