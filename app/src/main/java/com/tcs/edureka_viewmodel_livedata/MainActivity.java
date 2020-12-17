package com.tcs.edureka_viewmodel_livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  TimerViewModel mTimerViewModel;
    ValueHold viewModel ;

    TextView textView ,textViewclockTick;
    Button button ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView          = (TextView) findViewById(R.id.textView) ;
        textViewclockTick = (TextView) findViewById(R.id.textViewClockTick) ;
        button            = ( Button) findViewById(R.id.button) ;

        //  BRIDGE                         CAR              Composite_Vehicle_parts ( TRuck, Plane, Ship, Sumba, Bike )
        viewModel = ViewModelProviders.of(this).get(ValueHold.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.setCout(viewModel.getCout()+1);

                display( viewModel.getCout());
            }
        });

        mTimerViewModel = ViewModelProviders.of(this).get(TimerViewModel.class);

        mTimerViewModel.getElapsedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {

                //@SuppressLint("StringFormatMatches")
                //String newText = MainActivity.this.getResources().getString(R.string.seconds,aLong);

                ((TextView) findViewById(R.id.textViewClockTick)).setText("Clock tick : "+Long.toString(aLong));
                Log.d("tag","Update Timer : ");

            }
        });
    }

    public  void display(int count) {

       textView.setText("Button Click : "+String.valueOf(count));


    }

    @Override
    protected void onStart() {
        super.onStart();
        display(viewModel.getCout());
    }
}