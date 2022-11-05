package anonimchatguest.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatActivity extends AppCompatActivity {
    private EditText edit_chat;
    private ImageView image_go_message,imageView_dialog;
    private Dialog chatdialog;
    private DatabaseReference databaseReference;
private EditText textget;
    private FirebaseAuth mAuth;
private static  int MAX_MESSAGE_LENGTMAH=100;
private RecyclerView recyclemanwoman;
private ArrayList<String> messages=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        edit_chat = (EditText) findViewById(R.id.edit_chat);
        imageView_dialog = (ImageView) findViewById(R.id.imageView_dialog);
        image_go_message = (ImageView) findViewById(R.id.image_go_message);
        mAuth = FirebaseAuth.getInstance();
        textget = (EditText) findViewById(R.id.textget);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("User").child("d1");
        Adapter adapter = new Adapter(this, messages);
        recyclemanwoman = (RecyclerView) findViewById(R.id.recyclemanwoman);


        recyclemanwoman.setLayoutManager(new LinearLayoutManager(this));

        ///adapter///
        recyclemanwoman.setAdapter(adapter);


        chatdialog = new Dialog(ChatActivity.this);




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
        if (TextUtils.isEmpty(edit_chat.getText().toString())) {
            Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show();

        } else {
            HashMap<String, Object> userMap = new HashMap<>();
            userMap.put("uid", mAuth.getCurrentUser().getUid());
            userMap.put("text", edit_chat.getText().toString());


            databaseReference.child(mAuth.getCurrentUser().getUid()).updateChildren(userMap);

            edit_chat.setText("");
        }

    }

}
