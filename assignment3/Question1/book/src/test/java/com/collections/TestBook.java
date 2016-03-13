package com.collections;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by student on 2016/03/10.
 */
public class TestBook {

    @Before
    public void setUp() throws Exception {
        Book book = new Book();

    }

    @Test
    public void testBookDetails() throws Exception {

        Book book = new Book("1559867","Grabiel","Jungle Book");
        Assert.assertEquals("1559867",book.getBookID());
        Assert.assertEquals("Jungle Book",book.getTitle());
        Assert.assertEquals("Grabiel",book.getAuthor());

        book.display();
    }


    @Test
    public void testHashMap() throws Exception {

        Map<String,Book> search = new HashMap();
        Book[] book = new Book[2];
        Scanner input = new Scanner(System.in);
        String  bookID ="1559867";

        book[0] = new Book("1559867","Grabiel","Jungle Book");
        book[1] = new Book("1559868","Grabiel","Jungle Book2");

        for(int i=0;i<2;i++){
            search.put(book[i].getBookID(),book[i]);
        }
        //System.out.println("Enter book ID:");
        //bookID = input.nextLine();
        System.out.println(search.get(bookID));
    }
}
