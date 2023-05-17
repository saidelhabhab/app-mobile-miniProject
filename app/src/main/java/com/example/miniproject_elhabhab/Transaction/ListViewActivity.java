
package com.example.miniproject_elhabhab.Transaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.miniproject_elhabhab.Database.Database;
import com.example.miniproject_elhabhab.R;
import com.example.miniproject_elhabhab.Transaction.TransactionAdapter;
import com.example.miniproject_elhabhab.Transaction.TransactionClass;
import com.example.miniproject_elhabhab.Transaction.TransactionDetailsActivity;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

    }


    @Override
    protected void onResume() {
        super.onResume();
        transaction = findViewById(R.id.transactions);



        Database dbManager = new Database(this);

        TransactionClass tr1 = new TransactionClass(R.drawable.chat,"transaction1","295","12/12/21","97876534","R1234567",10000);
        TransactionClass tr2 = new TransactionClass(R.drawable.info,"transaction2","455","13/12/21","97876534","R1234568",14000);
        TransactionClass tr3 = new TransactionClass(R.drawable.dietician,"transaction3","2450","22/12/21","97876534","R1234569",20000);
        TransactionClass tr4 = new TransactionClass(R.drawable.family_physicians,"transaction4","2150","29/12/21","97876534","R1234560",17000);
        TransactionClass tr5 = new TransactionClass(R.drawable.info,"transaction5","695","01/12/21","97876534","R1234564",10900);

        dbManager.addTransaction(tr1);
        dbManager.addTransaction(tr2);
        dbManager.addTransaction(tr3);
        dbManager.addTransaction(tr4);
        dbManager.addTransaction(tr5);

        ArrayList<TransactionClass> listTrans = (ArrayList<TransactionClass>) dbManager.getAllTransactions();


        TransactionAdapter adapter = new TransactionAdapter(this,R.layout.activity_transaction,listTrans);
        transaction.setFocusable(true);
        transaction.setAdapter(adapter);
        transaction.setEnabled(true);
        transaction.setItemsCanFocus(false);

        transaction.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TransactionDetailsActivity.class);
                intent.putExtra("transactionObject",listTrans.get(position));
                startActivity(intent);
            }
        });





    }

}