package com.example.vzert14.notificacionesf;

import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
/*import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;*/

public class MainActivity extends AppCompatActivity {
    //private FirebaseAnalytics mFirebaseAnalytics;
    private Toast toast;
    DatabaseReference db;
    private static final String TAG = "MainActivity";
    FirebaseAuth authListener;
    ListView listaNotificaciones;
    ArrayList<String> lista = new ArrayList<>();
    ArrayList<Notification> notificacionesArray = new ArrayList<>();
    ArrayAdapter<Notification> adaptadorNotificacion;

    //ArrayAdapter<String> adaptadorNotificacion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaNotificaciones = (ListView) findViewById(R.id.listaNotificaciones);
        db = FirebaseDatabase.getInstance().getReference();
        listaNotificaciones.setAdapter(adaptadorNotificacion);

        //adaptadorNotificacion = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,lista);

        //adaptadorNotificacion = new ArrayAdapter<Notification>(this,android.R.layout.simple_dropdown_item_1line,lista);
        listaNotificaciones.setAdapter(adaptadorNotificacion);


        /*String android_id = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID);
        toast = Toast.makeText(getApplicationContext(),"android_id: "+android_id,Toast.LENGTH_LONG);
        toast.show();*/

        // Usuarios en firebase - https://firebase.google.com/docs/auth/android/password-auth#create_a_password-based_account
        authListener = FirebaseAuth.getInstance();
        try {
            authListener.signInWithEmailAndPassword("mario650m@gmail.com", "$vzertwifi$").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
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
        db.orderByChild("titulo").limitToLast(5).addChildEventListener(new ChildEventListener() {
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
        //getNotificaciones();

        //agregarNotificacion("titulo 1","Cuerpo 1");


    }

    //Cerrar Sesión en Firebase
    // FirebaseAuth.getInstance().signOut();º

    private void getNotificaciones() {
        ValueEventListener notificationListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Notification notification = dataSnapshot.getValue(Notification.class);
                /*toast = Toast.makeText(getApplicationContext(),notification.toString(),Toast.LENGTH_LONG);
                toast.show();*/
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
    }


}
