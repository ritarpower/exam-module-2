package repository.PhoneChinhHang;

import model.PhoneChinhHang;

import java.util.List;

public interface IPhoneChinhHangRepository {
    List<PhoneChinhHang> getAll();

    void addPhoneChinhHang(PhoneChinhHang phoneChinhHang);

    PhoneChinhHang findPhoneChinhHangById(int id);

    void removePhoneChinhHang(PhoneChinhHang phoneChinhHang);
}
