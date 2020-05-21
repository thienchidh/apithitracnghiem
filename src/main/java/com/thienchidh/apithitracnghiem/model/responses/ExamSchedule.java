package com.thienchidh.apithitracnghiem.model.responses;

import com.thienchidh.apithitracnghiem.model.entities.Account;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@With
public class ExamSchedule {
    private Account account;
    private Exam exam;
}

