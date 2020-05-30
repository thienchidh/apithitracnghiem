package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.Favorite;
import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    List<Favorite> findAllBySinhVien(SinhVien sinhVien);

    Page<Favorite> findAllBySinhVien(SinhVien sinhVien, Pageable page);
}
