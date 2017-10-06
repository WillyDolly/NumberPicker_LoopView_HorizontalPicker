package com.popland.pop.numberpicker_loopview_horizontalpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bruce.pickerview.LoopScrollListener;
import com.bruce.pickerview.LoopView;

import java.util.ArrayList;
import java.util.Arrays;

public class Loop_View extends AppCompatActivity {
LoopView loopView;
    String[] values = {"1","2","3","4","5","6"};
    ArrayList<String> arr = new ArrayList<>(Arrays.asList(values));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop__view);
        loopView = (LoopView)findViewById(R.id.loop_view);
        loopView.setDataList(arr);
        loopView.setLoopListener(new LoopScrollListener() {
            @Override
            public void onItemSelect(int item) {
                Toast.makeText(Loop_View.this,arr.get(item),Toast.LENGTH_LONG).show();
            }
        });
    }
}
