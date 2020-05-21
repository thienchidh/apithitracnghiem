package com.thienchidh.apithitracnghiem.controls.repo;

import com.thienchidh.apithitracnghiem.model.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {


}
