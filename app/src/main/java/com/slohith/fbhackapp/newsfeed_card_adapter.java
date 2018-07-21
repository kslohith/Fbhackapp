package com.slohith.fbhackapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;






public class newsfeed_card_adapter extends RecyclerView.Adapter<newsfeed_card_adapter.viewholder>{

    Myclick myclick;
    LayoutInflater inflater;
    JSONArray arr;

    public newsfeed_card_adapter(JSONArray arr, Context context)
    {
        this.arr = arr;
        this.inflater =LayoutInflater.from(context);
    }


    public interface  Myclick{
        public void afterclick(int pos, int viewid);
    }

    public void setMyclick(Myclick myclick)   //this is passes in function call
    {
        this.myclick=myclick;
    }


    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.newsfeed_card,parent,false);                    //if you wan do this with a card view only thing to change is the id to sm cardview thing
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(viewholder holder, int position) {




      try{

          JSONObject obj = arr.getJSONObject(position);
          holder.header.setText(obj.getString("header"));
          holder.news.setText(obj.getString("news"));


      }
      catch (Exception e)
      {
          Log.d("erroroo",e.toString());
      }
    }

    @Override
    public int getItemCount() {
        return arr.length();
    }

    class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView header,news;


        public viewholder(View itemView) {
            super(itemView);

            header = (TextView)itemView.findViewById(R.id.header);
            news = (TextView)itemView.findViewById(R.id.news);

        }

        @Override
        public void onClick(View v) {


        }
    }
}
