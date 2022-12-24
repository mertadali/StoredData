package com.mertadali.storeddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


// girilen veriyi dataya kaydetmek için


public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText  = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);


    // öncelikle shared preferences bizden package ismimizi istiyor.
       sharedPreferences = this.getSharedPreferences("com.mertadali.storeddata", Context.MODE_PRIVATE);

       int storedAge = sharedPreferences.getInt("storedAge", 0);
       // getInt kısmının içine key ve value için birebir aynısını yazmalıyız yoksa çağıramayız.
        if (storedAge == 0){
            textView.setText("Your Age:");
        }else{
            textView.setText("Your Age"+ storedAge);
            // yaş 0 a eşit olmadığından girilen değeri alacaktır ve app kapanıp açılınca tekrardan girilen değeri ekranda gösterecektir.
        }


    }
    public void save(View view){
        if (!editText.getText().toString().matches("")){ // buradaki ünlem eğer eşit değilse işlemi yaptırır.
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText("Your age  " + userAge);

            sharedPreferences.edit().putInt("storedAge",userAge).apply();
            // burada artık yaptığımız app'i kaydetme işlemi yapıyoruz.
            // artık app kapansa bile ufak bir data ile bu veriyi saklayabilir ve istediğimiz zaman çağırabiliriz


        }

    }
    // girilen veriyi datadan silmek için

    public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge",0);
        if (storedData !=0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age");
        }

    }

        }




