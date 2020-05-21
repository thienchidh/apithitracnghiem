package com.thienchidh.apithitracnghiem.controls.service;

import com.thienchidh.apithitracnghiem.model.entities.SinhVien;
import com.thienchidh.apithitracnghiem.model.responses.ListClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ClassManagerTest {
    @Test
    void testGetListClass() {

        List<SinhVien> all = new ArrayList<>();
        all.add(new SinhVien("1", new Date()));
        all.add(new SinhVien("1", new Date()));
        all.add(new SinhVien("2", new Date()));
        all.add(new SinhVien("2", new Date()));
        all.add(new SinhVien("1", new Date()));
        all.add(new SinhVien("1", new Date()));
        all.add(new SinhVien("3", new Date()));
        all.add(new SinhVien("1", new Date()));

        ListClass result = new ListClass();
        result.setListData(all.parallelStream().map(SinhVien::getLop).distinct().collect(Collectors.toList()));
        result.setSize(result.getListData().size());

        assertEquals(3, result.getSize());
    }
}