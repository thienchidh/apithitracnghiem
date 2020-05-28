package com.thienchidh.apithitracnghiem.model.responses;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@With
public class ListExamQuestions {
    private String nextId;
    private List<ExamQuestions> listData;
}

