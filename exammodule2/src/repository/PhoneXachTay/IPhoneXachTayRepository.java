package repository.PhoneXachTay;

import model.PhoneXachTay;

import java.util.List;

public interface IPhoneXachTayRepository {
    List<PhoneXachTay> getAll();

    void addPhoneChinhHang(PhoneXachTay phoneXachTay);

    PhoneXachTay findPhoneXachTayById(int id);

    void removePhoneXachTayById(PhoneXachTay phoneXachTay);
}
