package com.thienchidh.apithitracnghiem.adapter;

import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.Student;
import lombok.var;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentAdapter {
    @NotNull
    public Student convert(@NotNull SinhVien sinhVien) {
        return Student.builder()
                .maso(sinhVien.getMaSo())
                .name(sinhVien.getHoTen())
                .email(sinhVien.getEmail())
                .build();
    }

    @NotNull
    public List<Student> convert(@NotNull List<SinhVien> list) {
        List<Student> exams = new ArrayList<>();
        for (var e : list) {
            exams.add(convert(e));
        }
        return exams;
    }
}


