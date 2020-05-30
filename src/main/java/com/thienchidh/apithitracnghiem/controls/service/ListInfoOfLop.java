package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.adapter.ExamAdapter;
import com.thienchidh.apithitracnghiem.adapter.StudentAdapter;
import com.thienchidh.apithitracnghiem.controls.repo.*;
import com.thienchidh.apithitracnghiem.model.responses.Exam;
import com.thienchidh.apithitracnghiem.model.responses.ListStudents;
import com.thienchidh.apithitracnghiem.model.responses.Student;
import lombok.AllArgsConstructor;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ListInfoOfLop {
    private AccountManager accountManager;
    private ClassManager classManager;
    private QuestionManager questionManager;

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

    public ListStudents getListInfoOfLop(@NotNull String lop) {
        ListStudents students = new ListStudents();
        students.setLop(lop);

        var sinhVienRepoAllByLop = sinhVienRepo.findAllByLop(lop);
        List<Student> convert = studentAdapter.convert(sinhVienRepoAllByLop);
        students.setListInfoSinhvien(convert);

        var baiThiRepoAllByLop = baiThiRepo.findAllByLop(lop);
        List<Exam> examsConvert = examAdapter.convert(baiThiRepoAllByLop);
        students.setListInfoBaithi(examsConvert);

        return students;
    }

    public ListStudents getListInfoOfLop(@NotNull String lop, @NotNull String mssv) {

        ListStudents students = new ListStudents();
        students.setLop(lop);

        var sinhVienRepoAllByLop = sinhVienRepo.findAllByMaSo(mssv);
        List<Student> convert = studentAdapter.convert(sinhVienRepoAllByLop);
        students.setListInfoSinhvien(convert);

        var baiThiRepoAllByLop = baiThiRepo.findAllByLop(lop);
        List<Exam> examsConvert = examAdapter.convert(baiThiRepoAllByLop);
        students.setListInfoBaithi(examsConvert);

        return students;
    }
}