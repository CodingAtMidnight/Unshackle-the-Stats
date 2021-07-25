package com.example.unshackledemstats;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unshackledemstats.entities.gameEntrie;

import org.w3c.dom.Text;

import java.util.List;

public class EntryListAdapter extends RecyclerView.Adapter<EntryListAdapter.MyViewHolder> {

    private Context context;
    private List<gameEntrie> gameEntrieList;

    public EntryListAdapter(Context context) {
        this.context = context;
    }

    public void setGameEntrieList(List<gameEntrie> gameEntrieList) {
        this.gameEntrieList = gameEntrieList;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public EntryListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);

        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntryListAdapter.MyViewHolder holder, int position) {
          holder.battleTitle.setText(this.gameEntrieList.get(position).getMatchUp());
          holder.creepScore.setText(String.valueOf(this.gameEntrieList.get(position).getCreepScore()));
          holder.gameKills.setText(String.valueOf(this.gameEntrieList.get(position).getGameKills()));
          holder.gameDeaths.setText(String.valueOf(this.gameEntrieList.get(position).getGameDeaths()));
          holder.visionScore.setText(String.valueOf(this.gameEntrieList.get(position).getVisionScore()));
          holder.setColor(this.gameEntrieList.get(position));

    }

    @Override
    public int getItemCount() {
        return this.gameEntrieList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
          TextView battleTitle;
          TextView creepScore;
          TextView gameDeaths;
          TextView gameKills;
          TextView visionScore;
          TextView winRate;
          LinearLayout layoutEntry;

          public MyViewHolder(View view) {
              super(view);
              battleTitle = view.findViewById(R.id.battleTitle);
              creepScore = view.findViewById(R.id.creepScore);
              gameDeaths = view.findViewById(R.id.gameDeaths);
              gameKills = view.findViewById(R.id.gameKills);
              visionScore = view.findViewById(R.id.visionScore);
              layoutEntry = view.findViewById(R.id.layoutEntry);

          }

          void setColor(gameEntrie gameEntrie) {

              if (gameEntrie.getColor() != null) {
                  layoutEntry.setBackgroundColor(Color.parseColor(gameEntrie.getColor()));
              } else {
                  layoutEntry.setBackgroundColor(Color.parseColor("#d3d3d3"));
              }
          }
    }
}
