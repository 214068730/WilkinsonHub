package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Map<String,Book> search = new HashMap();
        Book[] book = new Book[2];
        Scanner input = new Scanner(System.in);
        String  bookID;

        book[0] = new Book("1559867","Grabiel","Jungle Book");
        book[1] = new Book("1559868","Grabiel","Jungle Book2");

        for(int i=0;i<2;i++){
            search.put(book[i].getBookID(),book[i]);
        }
        System.out.println("Enter book ID:");
        bookID = input.nextLine();

        System.out.println(search.get(bookID));
    }
}
