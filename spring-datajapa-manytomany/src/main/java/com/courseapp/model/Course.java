package com.courseapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Course {

    @Column(length = 30)
    private String courseName;
    @Id
    @GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="course_gen",sequenceName = "course_seq",initialValue = 1,allocationSize = 1)
    @ToString.Exclude
    private Integer courseId;
    private double fees;
    private int durationDays;
    private String category;
    @ManyToMany(cascade =  CascadeType.ALL,fetch = FetchType.EAGER)//CascadeType.All
    @JoinTable(
            name="course_trainer",
            joinColumns = { @JoinColumn(name="course_id") //refers to primary key of owner entity"
                     },
            inverseJoinColumns ={
                    @JoinColumn(name="trainer_id")// refers to primary key of child entity
            }

    )
    private Set<Trainer> trainers;

    public Course(String courseName, double fees, int durationDays,String category) {
        this.courseName = courseName;
        this.fees = fees;
        this.durationDays = durationDays;
        this.category=category;
    }
}
