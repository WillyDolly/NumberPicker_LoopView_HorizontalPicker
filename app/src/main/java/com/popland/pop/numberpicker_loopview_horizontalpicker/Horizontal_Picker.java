package com.popland.pop.numberpicker_loopview_horizontalpicker;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.wefika.horizontalpicker.HorizontalPicker;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Horizontal_Picker extends Activity {
HorizontalPicker hp;
    TextView tvShow;
    int so =1;
    String[] mang = new String[30];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal__picker);
        tvShow = (TextView)findViewById(R.id.TVshow);
        hp = (HorizontalPicker)findViewById(R.id.picker);
        for(int i=0;i<=29;i++){
            mang[i] = String.valueOf(so);
            so++;
        }
        hp.setValues(mang);

        hp.setOnItemSelectedListener(new HorizontalPicker.OnItemSelected() {
            @Override
            public void onItemSelected(int index) {
               int nSo = Integer.parseInt(mang[index]);
               tvShow.setText(RNG(nSo).toString());
            }
        });
    }
// generate random t-digit number
    public BigInteger RNG(int t){
        BigInteger min, max, result;
        if(t==1)
         min = BigInteger.ZERO;
        else
         min = BigInteger.TEN.pow(t-1);//10^(t-1)
        max = (BigInteger.TEN.pow(t)).subtract(BigInteger.ONE);
        do{
            result = min.add(new BigInteger(max.bitLength(),new SecureRandom()));// min + random 2^numBits
        }while(result.compareTo(max)>0);// with numBits, 2^numBits(the biggest) > max
        return result;
    }
}
//C:\Users\hai\AppData\Local\Android\sdk1\platform-tools