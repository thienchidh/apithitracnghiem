package com.thienchidh.apithitracnghiem.model.responses;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListStudentsTest {


    @Test
    void testToJson() throws JsonProcessingException {
        ListStudents value = new ListStudents();
        value.setLop("1");
        value.setListInfoBaithi(createListInfoBaiThi());
        value.setListInfoSinhvien(createListInfoSinhVien());

        String json = new ObjectMapper().writeValueAsString(value);
        assertNotNull(json);
        System.out.println(json);
    }

    private List<Student> createListInfoSinhVien() {
        List<Student> list = new ArrayList<>();

        list.add(Student.builder()
                .email("abc@gmail.com")
                .name("Họ tên")
                .maso("123")
                .build());
        return list;
    }

    private List<Exam> createListInfoBaiThi() {
        List<Exam> list = new ArrayList<>();

        list.add(Exam.builder()
                .lop("16ct")
                .maLoaiKt("auto_gen_01")
                .baoLau(30)
                .timeserver(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .thoiGianBatDau(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .thoiGianKetThuc(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()))
                .status(Exam.RUNNING)
                .build());
        return list;
    }

}