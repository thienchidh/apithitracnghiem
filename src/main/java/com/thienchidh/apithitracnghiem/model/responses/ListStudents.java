package com.thienchidh.apithitracnghiem.model.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListStudents {
    private String lop;
    private List<Student> listInfoSinhvien;
    private List<Exam> listInfoBaithi;
}

