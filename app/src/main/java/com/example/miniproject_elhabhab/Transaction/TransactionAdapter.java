package com.example.miniproject_elhabhab.Transaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.miniproject_elhabhab.R;

import java.util.ArrayList;

public class TransactionAdapter extends ArrayAdapter<TransactionClass> {

    ArrayList<TransactionClass> transaction;

    public TransactionAdapter( Context context, int resource,  ArrayList<TransactionClass> transaction) {
        super(context, resource, transaction);

        this.transaction = transaction;
    }




    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_transaction,parent,false);

        ImageView img = convertView.findViewById(R.id.image);
        img.setBackgroundResource(transaction.get(position).getImage());

        TextView label = convertView.findViewById(R.id.title);
        label.setText(transaction.get(position).getTitre());

        TextView price = convertView.findViewById(R.id.price);
        price.setText(transaction.get(position).getPrice());

        TextView date = convertView.findViewById(R.id.date);
        date.setText(transaction.get(position).getDate());

        return convertView;
    }
}
