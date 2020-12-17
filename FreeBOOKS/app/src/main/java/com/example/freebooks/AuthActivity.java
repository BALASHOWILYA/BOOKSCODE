package com.example.freebooks;

import androidx.fragment.app.Fragment;

/**
 * Created by tanchuev on 08.11.2017.
 */

public class AuthActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return AuthFragment.newInstance();
    }
}
