package id.ismail.springwiththymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class KaryawanController {
    @Autowired
    private KaryawanService service;

    @GetMapping("/karyawan")
    public String showKaryawan(Model model) {
        List<Karyawan> karyawanList = service.listAll();
        model.addAttribute("listKaryawan", karyawanList);
        return "karyawan";
    }

    @GetMapping("/karyawan/new")
    public String addKaryawan(Model model) {
        model.addAttribute("dataKaryawan", new Karyawan());
        model.addAttribute("pageTitle", "Tambah Data Karyawan");
        return "form-karyawan";
    }

    @PostMapping("/karyawan/save")
    public String saveKaryawan(Karyawan karyawan, RedirectAttributes ra) {
        service.save(karyawan);
        ra.addFlashAttribute("message", "Berhasil menambahkan karyawan baru");
        return "redirect:/karyawan";
    }

    @GetMapping("karyawan/edit/{id}")
    public String editKaryawan(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Karyawan karyawan = service.get(id);
            model.addAttribute("dataKaryawan", karyawan);
            model.addAttribute("pageTitle", "Ubah Data karyawan");
            return "form-karyawan";
        } catch (KaryawanNotFoundException e) {
            ra.addFlashAttribute("message", "Data karyawan tidak ditemukan.");
            return "redirect:/karyawan";
        }
    }

    @GetMapping("karyawan/delete/{id}")
    public String deleteKaryawan(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("pageTitle", "Data karyawan berhasil dihapus.");
        } catch (KaryawanNotFoundException e) {
            ra.addFlashAttribute("message", "Data karyawan tidak ditemukan.");
        }
        return "redirect:/karyawan";
    }
}
