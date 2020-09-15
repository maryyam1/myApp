package app.mma.showapplication;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class poshtecarActivity extends AppCompatActivity {
    ListView list;
    Button button1;
    int sum;
    int mosition;
    int n = 0;
    int m = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poshtcar);
        list = findViewById(R.id.list1);
        button1=findViewById(R.id.bottom1);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final List<String> etelaat = databaseAccess.getQuotes();
        databaseAccess.close();
        int[] a = new int[etelaat.size()];

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, etelaat);
        this.list.setAdapter(adapter);
        while (n < etelaat.size()/5) {
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    mosition = 0;


                    n = ((position) / 5);
                    switch (mosition = position - n * 5) {
                        case 0:

                            break;

                        case 1:
                            a[n] = 2;
                            break;

                        case 2:
                            a[n] = 4;

                            break;

                        case 3:
                            a[n] = 6;

                            break;

                        case 4:
                            a[n] = 8;

                            break;

                    }


                    sum = Arrays.stream(a).sum();
                    Log.i("n2;", String.valueOf(n) + "           " + String.valueOf(a[n]) + "           " + String.valueOf(sum));

                    Toast.makeText(poshtecarActivity.this, String.valueOf(n) + "         " + String.valueOf(a[n]) + "           " + String.valueOf(sum), Toast.LENGTH_LONG).show();

                }

            });
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent myIntent = new Intent(poshtecarActivity.this, resultActivity.class);
                    myIntent.putExtra("sum", sum); //Optional parameters
                    poshtecarActivity.this.startActivity(myIntent);

                }
            });
            break;
        }
    }
}

