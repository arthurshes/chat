package anonimchatguest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread=new Thread()
        {
            @Override
            public void run() {
                super.run();
                {
                    try {
                        sleep(2500);
                    } catch (Exception e) {

                        e.printStackTrace();
                    } finally {
                        Intent HelloIntent = new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(HelloIntent);
                    }
                }
            }
        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
    }
