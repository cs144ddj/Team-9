package com.example.darre.team_9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView ListSearch;
    private EditText EditSearch;
    private ArrayAdapter<String> adapter;

    String data[]={
            "Football", "Rowing", "Cricket", "Calisthenics",
            "Badminton", "Baseball", "Futsal", "Hockey",
            "Tennis", "Basketball", "Volleyball", "Netball"

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ListSearch = (ListView)findViewById(R.id.ListSearch);
    EditSearch = (EditText)findViewById(R.id.EditSearch);

    adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.textView,data);
    ListSearch.setAdapter(adapter);

        EditSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
