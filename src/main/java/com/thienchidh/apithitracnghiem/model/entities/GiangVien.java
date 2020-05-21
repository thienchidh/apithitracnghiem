package com.thienchidh.apithitracnghiem.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "GiangVien")
@Data
public class GiangVien extends User {

}
