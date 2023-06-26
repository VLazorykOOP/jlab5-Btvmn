import java.util.Scanner;

class PrintedPublication implements Comparable<PrintedPublication> {
    protected String title;
    protected String author;
    protected int year;

    public PrintedPublication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public void Show() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(PrintedPublication other) {

        return this.getTitle().compareTo(other.getTitle());
    }

}
