class Magazine extends PrintedPublication {
    private int issueNumber;

    public Magazine(String title, String author, int year, int issueNumber) {
        super(title, author, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Issue Number: " + issueNumber);
    }
}