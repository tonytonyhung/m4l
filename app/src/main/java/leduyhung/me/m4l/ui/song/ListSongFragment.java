package leduyhung.me.m4l.ui.song;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import leduyhung.me.m4l.R;
import leduyhung.me.m4l.module.song.Song;
import leduyhung.me.m4l.module.message.GetListSongMessage;
import leduyhung.me.m4l.module.song.data.SongInfo;
import leduyhung.me.m4l.ui.song.adapter.SongRecyclerAdapter;

public class ListSongFragment extends Fragment {

    private Context mContext;
    private View v;
    private EditText eSearch;
    private RecyclerView recycler;
    private SongRecyclerAdapter adap;
    private Song song;
    private List<SongInfo> lData;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        EventBus.getDefault().register(this);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_list_song_or_playlist, container, false);
        eSearch = v.findViewById(R.id.etxt_search);
        recycler = v.findViewById(R.id.recycler);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (song == null) {
            song = new Song();
            song.getListSong(mContext, "", 1, 0, 0);
        }
        configRecycler();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMessage(GetListSongMessage message) {
        switch (message.getStatus()) {
            case SUCCESS:
                lData.addAll(message.getData().getData());
                adap.notifyDataSetChanged();
                break;
            case NOT_FOUND:
                break;
            case NO_INTERNET_CONNECTED:
                break;
            case TIMEOUT_SOCKET:
                break;
            case MAINTAIN:
                break;
        }
    }

    private void configRecycler() {

        lData = new ArrayList<>();
        adap = new SongRecyclerAdapter(mContext, lData);
        LinearLayoutManager manager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        recycler.setAdapter(adap);

    }
}