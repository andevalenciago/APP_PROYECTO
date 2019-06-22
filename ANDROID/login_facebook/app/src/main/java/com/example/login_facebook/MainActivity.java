package com.example.login_facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends AppCompatActivity {

    Button btnCerrar;

    ProfilePictureView img_Usu;
    TextView txt_Nusu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//imagen, cerrar y nombre Usuario

        btnCerrar = findViewById(R.id.btnCerrar);
        img_Usu = findViewById(R.id.Profile_img);
        txt_Nusu = findViewById(R.id.txt_Nusuario);


        if(AccessToken.getCurrentAccessToken()==null){
            iraLogin();
        }else {

            //Obtener info del perfil d Usuario
            Profile profile = Profile.getCurrentProfile();

            txt_Nusu.setText(profile.getFirstName());//NOmbre U
            img_Usu.setProfileId(profile.getId());//Img de perfil



        }
        btnCerrar.setOnClickListener(new View.OnClickListener() {//salir de sesión
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                iraLogin();
            }
        });
    }

    public void iraLogin(){


        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
