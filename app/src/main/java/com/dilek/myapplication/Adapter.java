package com.dilek.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.PostHolder> {
    private LayoutInflater inflater;
    private String[] sTitles;
    private String[] sContent;
    Adapter(Context context, String[] titles, String[] contents){
    this.inflater=LayoutInflater.from(context);
    this.sTitles=titles;
    this.sContent=contents;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.custom_view,parent,false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        String title =sTitles[position];
        String content =sContent[position];
        holder.storyTitle.setText(title);
        holder.storyContent.setText(content);
    }
    /*Kaç eleman varsa onları getiricez */
    @Override
    public int getItemCount() {
        return sTitles.length;
    }
 /*main deki nesnelerimi burada tanımlıyorum. */
    class PostHolder extends RecyclerView.ViewHolder{
        TextView storyTitle,storyContent;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            /*tıklanınca içeriğe gidiyor */
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i =new Intent(v.getContext(),Details.class );
                    i.putExtra("titleOfStory",sTitles[getAdapterPosition()]);
                    i.putExtra("contentOfStory", sContent[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
            storyTitle=itemView.findViewById(R.id.storyTitle);
            storyContent=itemView.findViewById(R.id.storyContent);
        }
    }


}
