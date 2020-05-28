package com.thienchidh.apithitracnghiem.controls.rest;

import com.thienchidh.apithitracnghiem.controls.repo.SinhVienRepo;
import com.thienchidh.apithitracnghiem.controls.service.AccountManager;
import com.thienchidh.apithitracnghiem.controls.service.BaiThiManager;
import com.thienchidh.apithitracnghiem.controls.service.DeThiManager;
import com.thienchidh.apithitracnghiem.model.entities.User;
import com.thienchidh.apithitracnghiem.model.responses.FavoriteClient;
import com.thienchidh.apithitracnghiem.model.responses.Question;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/apiThitracnghiem/api03/SinhVien")
public class Api03Controller {

    private DeThiManager deThiManager;
    private BaiThiManager baiThiManager;
    private AccountManager accountManager;

    private SinhVienRepo sinhVienRepo;


    @PostMapping("/postFavourite")
    public ResponseEntity<?> postFavourite(@RequestBody FavoriteClient favorite) {
        User userSever = accountManager.login(favorite.getAccount().getUsername(), favorite.getAccount().getPassword());
        if (userSever != null) {
            Question question = favorite.getQuestion();
            long id = userSever.getId();

            // TODO: 28/05/2020

        }
        return ResponseEntity.notFound().build();
    }

}
