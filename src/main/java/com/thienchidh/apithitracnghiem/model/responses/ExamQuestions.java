package com.thienchidh.apithitracnghiem.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ExamQuestions {
    private String status;
    private String mssv;
    private String hoTen;
    private String baiThi;
    private String listCauHoi;
    private String dapAnA;
    private String dapAnB;
    private String dapAnC;
    private String dapAnD;
    private String dapAnE;
    private String dapAnF;
    private String diem;
    private List<Question> listCauHoiDetails;
}

