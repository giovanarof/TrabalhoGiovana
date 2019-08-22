package ifpr.com.trabalhogiovana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Tela3<arraylist> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String sintoma = bundle.getString("sintomaEscolhido");

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(sintoma);
        //GIT ATT

        }
    }

