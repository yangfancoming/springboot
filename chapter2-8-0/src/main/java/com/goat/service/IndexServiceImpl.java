package com.goat.service;

import com.goat.model.Index;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class IndexServiceImpl {

    public List<Index> findAll() {
        List<Index> lists = new ArrayList<>();
        lists.add(new Index(1,"1",200));
        lists.add(new Index(2,"2",100));
        lists.add(new Index(2,"3",300));
        return lists;
    }

}
