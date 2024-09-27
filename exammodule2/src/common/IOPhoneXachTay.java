package common;

import model.PhoneXachTay;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOPhoneXachTay {
    private static final String PHONEXACHTAY_PATH = "src/data/PhongXachTay";

    public static void writePhoneXachTay(PhoneXachTay phoneXachTay) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PHONEXACHTAY_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = phoneXachTay.getId() + "," + phoneXachTay.getName() + "," + phoneXachTay.getPrice() + "," + phoneXachTay.getAmount() + "," +
                    phoneXachTay.getType() + "," + phoneXachTay.getCountry() + "," + phoneXachTay.getStatus();
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writePhoneXachTayListToFile(List<PhoneXachTay> phoneXachTayList) {
        try {
            FileWriter fileWriter = new FileWriter(PHONEXACHTAY_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (PhoneXachTay phoneXachTay : phoneXachTayList) {
                String data = phoneXachTay.getId() + "," + phoneXachTay.getName() + "," + phoneXachTay.getPrice() + "," + phoneXachTay.getAmount() + "," +
                        phoneXachTay.getType() + "," + phoneXachTay.getCountry() + "," + phoneXachTay.getStatus();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<PhoneXachTay> readPhoneXachTayFromFile() {
        List<PhoneXachTay> phoneXachTayList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PHONEXACHTAY_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String data = bufferedReader.readLine();
                if (data == null) {
                    break;
                }
                String[] arr = data.split(",");
                PhoneXachTay phoneXachTay = new PhoneXachTay(Integer.parseInt(arr[0]), arr[1], Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], arr[5], arr[6]);
                phoneXachTayList.add(phoneXachTay);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phoneXachTayList;
    }

    public static PhoneXachTay findPhoneXachTayById(int id) {
        List<PhoneXachTay> phoneXachTayList = readPhoneXachTayFromFile();
        for (PhoneXachTay phoneXachTay : phoneXachTayList) {
            if (phoneXachTay.getId() == id) {
                return phoneXachTay;
            }
        }
        return null;
    }

    public static void removePhoneXachTay(PhoneXachTay phoneXachTay) {
        List<PhoneXachTay> phoneXachTayList = readPhoneXachTayFromFile();
        for (int i = 0; i < phoneXachTayList.size(); i++) {
            if (phoneXachTayList.get(i).getId() == phoneXachTay.getId()) {
                phoneXachTayList.remove(i);
                writePhoneXachTayListToFile(phoneXachTayList);
                return;
            }
        }
    }

    public static int getNextId() {
        int count;
        try {
            FileReader file = new FileReader(PHONEXACHTAY_PATH);
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
