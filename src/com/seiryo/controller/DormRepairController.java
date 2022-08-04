package com.seiryo.controller;


import com.seiryo.po.DormRepair;
import com.seiryo.po.PageInfo;
import com.seiryo.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class DormRepairController {
    // 依赖注入
    @Autowired
    private DormRepairService dormRepairService;

    /**
     * 分页查询
     */
    @RequestMapping(value = "/findDormRepair")
    public String findDormRepair(String d_dormbuilding,Integer pageIndex,
                            Integer d_id ,Integer pageSize, Model model) {
        PageInfo<DormRepair> di = dormRepairService.findPageInfo(d_dormbuilding, d_id,pageIndex,pageSize);
        model.addAttribute("di",di);
        return "dormrepair_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormrepairlist" , method = RequestMethod.POST)
    @ResponseBody
    public List<DormRepair> exportDormRepair(){
        List<DormRepair> dormRepair = dormRepairService.getAll();
        return dormRepair;
    }

    /**
     * 添加维修信息
     */
    @RequestMapping(value = "/addDormRepair" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormRepair( @RequestBody DormRepair dormRepair) {
        /*SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dormRepair.setCreate_time(create3);
        dormRepair.setUpdate_time(update3);*/
        int a = dormRepairService.addDormRepair(dormRepair);
        return "dormrepair_list";
    }

    /**
     * 删除维修信息；将请求体d_id写入参数d_id
     */
    @RequestMapping( "/deleteDormRepair")
    @ResponseBody
    public String deleteDormRepair(Integer r_id) {
        int a = dormRepairService.deleteDormRepair(r_id);
        return "dormrepair_list";
    }

    /**
     * 修改维修信息
     */
    /**
     * 将提交数据(a_id,a_username...)写入DormRepair对象
     */
    @RequestMapping( value = "/updateDormRepair", method = RequestMethod.POST)
    public String updateDormRepair(DormRepair dormRepair) {

        //dormRepair.setA_password(MD5Util.MD5EncodeUtf8(dormRepair.getA_password()));
        int a = dormRepairService.updateDormRepair(dormRepair);
        return "redirect:/findDormRepair";
    }


    /**
     * 根据维修Id搜索;将请求数据d_id写入参数d_id
     */
    @RequestMapping( "/findDormRepairById")
    public String findDormRepairById( Integer r_id,HttpSession session) {
        DormRepair d= dormRepairService.findDormRepairById(r_id);
        session.setAttribute("d",d);
        return "dormrepair_edit";
    }

}
