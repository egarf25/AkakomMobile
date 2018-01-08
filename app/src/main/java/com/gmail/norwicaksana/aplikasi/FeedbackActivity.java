package com.gmail.norwicaksana.aplikasi;

import android.content.Intent;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        final EditText to = (EditText) findViewById(R.id.sentTo);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.EmailText);

        Button Sent = (Button) findViewById(R.id.sentEmail);
        Sent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String toS = to.getText().toString();
                String subS = subject.getText().toString();
                String mesS = message.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                //email.putExtra(Intent.EXTRA_EMAIL, toS);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{toS});
                email.putExtra(Intent.EXTRA_SUBJECT, subS);
                email.putExtra(Intent.EXTRA_TEXT, mesS);

                email.setType("message/rfc822"); //get this is description
                startActivity(Intent.createChooser(email, "Choose app to send emai"));
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){super.onBackPressed();}
}
