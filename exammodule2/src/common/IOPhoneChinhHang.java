package common;

import model.PhoneChinhHang;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPhoneChinhHang {
    private static final String PHONECHINHHANG_PATH = "src/data/PhoneChinhHang";

    public static void writePhoneChinhHangToFile(PhoneChinhHang phoneChinhHang) {
        try {
            FileWriter fileWriter = new FileWriter(PHONECHINHHANG_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = phoneChinhHang.getId() + "," + phoneChinhHang.getName() + "," + phoneChinhHang.getPrice() + "," + phoneChinhHang.getAmount() + "," +
                    phoneChinhHang.getType() + "," + phoneChinhHang.getTimeDate() + "," + phoneChinhHang.getArea();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writePhoneChinhHangListToFile(List<PhoneChinhHang> phoneChinhHangList) {
        try {
            FileWriter fileWriter = new FileWriter(PHONECHINHHANG_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (PhoneChinhHang phone : phoneChinhHangList) {
                String data = phone.getId() + "," + phone.getName() + "," + phone.getPrice() + "," + phone.getAmount() + "," +
                        phone.getType() + "," + phone.getTimeDate() + "," + phone.getArea();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<PhoneChinhHang> readPhoneChinhHangFromFile() {
        List<PhoneChinhHang> phoneChinhHangList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PHONECHINHHANG_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] arr = data.split(",");
                PhoneChinhHang phoneChinhHang = new PhoneChinhHang(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4],
                        Integer.parseInt(arr[5]), arr[6]);
                phoneChinhHangList.add(phoneChinhHang);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phoneChinhHangList;
    }

    public static PhoneChinhHang finePhoneChinhHangById(int id) {
        List<PhoneChinhHang> phoneChinhHangList = readPhoneChinhHangFromFile();
        for (PhoneChinhHang phone : phoneChinhHangList) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }

    public static void removePhoneChinhHang(PhoneChinhHang phoneChinhHang) {
        List<PhoneChinhHang> phoneChinhHangList = readPhoneChinhHangFromFile();
        for (int i = 0; i < phoneChinhHangList.size(); i++) {
            if (phoneChinhHangList.get(i).getId() == phoneChinhHang.getId()) {
                phoneChinhHangList.remove(i);
                writePhoneChinhHangListToFile(phoneChinhHangList);
                return;
            }
        }
    }

    public static int getNextId() {
        int count;
        try {
            FileReader file = new FileReader(PHONECHINHHANG_PATH);
            BufferedReader bufferedReader = new BufferedReader(file);
            count = 1;
            while (bufferedReader.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return count;
    }
}
