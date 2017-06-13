package id.sch.smktelkom_mlg.privatessignment.xirpl515.tugaspribadi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privatessignment.xirpl515.tugaspribadi.R;
import id.sch.smktelkom_mlg.privatessignment.xirpl515.tugaspribadi.model.source;

/**
 * Created by Jody Mardika on 5/16/2017.
 */

public class topratedadapter extends RecyclerView.Adapter<topratedadapter.ViewHolder> {
    public static final String IMAGE_URL_BASE_PATH = "http://image.tmdb.org/t/p/w500";
    ArrayList<source> list;
    topratedadapter.Itopratedadapter mItopratedadapter;
    Context context;

    public topratedadapter(Context context, ArrayList<source> list) {
        this.list = list;
        this.context = context;
        mItopratedadapter = (topratedadapter.Itopratedadapter) context;
    }

    @Override
    public topratedadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list1, parent, false);
        topratedadapter.ViewHolder vh = new topratedadapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(topratedadapter.ViewHolder holder, int position) {
        source source = list.get(position);
        holder.tvTitle.setText(source.title);
        holder.tvDesc.setText(source.overview);
        holder.tvRelease.setText(source.release_date);
        holder.tvRating.setText(source.vote_average);
        //holder.itemView.setBackgroundColor(source.color);
        Glide.with(context)
                .load(IMAGE_URL_BASE_PATH + source.poster_path)
                .into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public interface Itopratedadapter {
        void showArticles(String poster_path, String overview, String release_date, String title, String backdrop_path, String vote_average, String original_language, String popularity, String vote_count);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvTitle;
        TextView tvDesc;
        TextView tvRelease;
        TextView tvRating;
        TextView tvPopularity;
        TextView tvVote;
        TextView tvLanguage;

        public ViewHolder(View itemView) {
            super(itemView);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageViewPoster);
            tvTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewOverview);
            tvRelease = (TextView) itemView.findViewById(R.id.textViewDate);
            tvRating = (TextView) itemView.findViewById(R.id.textViewRating);
            tvPopularity = (TextView) itemView.findViewById(R.id.VoteAverage);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    source source = list.get(getAdapterPosition());
                    mItopratedadapter.showArticles(source.poster_path, source.overview, source.release_date, source.title, source.backdrop_path, source.vote_average, source.original_language, source.popularity, source.vote_count);
                }
            });
        }
    }
}
