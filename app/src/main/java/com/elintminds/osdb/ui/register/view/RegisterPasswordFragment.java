package com.elintminds.osdb.ui.register.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.elintminds.osdb.MainActivity;
import com.elintminds.osdb.R;
import com.elintminds.osdb.ui.base.view.BaseFragment;

public class RegisterPasswordFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = "RegisterPasswordFragment";
    private TextView createAccountBtn;

    public static RegisterPasswordFragment newInstance()
    {
        return new RegisterPasswordFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.register_password_layout, container, false);
        return view;
    }

    @Override
    protected void setUp(View view)
    {
        createAccountBtn = view.findViewById(R.id.createAccountBtn);

        createAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.createAccountBtn:
                startActivity(new Intent(getContext(), MainActivity.class));
                break;
        }
    }
}
