/*
 * Copyright © 2019 NeuroByte Tech. All rights reserved.
 *
 * NeuroByte Tech is the Developer Company of Rohan Mathew.
 *
 * Project: RestService
 * File Name: GreetingController.java
 * Last Modified: 31/12/2019, 14:57
 */

package tech.neurobyte.dev.restservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        Greeting greeting =  new Greeting(counter.incrementAndGet(), String.format(template, name));
        System.out.println(String.format("Id. %s: \"%s\"", greeting.getId(), greeting.getContent()));

        return greeting;
    }
}
