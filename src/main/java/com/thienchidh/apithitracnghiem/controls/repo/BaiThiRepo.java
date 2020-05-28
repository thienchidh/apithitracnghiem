package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.BaiThi;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BaiThiRepo extends JpaRepository<BaiThi, Long> {
    Optional<BaiThi> findByMaBaiThi(String maBaiThi);

    List<BaiThi> findAllByLop(@NonNull String lop);
}
