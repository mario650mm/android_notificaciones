package com.example.vzert14.notificacionesf;

import android.content.Intent;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    FirebaseAnalytics mFirebaseAnalytics;
    private Toast toast;
    DatabaseReference db;
    private static final String TAG = "MainActivity";
    FirebaseAuth authListener;
    ListView listaNotificaciones;
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<Notification> notificacionesArray = new ArrayList<>();
    ArrayAdapter<Notification> adaptadorNotificacion;
    ImageButton btnAgregar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*authListener.signInWithEmailAndPassword("vzert@gmail.com", "$vzertwifi$").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                toast = Toast.makeText(getApplicationContext(), "login correcto", Toast.LENGTH_LONG);
                toast.show();
            }
        });*/
        System.out.println("MainActivity.oncreate "+FirebaseInstanceId.getInstance().getToken());
        /*listaNotificaciones = (ListView) findViewById(R.id.listaNotificaciones);
        btnAgregar = (ImageButton) findViewById(R.id.btnAgregar);
        db = FirebaseDatabase.getInstance().getReference();

        //adaptadorNotificacion = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,lista);

        //adaptadorNotificacion = new ArrayAdapter<Notification>(this,android.R.layout.simple_dropdown_item_1line,lista);
        ///listaNotificaciones.setAdapter(adaptadorNotificacion);




        //listaNotificaciones.setAdapter(adaptadorNotificacion);

        // Usuarios en firebase - https://firebase.google.com/docs/auth/android/password-auth#create_a_password-based_account
        authListener = FirebaseAuth.getInstance();
        try {
            authListener.signInWithEmailAndPassword("vzert@gmail.com", "$vzertwifi$").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    toast = Toast.makeText(getApplicationContext(), "login correcto", Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        } catch (Exception e) {
            toast = Toast.makeText(getApplicationContext(), "error " + e.getMessage(), Toast.LENGTH_LONG);
            toast.show();
        }
        db.orderByChild("titulo").limitToLast(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Notification value = dataSnapshot.getValue(Notification.class);
                notificacionesArray.add(value);
                //adaptadorNotificacion.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this,AddNotificacion.class);
                startActivity(intent);
            }
        });*/

        //getNotificaciones();

        ///agregarNotificacion("Notificación de prueba","Hola, cómo estás?");


    }

    //Cerrar Sesión en Firebase
    // FirebaseAuth.getInstance().signOut();

    /*private void getNotificaciones() {
        ValueEventListener notificationListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Notification notification = dataSnapshot.getValue(Notification.class);
                toast = Toast.makeText(getApplicationContext(),notification.toString(),Toast.LENGTH_LONG);
                toast.show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "Cancelled ", databaseError.toException());
            }
        };
        db.addValueEventListener(notificationListener);
    }

    private void agregarNotificacion(String titulo, String cuerpo) {
        String clave = db.child("notificaciones").push().getKey();
        Notification notificacion = new Notification(titulo, cuerpo);
        Map<String, Object> valoresN = notificacion.toMap();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/Notificaciones/" + clave, valoresN);
        db.updateChildren(childUpdates);
    }*/


}
