package com.collections;

/**
 * Created by student on 2016/03/10.
 */
public class Book {

    private String bookID;
    private String author;
    private String title;


    public Book(){}

    public Book(String bookID,String author,String title){
        this.bookID = bookID;
        this.author = author;
        this.title = title;
    }


    //setters
    public void setBookID(String bookID){
        this.bookID = bookID;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setTitle(String title){
        this.title = title;
    }

    //getters
    public String getBookID(){
        return this.bookID;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }

    public void display(){
        System.out.println("Title: "+this.title);
        System.out.println("Author: "+this.author);
        System.out.println("Book ID: "+this.bookID);
    }


    public String toString(){
        return("Title:"+title+"\n"+"Author:"+author+"\n"+"Book ID:"+bookID+"\n");
    }

}
