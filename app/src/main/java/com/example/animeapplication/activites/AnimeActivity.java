package com.example.animeapplication.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.animeapplication.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class AnimeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime);

        getSupportActionBar().hide();

        String name = getIntent().getExtras().getString("anime_name");
        String description = getIntent().getExtras().getString("anime_description");
        String studio = getIntent().getExtras().getString("anime_studio");
        String episode = getIntent().getExtras().getString("anime_episode");
        String img_url = getIntent().getExtras().getString("anime_img");
        String category = getIntent().getExtras().getString("anime_category");
        String rating = getIntent().getExtras().getString("anime_rating");
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsing_tolbar);
        collapsingToolbarLayout.setTitleEnabled(true);
        TextView tv_name=findViewById(R.id.aa_anime_name);
        TextView tv_studio=findViewById(R.id.aa_studio);
        TextView tv_category=findViewById(R.id.aa_categories);
        TextView tv_description=findViewById(R.id.aa_description);
        ImageView tv_image=findViewById(R.id.aa_thumb_nail);
        TextView tv_rating=findViewById(R.id.aa_rating);


        tv_name.setText(name);
        tv_studio.setText(studio);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_category.setText(category);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        Glide.with(this).load(img_url).apply(requestOptions).into(tv_image);
    }
}