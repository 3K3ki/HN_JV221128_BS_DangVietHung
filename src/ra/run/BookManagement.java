package ra.run;


import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookManagement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Book> listBook = new ArrayList<>();

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách [15 điểm]\n" +
                    "2. Hiển thị thông tin các sách [15 điểm]\n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần [15 điểm]\n" +
                    "4. Xóa sách theo mã sách [10 điểm]\n" +
                    "5. Tìm kiếm sách theo tên sách [10 điểm]\n" +
                    "6. Thay đổi trạng thái của sách theo mã sách [10 điểm]\n" +
                    "7. Thoát [05 điểm]");
            System.out.println("mời bạn chọn: ");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập số sách:");
                    int countOfBook = Integer.parseInt(input.nextLine());
                    for (int i = 0; i < countOfBook; i++) {
                        System.out.println("Nhập sách thứ: " + (i + 1));
                        Book newbook = new Book();
                        newbook.inputData(input, listBook);
                        if (listBook.size() == 0) {
                            newbook.setBookId(1);
                        }
                        listBook.add(newbook);
                    }
                    System.out.println("Thêm sách thành công");
                    break;
                case 2:
                    noBook(listBook);
                    showListBook(listBook);
                    break;
                case 3:
                    noBook(listBook);
                    Collections.sort(listBook);
                    showListBook(listBook);
                    break;
                case 4:
                    System.out.println("Nhập sản phẩm cần xóa");
                    int deleteBookId = Integer.parseInt(input.nextLine());
                    noBook(listBook);
                    for (int i = 0; i < listBook.size(); i++) {
                        Book book = listBook.get(i);
                        if (book.getBookId() == deleteBookId){
                            listBook.remove(i);
                            System.out.println("Xoóa thành công sản phẩm có id " + deleteBookId);
                            break;
                        } else{
                            System.out.println("Không có id ");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhập vào tên sách muốn tìm: ");
                    String searchBookName = input.nextLine();
                    List<Book> listSearchBook = new ArrayList<>();
                    noBook(listBook);
                    for (Book book : listBook){
                        if(book.getBookName().contains(searchBookName)){
                            listSearchBook.add(book);
                            System.out.println("Sản phẩm cần tìm là: ");
                            showListBook(listSearchBook);
                        }else {
                            System.out.println("Không có sách cần tìm ");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Nhập vào mã sách : ");
                    int changeStatusBook = Integer.parseInt(input.nextLine());
                    noBook(listBook);
//                    for (int i = 0; i < listBook.size(); i++) {
//                        Book book = listBook.get(i);
//                        if (book.getBookId() == changeStatusBook){
//                            int bookStatus = book.isBookStatus() ? 0 : 1;
//                            System.out.println("Book status: " + bookStatus);
//                            break;
//                        } else{
//                            System.out.println("Không có id ");
//                        }
//                    }
                    break;
                case 7:
                    System.out.println("Thoát chương trình: ");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này ");
                    break;
            }
        }
    }

    public static void showListBook(List<Book> list) {
        for (Book book : list) {
            book.displayData();
        }
    }
    public static void noBook(List<Book> list ) {
        if(list.size() == 0) {
            System.out.println("Không có sách nào, mời bạn thêm sách");
        }
    }
}