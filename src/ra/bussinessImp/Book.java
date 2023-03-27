package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.List;
import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }


    @Override
    public void inputData(Scanner sc, List<Book> list) {
        System.out.println("Nhập vào mã sách: ");
        this.bookId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào tên sách:");
        this.bookName = sc.nextLine();
        System.out.println("Nhâp tiêu đề cho sách: ");
        this.title = sc.nextLine();
        System.out.println("Nhập số trang cho sách: ");
        this.numberOfPages = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập giá sách: ");
        this.importPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập giá bán sách: ");
        this.exportPrice = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập  trạng thái cho sách: ");
        this.bookStatus = Boolean.parseBoolean(sc.nextLine());
        this.interest = this.exportPrice - importPrice;
    }

    @Override
    public void displayData() {
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Mã sách là: %d\n", bookId);
        System.out.printf("Tên sách là: %s\n", bookName);
        System.out.printf("Tiêu đề sách là: %s\n", title);
        System.out.printf("Số trang sách: %d\n", numberOfPages);
        System.out.printf("Giá nhập sách: %.1f\n", importPrice);
        System.out.printf("Giá bán sách: %.1f\n", exportPrice);
        System.out.printf("Lợi nhuận: %.1f\n", interest);
        System.out.printf("Trạng thái sách: %s\n", bookStatus?"còn bán":"không bán");
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.interest- o.getInterest());
    }
}
