package com.thienchidh.apithitracnghiem.model.responses;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@With
public class Exam {
    public static final String UPCOMING = "upcoming";
    public static final String RUNNING = "running";
    public static final String FINISHED = "finished";

    private String maLoaiKt;
    private String thoiGianBatDau;
    private long baoLau;
    private String thoiGianKetThuc;
    private String lop;
    @Builder.Default
    private String status = Exam.RUNNING;
    private String tenBaiThi;
    private String timeserver;
}

