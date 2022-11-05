package anonimchatguest.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ChatWomanMenActivity extends AppCompatActivity {

    private EditText edit_chat;
    private ImageView image_go_message, imageView_dialog;
    private Dialog chatdialog;
    private DatabaseReference databaseReference;
    private EditText textget;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_woman_men);
        edit_chat=(EditText) findViewById(R.id.edit_chat);
        imageView_dialog=(ImageView) findViewById(R.id.imageView_dialog);
        image_go_message=(ImageView) findViewById(R.id.image_go_message);
        mAuth = FirebaseAuth.getInstance();
        textget=(EditText) findViewById(R.id.textget);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users2").child("d2");




        chatdialog=new Dialog(ChatWomanMenActivity.this);


        imageView_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatdialogShow();
            }
        });
        image_go_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ValidateAndSaveOnlyInfo();
            }
        });

    }

    private void chatdialogShow() {
        chatdialog.setContentView(R.layout.dialog_exit);
        chatdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button button_chat_end=chatdialog.findViewById(R.id.button_chat_end);
        Button button_back_chat=chatdialog.findViewById(R.id.button_back_chat);

        button_back_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatdialog.dismiss();
            }
        });
        button_chat_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        chatdialog.show();
    }
    private void ValidateAndSaveOnlyInfo() {
        if (TextUtils.isEmpty(edit_chat.getText().toString()))
            Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show();

        else {
            HashMap<String, Object> userMap = new HashMap<>();
            userMap.put("uid",mAuth.getCurrentUser().getUid());
            userMap.put("text", edit_chat.getText().toString());


            databaseReference.child(mAuth.getCurrentUser().getUid()).updateChildren(userMap);

            edit_chat.setText("");
        }

    }

}