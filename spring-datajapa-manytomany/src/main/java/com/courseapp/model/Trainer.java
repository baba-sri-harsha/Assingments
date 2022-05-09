package com.courseapp.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Trainer {

    @Column(length = 30)
    private String trainerName;
    @Id
    @GeneratedValue(generator = "trainer_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name="trainer_gen",sequenceName = "trainer_seq",initialValue = 1,allocationSize = 1)
    @ToString.Exclude
    private Integer trainerId;
    private double ratings;
    private int experience;
    private String techStack;
    private LocalDate joiningDate;

    //mapped nby the instance variable of the owning entity
    @ManyToMany(mappedBy ="trainers")
    @ToString.Exclude
    Set <Course> courses;

    public Trainer(String trainerName, double ratings, int experience, String techStack,  LocalDate joiningDate) {
        this.trainerName = trainerName;
        this.ratings = ratings;
        this.experience = experience;
        this.techStack = techStack;
        this.joiningDate = joiningDate;
    }


}
