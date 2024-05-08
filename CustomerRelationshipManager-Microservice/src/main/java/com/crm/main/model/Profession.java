package com.crm.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profession 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long professionId;
private String professionType;
private double professionSalary;
private String professionSalaryType;
private String professionWorkingPeriod;
private String professionDesignation;
@Lob
@Column(length = 200000)
private byte[] professionsalartSlips;



}
