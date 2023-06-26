class Textbook extends Book {
    private String subject;

    public Textbook(String title, String author, int year, String publisher, String subject) {
        super(title, author, year, publisher);
        this.subject = subject;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Subject: " + subject);
    }
}
