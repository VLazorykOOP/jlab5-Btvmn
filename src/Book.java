class Book extends PrintedPublication {
    private String publisher;

    public Book(String title, String author, int year, String publisher) {
        super(title, author, year);
        this.publisher = publisher;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Publisher: " + publisher);
    }
}