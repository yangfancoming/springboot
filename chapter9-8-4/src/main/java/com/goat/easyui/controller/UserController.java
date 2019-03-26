package com.goat.easyui.controller;


import com.github.pagehelper.PageInfo;
import com.goat.easyui.domain.User;
import com.goat.easyui.resultmodel.RestResult;
import com.goat.easyui.resultmodel.ResultGenerator;
import com.goat.easyui.service.IUserService;
import com.goat.easyui.utils.GoatInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    private final ResultGenerator generator = new ResultGenerator();

	@Autowired
	private IUserService userService;

//	@RequestMapping("user")
//	public String index(Model model) {
//		User user = super.getCurrentUser();
//		model.addAttribute("user", user);
//		return "/user/userList";
//	}

//    @RequestMapping("/getUser")
//    public RestResult getUser(Long userId) {
//        User user = userService.findById(4L);
//        return generator.getSuccessResult("添加角色成功",user,1);
//    }

    /**
         Map<String, Object> jsonMap = new HashMap<>();
         jsonMap.put("total", pageInfo.getTotal());   // total 存放总记录数
         jsonMap.put("rows", pageInfo.getList());  // rows存放每页记录 ，这里的两个参数名是固定的，必须为 total和 rows
         return jsonMap;
    */
    // http://localhost:8984/user/list
    @GetMapping("/list1")
    public RestResult userList(User user) {
//        PageHelper.startPage(request.getPage(), request.getRows());
//        List<User> list = userService.findByPage(request.getPage(), request.getRows());
        List<User> list = userService.findByPage(1, 10);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
    }


    @GetMapping("/list2") //doit 这种方法 失败
    public RestResult userList(HttpServletRequest request) throws Exception {
        Map mv1 = GoatInfo.getInfo(request);
        List<User> list = userService.findByPage(1, 10);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return generator.getSuccessUiResult("datang", pageInfo.getList(), pageInfo.getTotal());
    }

    // http://localhost:8984/user/list
    @PostMapping("/save")
    public RestResult saveUser(User user) {
        boolean save = userService.save(user);
        System.out.println(save);
        return generator.getSuccessResult();
    }
//
//
//
//	@RequestMapping("user/delete")
//	@ResponseBody
//	public ResponseBo deleteUsers(String ids) {
//		try {
//			this.userService.deleteUsers(ids);
//			return ResponseBo.ok("删除用户成功！");
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseBo.error("删除用户失败，请联系网站管理员！");
//		}
//	}

}
