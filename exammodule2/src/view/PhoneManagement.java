package view;

import controller.PhoneChinhHangController;
import controller.PhoneXachTayController;

import java.util.Scanner;

public class PhoneManagement {
    private static final Scanner sc = new Scanner(System.in);
    private PhoneChinhHangController phoneChinhHangController = new PhoneChinhHangController();
    private PhoneXachTayController phoneXachTayController = new PhoneXachTayController();

    public void phoneChinhHangMenu() {
        do {
            System.out.println("-----QUAN LY DIEN THOAI CHINH HANG-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tThem moi.\n" +
                    "2.\tXoa.\n" +
                    "3.\tHien thi danh sach.\n" +
                    "4.\tTim kiem.\n" +
                    "5.\tThoat.\n" +
                    "6.\tQuay lai menu chinh.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    phoneChinhHangController.addPhoneChinhHang();
                    break;
                case 2:
                    phoneChinhHangController.removePhoneChinhHnag();
                    break;
                case 3:
                    phoneChinhHangController.getAll();
                    break;
                case 4:
                    phoneChinhHangController.findPhoneChinhHang();
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    mainMenu();
                    break;
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public void phoneXachTayMenu() {
        do {
            System.out.println("-----QUAN LY DIEN THOAI XACH TAY-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tThem moi.\n" +
                    "2.\tXoa.\n" +
                    "3.\tHien thi danh sach.\n" +
                    "4.\tTim kiem.\n" +
                    "5.\tThoat.\n" +
                    "6.\tQuay lai menu chinh.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    phoneXachTayController.addPhoneXachTay();
                    break;
                case 2:
                    phoneXachTayController.removePhoneXachTay();
                    break;
                case 3:
                    phoneXachTayController.getAll();
                    break;
                case 4:
                    phoneXachTayController.findPhoneXachTay();
                    break;
                case 5:
                    System.exit(0);
                case 6:
                    mainMenu();
                    break;
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public void mainMenu() {
        do {
            System.out.println("-----CHUONG TRINH QUAN LY DIEN THOAI-----\n" +
                    "Chon chuc nang theo so (de tiep tuc)\n" +
                    "1.\tQuan ly dien thoai chinh hang.\n" +
                    "2.\tQuan ly dien thoai xach tay.\n" +
                    "3.\tThoat.\n" +
                    "Chon chuc nang: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    phoneChinhHangMenu();
                    break;
                case 2:
                    phoneXachTayMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Vui long chon lai!");
            }
        } while (true);
    }

    public static void main(String[] args) {
        PhoneManagement phoneManagement = new PhoneManagement();
        phoneManagement.mainMenu();
    }
}
