package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// Code For ID
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.myBtn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                    MainActivity.this.startActivityForResult(intent, 100);
                }
    });


}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK){ // this 100 needs to match the 100 we used when we called startActivityForResult!
            String question = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
            String answer = data.getExtras().getString("string2");

            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(answer);
        }
    }

}
