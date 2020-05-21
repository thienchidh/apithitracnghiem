package com.thienchidh.apithitracnghiem.model.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    private String maso;
    private String name;
    private String email;
}

