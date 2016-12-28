package com.example.darre.team_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView ListSearch;
    private EditText EditSearch;
    private ArrayAdapter<String>adapter;

    ArrayList<String> SelectedItems = new ArrayList<>();//Created an Array list to put the data in the array list


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);


        EditSearch = (EditText) findViewById(R.id.EditSearch);
        ListView LV = (ListView) findViewById(R.id.ListSearch);

        LV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String data[] = { //String of data that will appear on the app
                "Football", "Rowing", "Cricket", "Calisthenics",
                "Badminton", "Baseball", "Futsal", "Hockey",
                "Tennis", "Basketball", "Volleyball", "Netball"

        };

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textView, data);
        LV.setAdapter(adapter);//ListView is assigned to the adapter
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String SI = ((TextView) view).getText().toString();//Once clicked go to the if statement

                if (SelectedItems.contains(SI))
                {
                    SelectedItems.remove(SI); //uncheck the item
                }
                else
                {
                    SelectedItems.add(SI);//check the item
                }

            }
        });

        EditSearch.addTextChangedListener(new TextWatcher() {
                                              @Override
                                              public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                              }

                                              @Override
                                              public void onTextChanged(CharSequence s, int start, int before, int count) {
                                                  MainActivity.this.adapter.getFilter().filter(s);//When user types the lists gets narrowed down
                                              }

                                              @Override
                                              public void afterTextChanged(Editable s) {

                                              }
                                          }

        );

    }


}
