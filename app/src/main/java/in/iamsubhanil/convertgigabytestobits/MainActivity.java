package in.iamsubhanil.convertgigabytestobits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etGigabytes;
    Button btnConvert;
    TextView tvResults;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGigabytes = findViewById(R.id.etGigabytes);
        btnConvert = findViewById(R.id.btnConvert);
        tvResults = findViewById(R.id.tvResults);

        tvResults.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etGigabytes.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter the value!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int Gigabytes = Integer.parseInt(etGigabytes.getText().toString().trim());

                    double bits = (Gigabytes * 8589934592.00);

                    String results = "Converting the given value of Gigabytes we get " + formatter.format(bits) + " bits.";

                    tvResults.setText(results);

                    tvResults.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
