package leduyhung.me.m4l.ui.song.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
