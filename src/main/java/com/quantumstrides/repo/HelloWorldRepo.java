package com.quantumstrides.repo;

import com.quantumstrides.model.HelloWorld;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arun on 28-02-2017.
 */
public interface HelloWorldRepo extends JpaRepository<HelloWorld,Integer> {

}
