package com.quantumstrides.controller;

import com.quantumstrides.model.HelloWorld;
import com.quantumstrides.repo.HelloWorldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arun on 27-02-2017.
 */

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private HelloWorldRepo helloWorldRepo;


    @RequestMapping(method = RequestMethod.GET,value = "/create/{name}")
    public HelloWorld helloApi(@PathVariable("name")String name, HelloWorld helloWorld){

        helloWorld.setName(name);
        helloWorldRepo.save(helloWorld);

        return helloWorld;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/create")
    public ResponseEntity<List<HelloWorld>> showHellos(){

        List<HelloWorld> helloWorlds1 = helloWorldRepo.findAll();

        if (helloWorlds1.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<HelloWorld>>(helloWorlds1,HttpStatus.OK);

    }

//    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
//    public ResponseEntity<?> getUser(@PathVariable("id") int id) {
//        HelloWorld user = helloWorldRepo.findOne(id);
//        if (user == null) {
//            return new ResponseEntity("User with id " + id
//                    + " not found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<HelloWorld>(user, HttpStatus.OK);
//    }
}
