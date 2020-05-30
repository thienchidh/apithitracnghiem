package com.thienchidh.apithitracnghiem.controls.rest;

import com.thienchidh.apithitracnghiem.adapter.ExamAdapter;
import com.thienchidh.apithitracnghiem.adapter.StudentAdapter;
import com.thienchidh.apithitracnghiem.controls.repo.*;
import com.thienchidh.apithitracnghiem.controls.service.*;
import com.thienchidh.apithitracnghiem.model.entities.*;
import com.thienchidh.apithitracnghiem.model.responses.ExamQuestions;
import com.thienchidh.apithitracnghiem.model.responses.ListQuestions;
import com.thienchidh.apithitracnghiem.model.responses.ListStudents;
import com.thienchidh.apithitracnghiem.model.responses.UserResponse;
import lombok.AllArgsConstructor;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/apiThitracnghiem/api01/General")
public class Api01Controller {
    private AccountManager accountManager;
    private BaiThiManager baiThiManager;
    private ClassManager classManager;
    private QuestionManager questionManager;
    private DeThiManager deThiManager;

    private AccountRepo accountRepo;
    private BaiLamRepo baiLamRepo;
    private BaiThiRepo baiThiRepo;
    private CauHoiRepo cauHoiRepo;
    private DanhSachCauHoiRepo danhSachCauHoiRepo;
    private DapAnRepo dapAnRepo;
    private DeThiRepo deThiRepo;
    private FavoriteRepo favoriteRepo;
    private GiangVienRepo giangVienRepo;
    private SinhVienRepo sinhVienRepo;
    private UserRepo userRepo;
    private ExamAdapter examAdapter;
    private StudentAdapter studentAdapter;

    private ListInfoOfLop listInfoOfLop;

    @PostMapping("/getAuthen")
    public ResponseEntity<UserResponse> login(@RequestBody @NotNull Account clientAccount) {
        User user = accountManager.login(clientAccount.getUsername(), clientAccount.getPassword());
        if (user != null) {
            var result = new UserResponse();
            if (user instanceof SinhVien) {
                result.setMaso(user.getMaSo());
                result.setName(user.getHoTen());
                result.setLop(((SinhVien) user).getLop());
                result.setRole("sinhvien");

                return ResponseEntity.ok(result);
            } else if (user instanceof GiangVien) {
                result.setMaso(user.getMaSo());
                result.setName(user.getHoTen());
                result.setLop("");
                result.setRole("giangvien");
                return ResponseEntity.ok(result);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> action(@RequestParam(required = false) String doing,
                                    @RequestParam(required = false) String actionInfo,
                                    @RequestParam(required = false) String mssv,
                                    @RequestParam(required = false) int startId,
                                    @RequestParam(required = false) String lop,
                                    @RequestParam(required = false) String bai_thi,
                                    @RequestParam(required = false) String key,
                                    @RequestBody(required = false) Account account) {
        if (!accountManager.isAccountValid(account)) {
            return ResponseEntity.notFound().build();
        }

        switch (doing) {
            case "getInfo": {
                switch (actionInfo) {
                    case "getDiem_Baithi": {
                        //doing=getInfo&actionInfo=getDiem_Baithi&mssv=$_studentCode&bai_thi=$_examCode'
                        return getDiem_Baithi(mssv, bai_thi);
                    }
                    case "getDethi": {
                        //doing=getInfo&actionInfo=getDethi&mssv=$_studentCode&bai_thi=$_examCode';
                        return getDethi(mssv, bai_thi);
                    }
                    case "getInfoDethiOfLopBaithi": {
                        //?doing=getInfo&actionInfo=getInfoDethiOfLopBaithi&lop=$_lop&bai_thi=$_examCode&startId=$_startId';
                        return getInfoDethiOfLopBaithi(lop, bai_thi, startId);
                    }
                    case "getInfoDethiOfMSSVBaithi": {
                        //doing=getInfo&actionInfo=getInfoDethiOfMSSVBaithi&mssv=$_studentCode&startId=$_startId';
                        return getInfoDethiOfMSSVBaithi(mssv, startId);
                    }
                    case "getFavourite": {
                        //?doing=getInfo&actionInfo=getFavourite&mssv=$_studentCode&startId=$_startId';
                        return getFavourite(mssv, startId);// ok
                    }
                    case "getDSLop": {
                        //doing=getInfo&actionInfo=getDSLop
                        return getDSLop();// ok
                    }
                    case "getListInfoOfLop": {
                        if (mssv == null || mssv.isEmpty()) {
                            //doing=getInfo&actionInfo=getListInfoOfLop&lop=$_lop'
                            return getListInfoOfLop(lop);// ok
                        }
                        //doing=getInfo&actionInfo=getListInfoOfLop&lop=$_lop&mssv=$_studentCode';
                        return getListInfoOfLop(lop, mssv);// ok
                    }
                    default: {
                        break;
                    }
                }
            }
            default: {
                break;
            }
        }
        return ResponseEntity.ok().build();
    }

    @NotNull
    private ResponseEntity<?> getInfoDethiOfMSSVBaithi(@NotNull String mssv, int startId) {
        return null;
    }

    @NotNull
    private ResponseEntity<?> getInfoDethiOfLopBaithi(@NotNull String lop, @NotNull String bai_thi, int startId) {
        return null;
    }

    @NotNull
    private ResponseEntity<?> getDethi(@NotNull String mssv, @NotNull String bai_thi) {

        ExamQuestions body = new ExamQuestions();

        return ResponseEntity.ok(body);
    }

    @NotNull
    private ResponseEntity<ExamQuestions> getDiem_Baithi(@NotNull String mssv, @NotNull String maBaiThi) {
        Optional<SinhVien> byMaSo = sinhVienRepo.findByMaSo(mssv);
        if (byMaSo.isPresent()) {
            Optional<BaiThi> byMaBaiThi = baiThiRepo.findByMaBaiThi(maBaiThi);
            if (byMaBaiThi.isPresent()) {
                if (byMaBaiThi.get().getStatus() != BaiThi.Status.DISABLED) {
                    DeThi deThi = deThiManager.getDeThi(byMaSo.get(), byMaBaiThi.get());
                    if (deThi != null) {
                        return ResponseEntity.ok(baiThiManager.getDiemBaiThi(deThi));
                    }
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    @NotNull
    private ResponseEntity<ListStudents> getListInfoOfLop(@NotNull String lop, @NotNull String mssv) {// ok
        return ResponseEntity.ok(listInfoOfLop.getListInfoOfLop(lop, mssv));
    }

    @NotNull
    private ResponseEntity<?> getListInfoOfLop(@NotNull String lop) {// ok
        return ResponseEntity.ok(listInfoOfLop.getListInfoOfLop(lop));
    }

    @NotNull
    private ResponseEntity<ListQuestions> getFavourite(@NotNull String mssv, int startId) {// ok
        return sinhVienRepo.findByMaSo(mssv).map(sinhVien -> ResponseEntity.ok(questionManager.getFavorite(sinhVien, startId))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @NotNull
    private ResponseEntity<?> getDSLop() {// ok
        return ResponseEntity.ok(classManager.getListClass());
    }
}
