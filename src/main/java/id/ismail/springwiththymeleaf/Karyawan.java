package id.ismail.springwiththymeleaf;

import javax.persistence.*;

@Entity
@Table(name = "tb_karyawan")
public class Karyawan {
    @Id
    @Column(name = "col_nik")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, name = "col_nama")
    private String nama;
    @Column(nullable = false, unique = true, length = 50, name = "col_email")
    private String email;
    @Column(length = 15, name = "col_password")
    private String password;
    private boolean isEnabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
