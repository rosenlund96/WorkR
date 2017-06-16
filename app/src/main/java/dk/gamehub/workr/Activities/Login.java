package dk.gamehub.workr.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dk.gamehub.workr.R;
import dk.gamehub.workr.Util.NetworkChangeReciever;

/**
 * Created by mathiaslarsen on 15/06/2017.
 */

public class Login extends Activity implements View.OnClickListener{

    NetworkChangeReciever reciever;
    EditText email,password;
    Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        reciever = new NetworkChangeReciever();
        email = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText);
        login = (Button) findViewById(R.id.button);
        login.setOnClickListener(this);

        if(checkInternetConnection()==false){
            login.setBackground(getResources().getDrawable(R.drawable.button_background_gray));
            login.setClickable(false);
            Toast.makeText(this, "Netværk ikke tilgængeligt", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {

    }

    public boolean checkInternetConnection(){

        return reciever.checkInternet(this);
    }


}
