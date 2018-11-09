package com.goat.controller;

import com.goat.domain.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/city")
public class FreemarkController {

    // http://localhost:8265/city/findOne
	@RequestMapping("/findOne")
	public String findOne(Model model) {
        City city = new City(111L,222L,"sdf","sdfdf");
        model.addAttribute("city", city);
        return "city";
	}

    // http://localhost:8265/city/findList
    @RequestMapping("/findList")
    public String findList(Model model) {
        City city1 = new City(111L,222L,"sdf1","sdfdf1");
        City city2 = new City(123L,234L,"sdf2","sdfdf2");
        List<City> citys = new ArrayList<>();
        citys.add(city1);
        citys.add(city2);
        model.addAttribute("cityList", citys);
        return "cityList";
    }




}
