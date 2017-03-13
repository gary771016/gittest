package com.example.kelinshih.kelin_vibrator;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private EditText edt,edt2;
    private boolean colorWhite=true;
    private ToggleButton tBtn;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt=(EditText)findViewById(R.id.edt);
        edt2=(EditText)findViewById(R.id.edt2);
        tBtn=(ToggleButton)findViewById(R.id.tBtn);
        tBtn.setOnClickListener(tBtnL);

        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void onVibr(View v){
        vibrator.cancel();
        if(edt.getText().length()==0 || edt2.getText().length()==0){
            Toast.makeText(this,"Value cannot Empty !",Toast.LENGTH_SHORT).show();
        }
        else
        {
        int min=Integer.parseInt(edt.getText().toString());
        int sec=Integer.parseInt(edt2.getText().toString());
        vibrator.vibrate(min*60*1000+sec*1000);
        }
    }

    public void onStopVibr(View v){
        vibrator.cancel();
    }

    public void onChangeColor(View v){
        if(colorWhite==true)
        {
            findViewById(R.id.activity_main).setBackgroundColor(Color.BLACK);
            edt.setTextColor(Color.WHITE);
            edt2.setTextColor(Color.WHITE);
            findViewById(R.id.textView).setBackgroundColor(Color.WHITE);
            findViewById(R.id.textView3).setBackgroundColor(Color.WHITE);
            findViewById(R.id.textView4).setBackgroundColor(Color.WHITE);
            colorWhite=false;
        }
        else
        {
            findViewById(R.id.activity_main).setBackgroundColor(Color.WHITE);
            edt.setTextColor(Color.BLACK);
            edt2.setTextColor(Color.BLACK);
            findViewById(R.id.textView).setBackgroundColor(Color.WHITE);
            findViewById(R.id.textView3).setBackgroundColor(Color.WHITE);
            findViewById(R.id.textView4).setBackgroundColor(Color.WHITE);
            colorWhite=true;
        }

        //test update
    }

    private View.OnClickListener tBtnL=new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if(tBtn.isChecked())
            {
              vibrator.vibrate(10*60*1000);

            }
            else
            {
                    vibrator.cancel();
            }

        }
    };
}
