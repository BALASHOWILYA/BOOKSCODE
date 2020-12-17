package com.example.freebooks;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class RegistrationFragment extends Fragment {

    private EditText mLogin;
    private EditText mPassword;
    private EditText mPasswordAgain;
    private Button mRegistration;
    private SharedPreferencesHelper mSharedPreferencesHelper;

    public static Fragment newInstance() {
        return new RegistrationFragment();
    }

    private View.OnClickListener mOnRegistrationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isInputValid()) {
                boolean isAdded = mSharedPreferencesHelper.addUser(new User(
                        mLogin.getText().toString(),
                        mPassword.getText().toString()
                ));

                if (isAdded) {
                    showMessage(R.string.login_register_success);
                    getFragmentManager().popBackStack();
                } else {
                    showMessage(R.string.login_register_error);
                }
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_registration, container, false);

        mSharedPreferencesHelper = new SharedPreferencesHelper(getActivity());

        mLogin = view.findViewById(R.id.etLogin);
        mPassword = view.findViewById(R.id.etPassword);
        mPasswordAgain = view.findViewById(R.id.tvPasswordAgain);
        mRegistration = view.findViewById(R.id.btnRegistration);

        mRegistration.setOnClickListener(mOnRegistrationClickListener);

        return view;
    }

    private boolean isInputValid() {
        String email = mLogin.getText().toString();
        if (isEmailValid(email) && isPasswordsValid()) {
            return true;
        }

        return false;
    }

    private boolean isEmailValid(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isPasswordsValid() {
        String password = mPassword.getText().toString();
        String passwordAgain = mPasswordAgain.getText().toString();

        return password.equals(passwordAgain)
                && !TextUtils.isEmpty(password)
                && !TextUtils.isEmpty(passwordAgain);
    }

    private void showMessage(int string) {
        Toast.makeText(getActivity(), string, Toast.LENGTH_LONG).show();
    }

}
