package com.example.listview_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvSubjects;
    ArrayList<String> arrayCourse;
    EditText edtSubjects;
    Button btnAdd, btnEdit;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSubjects = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.buttonAdd);
        btnEdit = (Button) findViewById(R.id.buttonEdit);

        lvSubjects = (ListView) findViewById(R.id.listViewSubjects);
        arrayCourse = new ArrayList<>();
        arrayCourse.add("Android");
        arrayCourse.add("Ios");
        arrayCourse.add("PHP");
        arrayCourse.add("Java");
        arrayCourse.add("React Native");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvSubjects.setAdapter(adapter);

        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayCourse.get(position), Toast.LENGTH_SHORT).show();
                edtSubjects.setText(arrayCourse.get(position));
                vitri = position;
            }
        });

        lvSubjects.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, arrayCourse.get(position), Toast.LENGTH_SHORT).show();
                arrayCourse.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subjects = edtSubjects.getText().toString();
                arrayCourse.add(subjects);
                adapter.notifyDataSetChanged();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri, edtSubjects.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

    }
}
