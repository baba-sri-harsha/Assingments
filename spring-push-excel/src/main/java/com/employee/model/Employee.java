package com.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *Employee entity
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue
    private Integer employeeId;

    @Column(length =30)
    private String name;
    @Column(length =30)
    private String designation;
    @Column(length =30)
    private String department;
    @Column(length =50)
    private String address;
    private double salary;
    private int experience; //in years

    public Employee(String name, String designation, String department, String address, double salary, int experience) {
        this.name = name;
        this.designation = designation;
        this.department = department;
        this.address = address;
        this.salary = salary;
        this.experience = experience;
    }
}
