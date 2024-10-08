package com.pluralsight;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private boolean isChecked_out;
    private String checked_Out_to;

    public Book(int id, String title, String isbn) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;


        this.checked_Out_to = "";
        this.isChecked_out = false;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isChecked_out() {
        return isChecked_out;
    }

    public String getChecked_Out_to() {
        return checked_Out_to;
    }

    public void checkOut(String name){
        this.checked_Out_to = name;
        this.isChecked_out = true;
    }

    public void checkIn(){
        this.checked_Out_to = "";
        this.isChecked_out = false;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isChecked_out=" + isChecked_out +
                ", checked_Out_to='" + checked_Out_to + '\'' +
                '}';
    }
}
