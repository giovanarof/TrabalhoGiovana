package ifpr.com.trabalhogiovana;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        criarNotificacao();

        Toast.makeText(
                getApplicationContext(),
                "Selecione um sintoma",
                Toast.LENGTH_SHORT
        ).show();

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  listViewDaTela2, View itemView, int position, long id) {
               String sintoma = "";
                if (position == 0) {
                    sintoma = "Cefaleia pode ser sintoma de enxaqueca, AVC e gravidez";
                } else if (position == 1) {
                    sintoma = "Febre pode ser sintoma de resfriado, inflamaçoes e artrite";
                } else if (position == 2) {
                    sintoma = "Tosse pode ser sintoma de gripe, sinusite e asma";
                }
                Bundle bundle = new Bundle();
                bundle.putString("sintomaEscolhido", sintoma);
                Intent intent = new Intent(getBaseContext(), Tela3.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
        ListView listViewDaTela2 = findViewById(R.id.listViewDaTela2);
        listViewDaTela2.setOnItemClickListener(itemClickListener);
    }

    public void criarNotificacao() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel =
                    new NotificationChannel("my_channel_id",
                            "my_channel", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "my_channel_id");
        builder.setSmallIcon(R.drawable.download);
        builder.setContentTitle("Sintomas");
        builder.setContentText("Você está buscando informaçoes sobre sintomas");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(123456, builder.build());
    }
}
