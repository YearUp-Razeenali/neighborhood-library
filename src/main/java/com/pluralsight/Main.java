package com.pluralsight;

public class Main {

    public static Book[] Library;



    public static void main(String[] args) {

        Library = getInitializedLibrary();

        char option;


        do {
            option = promptMainChoices();

            if(option == 'A'){
                // do available books display, ofer to check one out
                Book[] availableBooks = GetAvailableBooks(Library);
                DisplayBooks(availableBooks);
                Checkout(availableBooks);
            } else if (option == 'C') {
                //do checkout books display
                Book[] checkedOutBooks = GetCheckedOutBooks(Library);
                DisplayBooks(checkedOutBooks);

            }

        }while (option != 'X');



    }

    public static char promptMainChoices(){
        System.out.println("Welcome to the Library! Please select from the following choices");
        System.out.println("    Show [A]vailable Books");
        System.out.println("    Show [C]hecked Out Books");
        System.out.println("    [E]xit the Library");

        do{

            System.out.print("Command [A, C, X]: ");
            String command = Console.PromptForString();

            if ( command.equalsIgnoreCase("A")){
                return 'A';
            }
            if (command.equalsIgnoreCase("C")){
                return 'C';
            }
            if (command.equalsIgnoreCase("X")
                    || command.equalsIgnoreCase("EXIT")
                    || command.equalsIgnoreCase("Q")
                    || command.equalsIgnoreCase("QUIT")
            ){
                return 'X';
            }
        } while (true);
    }

    public static void Checkout(Book[] books) {
        String checkout;

        do {
            checkout = Console.PromptForString("Would you like to checkout (Y/N): ");
            if (checkout.equalsIgnoreCase("Yes") || checkout.equalsIgnoreCase("Y")) {
                String name = Console.PromptForString("What is your name for checkout: ");
                int id_num = Console.PromptForInt("Which book ID would you like to check out (1-" + Library.length + "): ");

                // Validate ID input
                if (id_num < 1 || id_num > Library.length) {
                    System.out.println("Invalid book ID. Please enter a number between 1 and " + Library.length + ".");
                    continue; // Ask for the checkout again
                }

                // Check the original library for availability
                Book bookToCheckout = Library[id_num - 1]; // Use the original library
                if (bookToCheckout.isChecked_out()) {
                    System.out.println("Sorry, this book is already checked out.");
                } else {
                    bookToCheckout.checkOut(name);
                    System.out.println("You have successfully checked out: " + bookToCheckout.getTitle());
                }
            }
        } while (checkout.equalsIgnoreCase("Y") || checkout.equalsIgnoreCase("Yes"));
    }

    public static Book[] GetAvailableBooks(Book[] books){
        Book[] available = new Book[books.length];
        int nextIndex = 0;
        for(Book book: books){
            if(!book.isChecked_out()){
                available[nextIndex++] = book;
            }
        }
        Book[] results = new Book[nextIndex];
        System.arraycopy(available,0,results,0,nextIndex);
        return results;
    }

    public static Book[] GetCheckedOutBooks(Book[] books){
        Book[] checkedOut = new Book[books.length];
        int nextIndex = 0;
        for(Book book: books){
            if(book.isChecked_out()){
                checkedOut[nextIndex++] = book;
            }
        }
        Book[] results = new Book[nextIndex];
        System.arraycopy(checkedOut,0,results,0,nextIndex);
        return results;
    }


    public static void DisplayBooks(Book[] books){
        System.out.printf("%5s %55s %20s %24s\n", "ID", "TITTLE", "ISBN", "CHECKOUT OUT TO");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (Book book: books){
            System.out.printf("%5s %55s %20s %24s\n", book.getId(), book.getTitle(), book.getIsbn(), book.getChecked_Out_to());
        }
    }

    public static Book[] getInitializedLibrary(){
        Book[] library = new Book[20];
        library[0] = new Book(1, "Tactical Tableau", "9780132365432");
        library[1] = new Book(2, "Pro Git", "9780132359876");
        library[2] = new Book(3, "Genetic Programing", "9780132350234");
        library[3] = new Book(4, "Clean Code", "9780132350884");
        library[4] = new Book(5, "Design Patterns", "9780201633610");
        library[5] = new Book(6, "The Pragmatic Programmer", "9780201616224");
        library[6] = new Book(7, "Refactoring", "9780201485677");
        library[7] = new Book(8, "Effective Java", "9780134685991");
        library[8] = new Book(9, "Head First Design Patterns", "9780596007126");
        library[9] = new Book(10, "Introduction to Algorithms", "9780262033848");
        library[10] = new Book(11, "Artificial Intelligence: A Modern Approach", "9780136042594");
        library[11] = new Book(12, "Java Concurrency in Practice", "9780321349606");
        library[12] = new Book(13, "The Mythical Man-Month", "9780201835953");
        library[13] = new Book(14, "The Art of Computer Programming", "9780201896848");
        library[14] = new Book(15, "Cracking the Coding Interview", "9780984782857");
        library[15] = new Book(16, "You Don't Know JS", "9781491904244");
        library[16] = new Book(17, "Introduction to Machine Learning with Python", "9781449369415");
        library[17] = new Book(18, "Deep Learning", "9780262035613");
        library[18] = new Book(19, "Python Crash Course", "9781593279288");
        library[19] = new Book(20, "Learning JavaScript Design Patterns", "9781449331817");
        //todo: fix this data
//        library[3].checkOut("Razeen");
//        library[7].checkOut("A Very Long Name");

        return library;
    }


}