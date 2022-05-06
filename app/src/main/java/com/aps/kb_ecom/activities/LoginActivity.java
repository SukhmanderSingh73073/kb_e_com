package com.aps.kb_ecom.activities;


import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.aps.kb_ecom.R;
import com.aps.kb_ecom.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    //test
    TextView txt_title ,txt_footer;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews() ;
        findViewById(R.id.login).setOnClickListener(v->{
            startActivity(new Intent(getApplicationContext() , MainActivity.class)) ;
        });

    }

    private void initViews() {
        txt_footer = findViewById(R.id.txt_footer) ;
        txt_title = findViewById(R.id.txt_title) ;

        String text = "<font color=#1AA57B>Log In</font> <font color=#B6B6B8> to your account</font>";
        txt_title.setText(Html.fromHtml(text));


        String f_text = "<font color=#B6B6B8>Don't have an account</font> <font color=#1AA57B> Sign in</font>";
        txt_footer.setText(Html.fromHtml(f_text));


    }
}