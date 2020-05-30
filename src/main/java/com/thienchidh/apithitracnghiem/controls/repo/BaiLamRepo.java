package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.BaiLam;
import com.thienchidh.apithitracnghiem.model.entities.DeThi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaiLamRepo extends JpaRepository<BaiLam, Long> {
    Optional<BaiLam> findByDeThi(DeThi deThi);
}
