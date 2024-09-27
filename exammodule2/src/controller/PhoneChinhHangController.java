package controller;

import common.IOPhoneChinhHang;
import model.PhoneChinhHang;
import repository.PhoneChinhHang.IPhoneChinhHangRepository;
import repository.PhoneChinhHang.PhoneChinhHangRepository;

import java.util.List;
import java.util.Scanner;

public class PhoneChinhHangController {
    private static final Scanner sc = new Scanner(System.in);
    private IPhoneChinhHangRepository phoneChinhHangRepository = new PhoneChinhHangRepository();

    public void getAll() {
        List<PhoneChinhHang> phoneChinhHangList = phoneChinhHangRepository.getAll();
        for (PhoneChinhHang phoneChinhHang : phoneChinhHangList) {
            if (phoneChinhHang != null) {
                System.out.println(phoneChinhHang);
            } else {
                return;
            }
        }
    }

    public void addPhoneChinhHang() {
        int id = IOPhoneChinhHang.getNextId();
        String name;
        do {
            System.out.println("Nhap ten san pham :");
            name = sc.nextLine();
        } while (name.isEmpty());
        String price1;
        do {
            System.out.println("Nhap gia san pham: ");
            price1 = sc.nextLine();
        } while (!Validate.isValidNumber(price1));
        double price = Double.parseDouble(price1);
        String amount1;
        do {
            System.out.println("Nhap so luong san pham: ");
            amount1 = sc.nextLine();
        } while (!Validate.isValidNumber(amount1));
        int amount = Integer.parseInt(amount1);
        String type;
        do {
            System.out.println("Nhap nha san suat: ");
            type = sc.nextLine();
        } while (type.isEmpty());
        String timeDate1;
        do {
            System.out.println("Nhap thoi gian bao hanh (khong qua 730 ngay): ");
            timeDate1 = sc.nextLine();
        } while (!Validate.isValidTimeDate(timeDate1));
        int timeDate = Integer.parseInt(timeDate1);
        String area;
        do {
            System.out.println("Nhap pham vi bao hanh ( Toan Quoc hoac Quoc Te ): ");
            area = sc.nextLine();
        } while (!Validate.isValidArea(area));
        PhoneChinhHang phoneChinhHang = new PhoneChinhHang(id, name, price, amount, type, timeDate, area);
        phoneChinhHangRepository.addPhoneChinhHang(phoneChinhHang);
        System.out.println("Da them moi san pham thanh cong!");
    }

    public void findPhoneChinhHang() {
        System.out.println("Nhap id san pham can tim kiem: ");
        int id = Integer.parseInt(sc.nextLine());
        PhoneChinhHang phoneChinhHang = phoneChinhHangRepository.findPhoneChinhHangById(id);
        System.out.println(phoneChinhHang);
    }

    public void removePhoneChinhHnag() {
        System.out.printf("Nhap id san pham can tim xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        PhoneChinhHang phoneChinhHang = phoneChinhHangRepository.findPhoneChinhHangById(id);
        if (phoneChinhHang != null) {
            confirmRemovePhoneChinhHang(phoneChinhHang);
        } else {
            System.out.println("Khong tim thay id san pham can xoa!");
        }
    }

    public void confirmRemovePhoneChinhHang(PhoneChinhHang phoneChinhHang) {
        System.out.println("Ban chac chan muon xoa dien thoai chinh hang id " + phoneChinhHang.getId() + " chu?\n " +
                "\t 1.Co \t 2.Khong\n" +
                "Chon muc:");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                phoneChinhHangRepository.removePhoneChinhHang(phoneChinhHang);
                System.out.println("Da xoa thanh cong!");
                break;
            case 2:
                System.out.println("Chon lai muc khac!");
                break;
            default:
                System.out.println("Thao tac khong thanh cong!");
        }
    }
}
