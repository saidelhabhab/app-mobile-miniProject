package com.example.miniproject_elhabhab.Transaction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.miniproject_elhabhab.R;
import com.example.miniproject_elhabhab.Transaction.TransactionClass;

public class TransactionDetailsActivity extends AppCompatActivity {

    TextView compte;
    TextView desc;
    TextView montant;
    TextView date;
    TextView solde;
    TextView ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_details);
    }

    @Override
    protected void onResume() {
        super.onResume();

        compte = findViewById(R.id.compte);
        desc = findViewById(R.id.description);
        montant = findViewById(R.id.montant);
        date = findViewById(R.id.date);
        solde = findViewById(R.id.solde);
        ref = findViewById(R.id.reference);


        Bundle b = getIntent().getExtras();
        TransactionClass tr = (TransactionClass) b.get("transactionObject");

        compte.setText(tr.getNumCompte());
        desc.setText(tr.getTitre());
        montant.setText(tr.getPrice());
        date.setText(tr.getDate());
        solde.setText(""+tr.getSolde());
        ref.setText(tr.getNumRef());

    }

}