package com.example.miniproject_elhabhab.Transaction;

import android.os.Parcel;
import android.os.Parcelable;

public class TransactionClass implements Parcelable {

    Integer image;
    String Titre;
    String price;
    String date;
    String numCompte;
    String numRef;
    double solde;

    public TransactionClass(Integer image, String titre, String price, String date, String numCompte, String numRef, double solde) {
        this.image = image;
        Titre = titre;
        this.price = price;
        this.date = date;
        this.numCompte = numCompte;
        this.numRef = numRef;
        this.solde = solde;
    }

    protected TransactionClass(Parcel in) {
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        Titre = in.readString();
        price = in.readString();
        date = in.readString();
        numCompte = in.readString();
        numRef = in.readString();
        solde = in.readDouble();
    }
    public static final Parcelable.Creator<TransactionClass> CREATOR = new Parcelable.Creator<TransactionClass>() {
        @Override
        public TransactionClass createFromParcel(Parcel in) {
            return new TransactionClass(in);
        }

        @Override
        public TransactionClass[] newArray(int size) {
            return new TransactionClass[size];
        }
    };

    public TransactionClass() {

    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public String getNumRef() {
        return numRef;
    }

    public void setNumRef(String numRef) {
        this.numRef = numRef;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (image == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(image);
        }
        dest.writeString(Titre);
        dest.writeString(price);
        dest.writeString(date);
        dest.writeString(numCompte);
        dest.writeString(numRef);
        dest.writeDouble(solde);
    }
}
