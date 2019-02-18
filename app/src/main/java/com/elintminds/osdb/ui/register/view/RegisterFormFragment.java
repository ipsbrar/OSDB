package com.elintminds.osdb.ui.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;
import com.elintminds.osdb.ui.login.view.LoginActivity;

public class RegisterFormFragment extends BaseFragment implements View.OnClickListener
{
    public static final String TAG = "RegisterFormFragment";
    private TextView continueBtn;
    private RegisterActivity activity;
    private TextView signinTab;

    public static RegisterFormFragment newInstance()
    {
        return new RegisterFormFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.register_form_screen, container, false);
    }

    @Override
    protected void setUp(View view)
    {
        activity =  (RegisterActivity) getActivity();
        continueBtn = view.findViewById(R.id.continue_btn);
        signinTab = view.findViewById(R.id.signin_tab);

        continueBtn.setOnClickListener(this);
        signinTab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.continue_btn:
                activity.changeFragment(RegisterPasswordFragment.newInstance(), RegisterPasswordFragment.TAG);
                break;

            case R.id.signin_tab:
                startActivity(new Intent(getContext(), LoginActivity.class));
                break;
        }
    }
}
