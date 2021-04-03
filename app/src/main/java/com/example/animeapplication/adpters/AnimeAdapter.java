package com.example.animeapplication.adpters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.animeapplication.R;
import com.example.animeapplication.activites.AnimeActivity;
import com.example.animeapplication.model.Anime;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.MyViewHolder> {
    private Context mcontext;
    private List<Anime> mData;
    RequestOptions option;

    public AnimeAdapter(Context context, List<Anime> mData) {
        this.mcontext = context;
        this.mData = mData;
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.anime_row_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.vie_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext, AnimeActivity.class);
                intent.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
                intent.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                intent.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
                intent.putExtra("anime_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
                intent.putExtra("anime_img",mData.get(viewHolder.getAdapterPosition()).getImg());
                intent.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategories());
                intent.putExtra("anime_rating",mData.get(viewHolder.getAdapterPosition()).getRating());

                mcontext.startActivity(intent);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Anime anime = mData.get(position);

        holder.tv_name.setText(anime.getName());
        holder.tv_studio.setText(anime.getStudio());
        holder.tv_category.setText(anime.getCategories());
        holder.tv_rating.setText(anime.getRating());

        Glide.with(mcontext).load(mData.get(position).getImg()).apply(option).into(holder.img_thumbnail);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_category;
        ImageView img_thumbnail;
        LinearLayout vie_container;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vie_container=itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.anime_name);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_category = itemView.findViewById(R.id.categories);
            tv_studio = itemView.findViewById(R.id.studio);
            img_thumbnail = itemView.findViewById(R.id.thumb_nail);


        }
    }

}
