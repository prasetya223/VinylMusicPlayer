package com.kelompok12.vinylmusicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.kelompok12.vinylmusicplayer.R;
import com.kelompok12.vinylmusicplayer.TrackModel;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class TracksListAdapter extends RecyclerView.Adapter<TracksListAdapter.ViewHolder> {

    private ArrayList<TrackModel> mTracks = new ArrayList<>();
    private Context context;

    public TracksListAdapter(Context context, ArrayList<TrackModel> mTracks) {
        this.context = context;
        this.mTracks = mTracks;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.track_item, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(itemRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        int drawableResourceFlagId = context.getResources().getIdentifier(countryFlags.get(position), "drawable", context.getPackageName());
        int drawableResourceEmblemId = context.getResources().getIdentifier(countryEmblems.get(position), "drawable", context.getPackageName());

        Glide.with(context)
                .asBitmap()
                .load(drawableResourceFlagId)
                .apply(new RequestOptions().override(Target.SIZE_ORIGINAL))
                .into(viewHolder.flag);

        viewHolder.name.setText(countryNames.get(position));
        viewHolder.capital.setText(countryCapitals.get(position));

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + countryNames.get(position));
                Intent intent = new Intent(context, CountryDetail.class);
                intent.putExtra("country_name", countryNames.get(position));
                intent.putExtra("country_capital", countryCapitals.get(position));
                intent.putExtra("country_language", countryLanguages.get(position));
                intent.putExtra("country_independence_day", countryDays.get(position));
                intent.putExtra("country_flag", countryFlags.get(position));
                intent.putExtra("country_emblem", countryEmblems.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, capital;
        ImageView flag;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            flag = itemView.findViewById(R.id.flag);
            parentLayout = itemView.findViewById(R.id.parentLayout);

        }
    }
}

