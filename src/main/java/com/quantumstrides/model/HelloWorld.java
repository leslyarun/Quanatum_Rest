package com.quantumstrides.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by arun on 27-02-2017.
 */

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class HelloWorld {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;


}
