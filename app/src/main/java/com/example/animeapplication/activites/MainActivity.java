package com.example.animeapplication.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.animeapplication.R;
import com.example.animeapplication.adpters.AnimeAdapter;
import com.example.animeapplication.model.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Anime> listAnime=new ArrayList<>();
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        jsonrequest();


    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        Anime anime = new Anime();
                        anime.setName(jsonObject.getString("name"));
                        anime.setDescription(jsonObject.getString("description"));
                        anime.setCategories(jsonObject.getString("categorie"));
                        anime.setRating(jsonObject.getString("Rating"));
                        anime.setStudio(jsonObject.getString("studio"));
                        anime.setNb_episode(jsonObject.getInt("episode"));
                        anime.setImg(jsonObject.getString("img"));
                        listAnime.add(anime);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                setupRecyclerView(listAnime);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue= Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setupRecyclerView(List<Anime> listAnime) {

        AnimeAdapter animeAdapter = new AnimeAdapter(this, listAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animeAdapter);
    }
}