package com.thienchidh.apithitracnghiem.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@With
public class Question {
    public static final String undefinedAnswer = "_";

    private long id;
    private String content;

    @JsonProperty("dap_an_a")
    private String dapAnA;
    @JsonProperty("dap_an_b")
    private String dapAnB;
    @JsonProperty("dap_an_c")
    private String dapAnC;
    @JsonProperty("dap_an_d")
    private String dapAnD;
    @JsonProperty("dap_an_e")
    private String dapAnE;
    @JsonProperty("dap_an_f")
    private String dapAnF;

    private String direction;// -1: left to right | else right to left
    private int position;// index of answer

    @JsonProperty("dap_an_dung")
    private String dapAnDung;// randomize

    private int rate;

    @JsonProperty("thuoc_chuong")
    private String thuocChuong;

    private String answerOfUser;
    private int isFavorite;

}

