package controller;

import common.IOPhoneXachTay;
import model.PhoneXachTay;
import repository.PhoneXachTay.IPhoneXachTayRepository;
import repository.PhoneXachTay.PhoneXachTayRepository;

import java.util.List;
import java.util.Scanner;

public class PhoneXachTayController {
    private static final Scanner sc = new Scanner(System.in);
    private IPhoneXachTayRepository phoneXachTayRepository = new PhoneXachTayRepository();

    public void getAll() {
        List<PhoneXachTay> phoneXachTayList = phoneXachTayRepository.getAll();
        for (PhoneXachTay phoneXachTay : phoneXachTayList) {
            if (phoneXachTay != null) {
                System.out.println(phoneXachTay);
            } else {
                return;
            }
        }
    }

    public void addPhoneXachTay() {
        int id = IOPhoneXachTay.getNextId();
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
        String country;
        do {
            System.out.println("Nhap xuat xu san pham (Vui long khong dien Viet Nam) : ");
            country = sc.nextLine();
        } while (!Validate.isValidCountry(country));
        String status;
        do {
            System.out.println("Nhap trang thai san pham (Da sua chua hoac Chua sua chua): ");
            status = sc.nextLine();
        } while (!Validate.isValidStatus(status));
        PhoneXachTay phoneXachTay = new PhoneXachTay(id, name, price, amount, type, country, status);
        phoneXachTayRepository.addPhoneChinhHang(phoneXachTay);
        System.out.println("Da them moi san pham thanh cong!");
    }

    public void findPhoneXachTay() {
        System.out.println("Nhap id san pham can tim kiem: ");
        int id = Integer.parseInt(sc.nextLine());
        PhoneXachTay phoneXachTay = phoneXachTayRepository.findPhoneXachTayById(id);
        System.out.println(phoneXachTay);
    }

    public void removePhoneXachTay() {
        System.out.println("Nhap id san pham can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        PhoneXachTay phoneXachTay = phoneXachTayRepository.findPhoneXachTayById(id);
        if (phoneXachTay != null) {
            confirmRemovePhoneXachTay(phoneXachTay);
        } else {
            System.out.println("Khong tim thay id san pham can xoa!");
        }
    }

    public void confirmRemovePhoneXachTay(PhoneXachTay phoneXachTay) {
        System.out.println("Ban chac chan muon xoa dien thoai xach tay id " + phoneXachTay.getId() + " chu?\n " +
                "\t 1.Co \t 2.Khong\n" +
                "Chon muc:");
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1:
                phoneXachTayRepository.removePhoneXachTayById(phoneXachTay);
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
