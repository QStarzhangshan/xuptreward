package cn.xupt.reward.framework.shiro.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ShiroController {
    @RequestMapping({"/unauth"})
    @ResponseBody
    public Object unauth() {
        System.out.println(111);
        Map<String, Object> map = new HashMap();
        map.put("code", "1000000");
        map.put("msg", "未登录");
        return map;
    }
}