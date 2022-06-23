package com.example.bestbooksrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.bestbooksrecyclerview.Adapters.BookAdapter;
import com.example.bestbooksrecyclerview.databinding.ActivityMainBinding;
import com.example.bestbooksrecyclerview.models.BookModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<BookModel> list = new ArrayList<>();
       /* list.add(new BookModel(R.drawable.book1, "Fairy tales"));
        list.add(new BookModel(R.drawable.book2, "Fairy tales"));
        list.add(new BookModel(R.drawable.book3, "Fairy tales"));
        list.add(new BookModel(R.drawable.book4, "Fairy tales"));
        list.add(new BookModel(R.drawable.book5, "Fairy tales"));
        list.add(new BookModel(R.drawable.book6, "Fairy tales"));
        list.add(new BookModel(R.drawable.book7, "Fairy tales"));
        list.add(new BookModel(R.drawable.book8, "Fairy tales"));
        list.add(new BookModel(R.drawable.book9, "Fairy tales"));
        list.add(new BookModel(R.drawable.book10, "Fairy tales"));
        list.add(new BookModel(R.drawable.book11, "Fairy tales"));
        list.add(new BookModel(R.drawable.book12, "Fairy tales"));*/

        BookAdapter adapter = new BookAdapter(list, MainActivity.this);

        binding.recyclerView.setAdapter(adapter);

      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);*/

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.recyclerView.setLayoutManager(layoutManager);


        FirebaseDatabase.getInstance().getReference().child("books")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        list.clear();

                        for(DataSnapshot snapshot1: snapshot.getChildren()) {
                            BookModel model = snapshot1.getValue(BookModel.class);
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        /*StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
        StaggeredGridLayoutManager.HORIZONTAL);
        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);*/
    }
}