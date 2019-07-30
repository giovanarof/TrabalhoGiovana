package ifpr.com.trabalhogiovana;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sinais e sintomas");
        builder.setMessage("Escolha seu sintoma");

        DialogInterface.OnClickListener btnOk = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), Tela2.class);
                startActivity(intent);
            }
        };
        builder.setPositiveButton("Ok", btnOk);
        builder.create().show();
    }

    public void vaiParaOutraTela(View v){
        Intent intent = new Intent(this, Tela2.class);
        startActivity(intent);
    }
}