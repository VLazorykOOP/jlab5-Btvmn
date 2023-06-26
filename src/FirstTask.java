import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

abstract class AbstractPrintedPublicationComparator implements Comparator<PrintedPublication> {
    @Override
    public int compare(PrintedPublication pub1, PrintedPublication pub2) {
        return 0;
    }
}

public class FirstTask {
    public static void main(String[] args) {
        ArrayList<PrintedPublication> publications = new ArrayList<>();


        readPublicationsFromFile(publications, "book.txt", "magazine.txt", "textbook.txt");


        System.out.println("Прочитані дані:");
        for (PrintedPublication publication : publications) {
            publication.Show();
            System.out.println();
        }

        Collections.sort(publications);

        System.out.println("Відсортовані дані:");
        for (PrintedPublication publication : publications) {
            publication.Show();
            System.out.println();
        }

        addPublicationFromInput(publications);

        Collections.sort(publications);
        System.out.println("Відсортовані дані після додавання:");
        for (PrintedPublication publication : publications) {
            publication.Show();
            System.out.println();
        }

        ArrayList<PrintedPublication> abstractList = new ArrayList<>(publications);
        Collections.sort(abstractList, new AbstractPrintedPublicationComparator() {
            @Override
            public int compare(PrintedPublication pub1, PrintedPublication pub2) {
                return 0;
            }
        });

        writePublicationsToFile(abstractList, "sorted_publications.txt");
    }

    private static void readPublicationsFromFile(ArrayList<PrintedPublication> publications,
                                                 String bookFile, String magazineFile, String textbookFile) {
        try {
            Scanner scanner;

            scanner = new Scanner(new File(bookFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                int year = Integer.parseInt(parts[2].trim());
                String publisher = parts[3].trim();
                publications.add(new Book(title, author, year, publisher));
            }
            scanner.close();

            scanner = new Scanner(new File(magazineFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                int year = Integer.parseInt(parts[2].trim());
                int issueNumber = Integer.parseInt(parts[3].trim());
                publications.add(new Magazine(title, author, year, issueNumber));
            }
            scanner.close();

            scanner = new Scanner(new File(textbookFile));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String title = parts[0].trim();
                String author = parts[1].trim();
                int year = Integer.parseInt(parts[2].trim());
                String publisher = parts[3].trim();
                String subject = parts[4].trim();
                publications.add(new Textbook(title, author, year, publisher, subject));
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Помилка читання з файлу: " + e.getMessage());
        }
    }

    private static void addPublicationFromInput(ArrayList<PrintedPublication> publications) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Додавання запису");
        System.out.print("Введіть назву: ");
        String title = scanner.nextLine();

        System.out.print("Введіть автора: ");
        String author = scanner.nextLine();

        System.out.print("Введіть рік: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введіть видавництво: ");
        String publisher = scanner.nextLine();

        System.out.print("Введіть предмет (для підручників): ");
        String subject = scanner.nextLine();

        System.out.print("Введіть номер випуску (для журналів): ");
        int issueNumber = scanner.nextInt();


        System.out.println("Виберіть тип запису:");
        System.out.println("1. Книга");
        System.out.println("2. Журнал");
        System.out.println("3. Підручник");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                publications.add(new Book(title, author, year, publisher));
                break;
            case 2:
                publications.add(new Magazine(title, author, year, issueNumber));
                break;
            case 3:
                publications.add(new Textbook(title, author, year, publisher, subject));
                break;
            default:
                System.out.println("Невірний вибір");
                break;
        }
    }

    private static void writePublicationsToFile(ArrayList<PrintedPublication> publications, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);

            for (PrintedPublication publication : publications) {
                writer.write(publication.getTitle() + ","
                        + publication.getAuthor() + ","
                        + publication.getYear() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }
}
