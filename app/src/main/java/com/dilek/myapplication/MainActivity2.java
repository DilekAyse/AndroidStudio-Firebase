package com.dilek.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    RecyclerView recyclerView;
    Adapter adapter;

    /*Menüyü bağlama işlemi */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menuu,menu);
        return super.onCreateOptionsMenu(menu);
    }

   /* menüde seçtiğin ile ne yapacaksın onları belirt */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==R.id.deneme){
            Intent intentToUplod = new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intentToUplod);
        }else if(item.getItemId()==R.id.signout){
            firebaseAuth.signOut();
            Intent intentToSignUp = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intentToSignUp);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firebaseAuth=FirebaseAuth.getInstance();
        String[] titles = getResources().getStringArray(R.array.stories_title);
        String[] contents = getResources().getStringArray(R.array.story_content);
        recyclerView =findViewById(R.id.storiesListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        adapter=new Adapter(this ,titles,contents);
        recyclerView.setAdapter(adapter);
    }
}