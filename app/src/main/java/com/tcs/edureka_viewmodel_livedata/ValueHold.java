package com.tcs.edureka_viewmodel_livedata;

import androidx.lifecycle.ViewModel;

public  class ValueHold  extends ViewModel {


    // DP : Observers - Factory - Bridge

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    private  int cout ;
}
