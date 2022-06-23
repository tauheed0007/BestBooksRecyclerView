package com.example.bestbooksrecyclerview.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bestbooksrecyclerview.R;
import com.example.bestbooksrecyclerview.ReadBookActivity;
import com.example.bestbooksrecyclerview.models.BookModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.viewHolder>{


    ArrayList<BookModel> list;
    Context context;

    public BookAdapter(ArrayList<BookModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_books, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        BookModel model = list.get(position);
      //  holder.bookImage.setImageResource(model.getImage());
        Picasso.get()
                .load(model.getImage())
                .into(holder.bookImage);

        holder.bookText.setText(model.getBookName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ReadBookActivity.class);
                intent.putExtra("url", model.getUrl());
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookText;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = itemView.findViewById(R.id.imageView);
            bookText= itemView.findViewById(R.id.textView);
        }
    }
}
