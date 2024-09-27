package repository.PhoneXachTay;

import common.IOPhoneXachTay;
import model.PhoneXachTay;

import java.util.Collections;
import java.util.List;

public class PhoneXachTayRepository implements IPhoneXachTayRepository {
    @Override
    public List<PhoneXachTay> getAll() {
        return IOPhoneXachTay.readPhoneXachTayFromFile();
    }

    @Override
    public void addPhoneChinhHang(PhoneXachTay phoneXachTay) {
        IOPhoneXachTay.writePhoneXachTay(phoneXachTay);
    }

    @Override
    public PhoneXachTay findPhoneXachTayById(int id) {
        return IOPhoneXachTay.findPhoneXachTayById(id);
    }

    @Override
    public void removePhoneXachTayById(PhoneXachTay phoneXachTay) {
        IOPhoneXachTay.removePhoneXachTay(phoneXachTay);
    }
}
