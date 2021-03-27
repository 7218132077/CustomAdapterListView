package com.prog.customadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    private String fruit[] = {"Apple", "Mango", "Grapes", "Watermelon", "Pineapple", "Orange"};

    private int images[] = {R.drawable.apple, R.drawable.mango, R.drawable.grapes, R.drawable.watermelon,
            R.drawable.pineapple, R.drawable.oranges};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);
        MyAdapter adapter = new MyAdapter(this, fruit, images);
        listView.setAdapter(adapter);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String fruit[];
        int images[];

        MyAdapter(Context c, String fruit[], int images[]) {
            super(c, R.layout.row_listview, R.id.row_listview_image, fruit);

            this.context = c;
            this.fruit = fruit;
            this.images = images;

        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(R.layout.row_listview, parent, false);

            ImageView img = view.findViewById(R.id.row_listview_image);
            TextView tv1 = view.findViewById(R.id.textview_listview1);


            img.setImageResource(images[position]);
            tv1.setText(fruit[position]);
            return view;
        }
    }
}




