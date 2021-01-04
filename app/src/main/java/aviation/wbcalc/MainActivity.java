package aviation.wbcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.*;

public class MainActivity extends AppCompatActivity {

    private static final double EMPTYWT=589.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText p=findViewById(R.id.pilotWt);
        EditText f=findViewById(R.id.fuelGal);
        EditText b=findViewById(R.id.bagWt);

        TextView calcResults=findViewById(R.id.calcResults);

        Button calcButton=findViewById(R.id.calcButton);
        calcButton.setOnClickListener( bt -> {
            int pilotWt= parseInt(p.getText().toString());
            int fuelWt= parseInt(f.getText().toString())*6;
            int bagWt=parseInt(b.getText().toString());
            double totalWt = pilotWt + fuelWt + bagWt + EMPTYWT;
            double moment = 34152.3 + bagWt * 102 + fuelWt * 46.45 + pilotWt * 78;
            double cg=moment/totalWt;
            calcResults.setText("Pilot Weight = " + pilotWt + " lbs.\nFuel Weight = "
                    + fuelWt + " lbs.\nBag Weight = "
                    + bagWt + " lbs. \nGross Weight = "
                    + totalWt + " lbs.\nMax Total Gross Weight = 950 lbs."
                    + "\nCalculated CG: " + String.format("%.2f",cg) + " inches from datum.\n (Between 60.5-66.5 is acceptable.)");
        });
    }
}
