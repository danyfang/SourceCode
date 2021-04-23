package com.danfang.binderproject;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    public int bookId;
    public String bookName;

    public Book(int id, String name) {
        bookId = id;
        bookName = name;
    }

    protected Book(Parcel in) {
        bookId = in.readInt();
        bookName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeString(bookName);
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public int describeContents() {
        return 0;
    }
}
