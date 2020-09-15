package app.mma.showapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        text=findViewById(R.id.text);
        Intent intent = getIntent();
        int sum = intent.getIntExtra("sum",0);
        if(sum<=5){text.setText("به سوالات جدی پاسخ دهید");}
        if(20>sum&&sum>5){text.setText("به سوالات ضعیف پاسخ دادید");}
        if(sum>=20){text.setText("به سوالات قوی پاسخ دادید");}
    }
}
