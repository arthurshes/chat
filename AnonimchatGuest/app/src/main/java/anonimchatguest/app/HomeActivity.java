package anonimchatguest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView text_intent_menu;
    private ImageView image_Intent_menu;
    private Button buttonage_no17, buttonmen,buttonwoman,buttonnosex,buttonmen_companion,buttonwoman_companion,buttonnosex_companion,buttonage_do25,buttonage_25next,buttonage_no17_companion,buttonage_do25_companion,buttonage_25next_companio,button_next_chat,buttondialog,buttonflirt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button_next_chat=(Button) findViewById(R.id.button_next_chat);
        buttonmen=(Button) findViewById(R.id.buttonmen);
        buttonwoman=(Button) findViewById(R.id.buttonwoman);
        buttonnosex=(Button) findViewById(R.id.buttonnosex);
        buttonmen_companion=(Button) findViewById(R.id.buttonmen_companion);
        buttonwoman_companion=(Button) findViewById(R.id.buttonwoman_companion);
        buttonnosex_companion=(Button) findViewById(R.id.buttonnosex_companion);
        buttonage_no17=(Button) findViewById(R.id.buttonage_no17);
        buttonage_do25=(Button) findViewById(R.id.buttonage_do25);
        buttonage_25next=(Button) findViewById(R.id.buttonage_25next);
        buttonage_no17_companion=(Button) findViewById(R.id.buttonage_no17_companion);
        buttonage_do25_companion=(Button) findViewById(R.id.buttonage_do25_companion);
        buttonage_25next_companio=(Button) findViewById(R.id.buttonage_25next_companio);
        text_intent_menu=(TextView) findViewById(R.id.text_intent_menu);
        image_Intent_menu=(ImageView) findViewById(R.id.image_Intent_menu);

        text_intent_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textIntent=new Intent(HomeActivity.this,MenuActivity.class);
                startActivity(textIntent);
            }
        });
        image_Intent_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageIntent=new Intent(HomeActivity.this,MenuActivity.class);
                startActivity(imageIntent);
            }
        });
        buttonmen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        buttonwoman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent woIntent=new Intent(HomeActivity.this,ChatWomanMenActivity.class);
startActivity(woIntent);
            }
        });
        buttonnosex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        button_next_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntent=new Intent(HomeActivity.this,ChatActivity.class);
                startActivity(nIntent
                );
            }
        });
    }
}