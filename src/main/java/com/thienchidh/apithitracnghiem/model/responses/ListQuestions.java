package com.thienchidh.apithitracnghiem.model.responses;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@With
public class ListQuestions {
    private int nextId;
    private List<Question> listData;
}

