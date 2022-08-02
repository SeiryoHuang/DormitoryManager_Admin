package com.seiryo.controller;


import com.seiryo.po.Dormitory;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormitoryService;
import com.seiryo.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class DormitoryController {
    // 依赖注入
    @Autowired
    private DormitoryService dormitoryService;

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findDormitory")
    public String findDormitory(String d_dormbuilding, String a_name,Integer pageIndex,
                            Integer s_dormitoryid ,Integer pageSize, Model model) {
        PageInfo<Dormitory> di = dormitoryService.findPageInfo(d_dormbuilding,a_name,
                s_dormitoryid,pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormitory_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportDormitorylist" , method = RequestMethod.POST)
    @ResponseBody
    public List<Dormitory> exportDormitory(){
        List<Dormitory> dormitory = dormitoryService.getAll();
        return dormitory;
    }

    /**
     * 添加宿舍信息
     */
    @RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormitory( @RequestBody Dormitory dormitory) {

        //dormitory.setA_password(MD5Util.MD5EncodeUtf8(dormitory.getA_password()));
        int a = dormitoryService.addDormitory(dormitory);
        return "dormitory_list";
    }

    /**
     * 删除宿舍信息；将请求体d_id写入参数d_id
     */
    @RequestMapping( "/deleteDormitory")
    @ResponseBody
    public String deleteDormitory(Integer d_id) {
        int a = dormitoryService.deleteDormitory(d_id);
        return "dormitory_list";
    }

    /**
     * 修改宿舍信息
     */
    /**
     * 将提交数据(a_id,a_username...)写入Dormitory对象
     */
    @RequestMapping( value = "/updateDormitory", method = RequestMethod.POST)
    public String updateDormitory(Dormitory dormitory) {

        //dormitory.setA_password(MD5Util.MD5EncodeUtf8(dormitory.getA_password()));
        int a = dormitoryService.updateDormitory(dormitory);
        return "redirect:/findDormitory";
    }


    /**
     * 根据宿舍Id搜索;将请求数据d_id写入参数d_id
     */
    @RequestMapping( "/findDormitoryById")
    public String findDormitoryById( Integer d_id,HttpSession session) {
        Dormitory d= dormitoryService.findDormitoryById(d_id);
        session.setAttribute("d",d);
        return "dormitory_edit";
    }

}
