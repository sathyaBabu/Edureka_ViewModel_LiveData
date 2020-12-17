package com.tcs.edureka_viewmodel_livedata;

import android.os.SystemClock;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {
    private static final int ONE_SECOND = 1000 ;

    private MutableLiveData<Long> mElapsedTime = new MutableLiveData<>();
    private long mInitialTime ;

    public TimerViewModel() {
        mInitialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long newValue = ( SystemClock.elapsedRealtime() - mInitialTime) / 1000;
                Log.d("tag","Elapsed time "+SystemClock.elapsedRealtime()+" : ");
                 mElapsedTime.postValue(newValue);
            }
        }, ONE_SECOND,ONE_SECOND);  // delay ,  period
    }

    public LiveData<Long> getElapsedTime() {
        return mElapsedTime;
    }

}
