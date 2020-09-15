package app.mma.showapplication;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
ListView list;
Button posht,etemad,neo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posht=findViewById(R.id.posht);
        etemad=findViewById(R.id.etemad);
        neo=findViewById(R.id.neo);
        posht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, poshtecarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        etemad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, etemadActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        neo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, neoActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
    }
}
//    ListView listChoice = (ListView)findViewById(R.id.list_choice);
//            adapter = new ChoiceAdapter(MainActivity.this,R.layout.custom_list,choiceList );
//                    listChoice.setAdapter(adapter);
//                    //
//                    }