package anonimchatguest.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegActivity extends AppCompatActivity {

 private ImageView image_google;
 private Dialog dialog;
 private GoogleSignInClient client;
   private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        image_google=(ImageView) findViewById(R.id.image_google);

        dialog=new Dialog(RegActivity.this);
        databaseReference= FirebaseDatabase.getInstance().getReference("Users");

        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        client = GoogleSignIn.getClient(this, options);






        image_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signIntent=client.getSignInIntent();
                startActivityForResult(signIntent,1234);
            }
        });
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1234){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account=task.getResult(ApiException.class);
                AuthCredential credential= GoogleAuthProvider.getCredential(account.getIdToken(),null);

                FirebaseAuth.getInstance().signInWithCredential(credential)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(RegActivity.this, "error", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

            } catch (ApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if (user !=null){
            Intent userIntent=new Intent(RegActivity.this,HomeActivity.class);
            startActivity(userIntent);
        }
    }
}