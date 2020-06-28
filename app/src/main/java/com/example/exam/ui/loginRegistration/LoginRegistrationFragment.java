package com.example.exam.ui.loginRegistration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.exam.R;

public class LoginRegistrationFragment extends Fragment {

    private LoginRegistrationViewModel loginRegistrationViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loginRegistrationViewModel =
                ViewModelProviders.of(this).get(LoginRegistrationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_login_registration, container, false);
        final TextView textView = root.findViewById(R.id.text_loginRegistration);
        loginRegistrationViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}