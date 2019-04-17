package com.osdb.app.ui.login_options.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.api.Listener;
import com.amazon.identity.auth.device.api.authorization.*;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.osdb.app.R;
import com.osdb.app.ui.base.view.BaseActivity;
import com.osdb.app.ui.login.view.LoginActivity;
import com.osdb.app.ui.register.view.RegisterActivity;
import com.facebook.*;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginOptionsActivity extends BaseActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener  {

    private String TAG="LOGIN";
    private static final int RC_SIGN_IN = 101;
    private LinearLayout createAccountBtn;
    private LinearLayout fbBtnLay;
    private LinearLayout gmailBtnLay;
    private LinearLayout amazonBtnLay;
    private TextView signInTab;
    private LoginManager fbLoginManager;
    private CallbackManager callbackManager;
    private GoogleApiClient mGoogleApiClient;
    private RequestContext requestContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestContext = RequestContext.create(this);
        setContentView(R.layout.activity_login_options);

        initializeViews();
    }

    private void initializeViews() {
        callbackManager = CallbackManager.Factory.create();
        fbLoginManager = LoginManager.getInstance();
        createAccountBtn = findViewById(R.id.create_account_lay);
        signInTab = findViewById(R.id.signin_tab);
        fbBtnLay = findViewById(R.id.fb_btn_lay);
        gmailBtnLay = findViewById(R.id.google_btn_lay);
        amazonBtnLay = findViewById(R.id.amazon_btn_lay);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        amazonInit();
        createAccountBtn.setOnClickListener(this);
        signInTab.setOnClickListener(this);
        fbBtnLay.setOnClickListener(this);
        gmailBtnLay.setOnClickListener(this);
        amazonBtnLay.setOnClickListener(this);
    }


    private void amazonInit(){


        requestContext.registerListener(new AuthorizeListener() {
            /* Authorization was completed successfully. */
            @Override
            public void onSuccess(AuthorizeResult authorizeResult) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // At this point we know the authorization completed, so remove the ability to return to the app to sign-in again

                    }
                });
                fetchUserProfile();
            }

            /* There was an error during the attempt to authorize the application */
            @Override
            public void onError(AuthError authError) {
                Log.e(TAG, "AuthError during authorization", authError);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("Error during authorization.  Please try again.");
                    }
                });
            }

            /* Authorization was cancelled before it could be completed. */
            @Override
            public void onCancel(AuthCancellation authCancellation) {
                Log.e(TAG, "User cancelled authorization");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("Authorization cancelled");

                    }
                });
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        requestContext.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        /*Scope[] scopes = {ProfileScope.profile(), ProfileScope.postalCode()};
        AuthorizationManager.getToken(this, scopes, new Listener<AuthorizeResult, AuthError>() {
            @Override
            public void onSuccess(AuthorizeResult result) {
                if (result.getAccessToken() != null) {
                    *//* The user is signed in *//*
                    fetchUserProfile();
                } else {
                    *//* The user is not signed in *//*
                }
            }

            @Override
            public void onError(AuthError ae) {
                *//* The user is not signed in *//*
            }
        });*/
    }


    private void fetchUserProfile() {
        User.fetch(this, new Listener<User, AuthError>() {

            /* fetch completed successfully. */
            @Override
            public void onSuccess(User user) {
                final String name = user.getUserName();
                final String email = user.getUserEmail();
                final String account = user.getUserId();
                final String zipCode = user.getUserPostalCode();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        updateProfileData(name, email, account, zipCode);
                    }
                });
            }

            /* There was an error during the attempt to get the profile. */
            @Override
            public void onError(AuthError ae) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String errorMessage = "Error retrieving profile information.\nPlease log in again";
                        Toast errorToast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG);
                        errorToast.setGravity(Gravity.CENTER, 0, 0);
                        errorToast.show();
                    }
                });
            }
        });
    }

    private void updateProfileData(String name, String email, String account, String zipCode) {
        StringBuilder profileBuilder = new StringBuilder();
        profileBuilder.append(String.format("Welcome, %s!\n", name));
        profileBuilder.append(String.format("Your email is %s\n", email));
        profileBuilder.append(String.format("Your zipCode is %s\n", zipCode));
        final String profile = profileBuilder.toString();
        Log.d(TAG, "Profile Response: " + profile);

    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.create_account_lay:
                startActivity(new Intent(this, RegisterActivity.class));
                break;

            case R.id.signin_tab:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.fb_btn_lay: {
                fbLoginManager.logInWithReadPermissions(this,
                        Arrays.asList("public_profile", "email"));
                fbLogin();
                break;
            }

            case R.id.google_btn_lay: {
                signIn();
                break;
            }

            case R.id.amazon_btn_lay:{


                AuthorizationManager.authorize(
                        new AuthorizeRequest.Builder(requestContext)
                                .addScopes(ProfileScope.profile(), ProfileScope.postalCode())
                                .build()
                );
                /*for logout*/
                     /*   AuthorizationManager.signOut(getApplicationContext(), new Listener<Void, AuthError>() {
                            @Override
                            public void onSuccess(Void response) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        setLoggedOutState();
                                    }
                                });
                            }

                            @Override
                            public void onError(AuthError authError) {
                                Log.e(TAG, "Error clearing authorization state.", authError);
                            }
                        });
                    }*/

            }
        }
    }

    private void fbLogin() {
        fbLoginManager.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if (AccessToken.getCurrentAccessToken() != null) {
                    RequestData();
                }
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {
Log.e("error",error+"");
            }
        });


    }

    private void RequestData() {


        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        Log.d("TAG", object.toString());
                        try {
                            String first_name = object.getString("first_name");
                            String last_name = object.getString("last_name");
                            String email = object.getString("email");
                            String id = object.getString("id");
                            String image_url = "https://graph.facebook.com/" + id + "/picture?type=normal";

                            Log.e("CREIDANTAILS", first_name + " " + email);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();

    }


    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {

            GoogleSignInAccount acct = result.getSignInAccount();

            Log.e(TAG, "display name: " + acct.getDisplayName());

            String personName = acct.getDisplayName();
//            String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

            Log.e(TAG, "Name: " + personName + ", email: " + email);


        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
