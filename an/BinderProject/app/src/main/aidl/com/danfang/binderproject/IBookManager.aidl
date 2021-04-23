// IBookManager.aidl
package com.danfang.binderproject;

// Declare any non-default types here with import statements
import com.danfang.binderproject.Book;

interface IBookManager {
    List<Book> getBookList();
    void addBook(in Book book);
}