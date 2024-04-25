package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdaptarRecyclerView extends
        RecyclerView.Adapter<AdaptarRecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private Root roote;


    public AdaptarRecyclerView(Context context,Root root){
        inflater=(LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.roote=root;
        //root=Connector.getConector().get(Root.class,"lat=39.5862518&lon=-0.5411163");

    }
    @NonNull
    @Override
    public AdaptarRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
        int viewType){
        View view=inflater.inflate(R.layout.recycler,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptarRecyclerView.ViewHolder holder,
                                 int position){


        holder.stateHeaven.setText(roote.list.get(position).weather.get(0).description);

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE+
                roote.list.get(position).weather.get(0).icon+
                Parameters.ICON_URL_POST,holder.images);
        Date date = new Date((long)roote.list.get(0).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm");
        holder.day.setText(dateDay.format(date));
        holder.dayOfWeek.setText(dateDayOfWeek.format(date));
    }

    @Override
    public int getItemCount(){
        return roote.list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
    private TextView stateHeaven;
    private ImageView images;
    private TextView day;
    private TextView dayOfWeek;
    private View view;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            view=itemView;
            stateHeaven=itemView.findViewById(R.id.txtViewStateHeaven);
            images=itemView.findViewById(R.id.imageView);
            day=itemView.findViewById(R.id.textViewDay);
            dayOfWeek=itemView.findViewById(R.id.textViewDayOfWeek);
        }

    }
}
