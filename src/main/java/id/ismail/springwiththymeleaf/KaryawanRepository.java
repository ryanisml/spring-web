package id.ismail.springwiththymeleaf;

import org.springframework.data.repository.CrudRepository;

public interface KaryawanRepository extends CrudRepository<Karyawan, Integer> {
    public long countById(Integer id);
}
