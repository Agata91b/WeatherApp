package agata91bcomgithub.log;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText login = (EditText) findViewById(R.id.login_view);
        ObjectAnimator translationAnimator = ObjectAnimator.ofFloat(login, View.TRANSLATION_X,0, 100);
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(login, View.ROTATION,0, 100);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(translationAnimator, rotateAnimator);
        animatorSet.start();



        final EditText password = (EditText) findViewById(R.id.password_view);
        final TextInputLayout loginInputLayout = (TextInputLayout) findViewById(R.id.inputlayout_login);
        final TextInputLayout passwordInputLayout = (TextInputLayout) findViewById(R.id.inputlayout_password);


        Button button = (Button) findViewById(R.id.log_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isWrong = false;
                if (login.getText().toString().isEmpty() || !login.getText().toString().contains("@")) {
                    loginInputLayout.setError("Niepoprawny login");
                    isWrong = true;
                }
                if (password.getText().toString().isEmpty()) {
                    passwordInputLayout.setError("Niepoprawne hasło");
                    isWrong = true;
                }
                if (isWrong) {
                    Snackbar.make(v, "login lub hasło jest niepoprawne", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Close", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).show();

                }


            }
        });




    }
}
