package com.goat.controller;

import com.goat.chapter001.entity.City;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    // http://localhost:8265/city/findOne
	@RequestMapping("/findOne")
	public String findOne(Model model) {
        City city = new City(111L,222L,"sdf","sdfdf");
        model.addAttribute("city", city);

        model.addAttribute("date", new Date());
        model.addAttribute("val", 123);
        return "city";
	}

    // http://localhost:8265/city/findList
    @RequestMapping("/findList")
    public String findList(Model model) {
        City city1 = new City(111L,222L,"111","1111111");
        City city2 = new City(123L,234L,"222","222222");
        City city3 = new City(123L,234L,"333","333333");
        City city4 = new City(123L,234L,"444","444444");
        List<City> citys = new ArrayList<>();
        citys.add(city1);
        citys.add(city2);
        citys.add(city3);
        citys.add(city4);
        model.addAttribute("cityList", citys);
        return "cityList";
    }




}
