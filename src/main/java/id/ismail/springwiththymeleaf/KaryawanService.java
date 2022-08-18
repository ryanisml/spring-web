package id.ismail.springwiththymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KaryawanService {
    @Autowired
    private KaryawanRepository repo;

    public List<Karyawan> listAll(){
        return (List<Karyawan>) repo.findAll();
    }

    public void save(Karyawan karyawan) {
        repo.save(karyawan);
    }

    public Karyawan get(Integer id) throws KaryawanNotFoundException {
        Optional<Karyawan> karyawan = repo.findById(id);
        if (karyawan.isPresent()){
            return karyawan.get();
        }
        throw new KaryawanNotFoundException("Tidak ditemukan karyawan dengan ID "+id);
    }

    public void delete(Integer id) throws KaryawanNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new KaryawanNotFoundException("Tidak ditemukan karyawan dengan ID "+id);
        }
        repo.deleteById(id);
    }
}
