package com.goat.doit.table;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 64274 on 2019/6/12.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/6/12---20:52
 */
@Controller
@RequestMapping("/table")
public class TableController {

    //    http://localhost:8216/transfer/table
    @GetMapping("/list")
    public String table() {
        return "table/table";
    }

}
