package com.osdb.app.utils;

import android.content.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationChecks
{
    private Context context;

    public ValidationChecks(Context context)
    {
        this.context = context;
    }


    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;

        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public boolean passwordValidator(String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);

        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
