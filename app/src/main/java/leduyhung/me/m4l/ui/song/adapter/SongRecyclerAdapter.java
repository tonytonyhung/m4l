package leduyhung.me.m4l.ui.song.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.module.song.data.SongInfo;

public class SongRecyclerAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<SongInfo> data;

    public SongRecyclerAdapter(Context ctx, List<SongInfo> data) {
        this.mContext = ctx;
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemVIew(LayoutInflater.from(mContext).inflate(R.layout.item_recycler_song, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemVIew) holder).tName.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    private class NoItem extends RecyclerView.ViewHolder {
        public NoItem(View itemView) {
            super(itemView);
        }
    }

    private class LoadMoreItem extends RecyclerView.ViewHolder {

        public LoadMoreItem(View itemView) {
            super(itemView);
        }
    }

    private class ItemVIew extends RecyclerView.ViewHolder {

        private TextView tName, tAuthor, tLove, tTotalView;

        public ItemVIew(View itemView) {
            super(itemView);

            tName = itemView.findViewById(R.id.txt_name);
            tAuthor = itemView.findViewById(R.id.txt_author);
            tLove = itemView.findViewById(R.id.txt_love);
            tTotalView = itemView.findViewById(R.id.txt_total_view);
        }
    }
}
