package repository.PhoneChinhHang;

import common.IOPhoneChinhHang;
import model.PhoneChinhHang;

import java.util.Collections;
import java.util.List;

public class PhoneChinhHangRepository implements IPhoneChinhHangRepository {
    @Override
    public List<PhoneChinhHang> getAll() {
        return IOPhoneChinhHang.readPhoneChinhHangFromFile();
    }

    @Override
    public void addPhoneChinhHang(PhoneChinhHang phoneChinhHang) {
        IOPhoneChinhHang.writePhoneChinhHangToFile(phoneChinhHang);
    }

    @Override
    public PhoneChinhHang findPhoneChinhHangById(int id) {
        return IOPhoneChinhHang.finePhoneChinhHangById(id);
    }

    @Override
    public void removePhoneChinhHang(PhoneChinhHang phoneChinhHang) {
        IOPhoneChinhHang.removePhoneChinhHang(phoneChinhHang);
    }
}
