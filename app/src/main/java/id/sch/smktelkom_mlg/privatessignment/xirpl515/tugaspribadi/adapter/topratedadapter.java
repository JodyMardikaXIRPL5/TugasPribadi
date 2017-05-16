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
    //    ISourceAdapter mISourceAdapter;
    Context context;

    public topratedadapter(Context context, ArrayList<source> list) {
        this.list = list;
//        mISourceAdapter = (SourceAdapter.ISourceAdapter) context;
        this.context = context;
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
        holder.tvJudul.setText(source.title);
        holder.tvDesc.setText(source.overview);
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

//    public interface ISourceAdapter {
//        void showArticles(String id, String name, String sortBy);
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvJudul;
        TextView tvDesc;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDesc = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            ivPoster = (ImageView) itemView.findViewById(R.id.imageView);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Source source = list.get(getAdapterPosition());
//                    List<String> sort = source.sortBysAvailable;
//                    mISourceAdapter.showArticles(source.id, source.title, sort.get(sort.size() - 1));
//                }
//            });
        }
    }
}
