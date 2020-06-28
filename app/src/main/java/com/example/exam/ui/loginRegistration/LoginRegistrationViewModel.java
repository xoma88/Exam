package com.example.exam.ui.loginRegistration;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginRegistrationViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoginRegistrationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is login registration fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}