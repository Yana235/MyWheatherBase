package com.example.myweatherbase.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.Root;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdaptarRecyclerView extends
        RecyclerView.Adapter<AdaptarRecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private Root roote;


    public AdaptarRecyclerView(Context context){
        inflater=(LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.roote=Connector.getConector().get(Root.class,"lat=39.5862518&lon=-0.5411163");

    }
    @NonNull
    @Override
    public AdaptarRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
        int viewType){
        View view=inflater.inflate(R.layout.activity_main,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptarRecyclerView.ViewHolder holder,
                                 int position){
        Root root=roote;


        holder.stateHeaven.setText(root.list.get(position).weather.get(position).description);

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE+
                root.list.get(position).weather.get(position).icon+
                Parameters.ICON_URL_POST,holder.images);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("E");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEEE, d MMM yyyy HH:mm");
        holder.day.setText(dateDay.format(dateDay));
        holder.dayOfWeek.setText(dateDayOfWeek.format(dateDayOfWeek));
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
