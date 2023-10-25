package com.wlb.file.controller;

import com.alibaba.excel.EasyExcel;
import com.wlb.file.pojo.User;
import com.wlb.file.listener.UserDataListener;
import com.wlb.file.service.UserService;
import com.wlb.file.util.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    //在application.yml中配置了用户表的绝对路径，即本项目resources下excel里的用户表,使用时记得修改绝对路径
    @Value("${excel.path}")
    private String path;

    @Autowired
    private UserService userService;

    //返回主页
    @RequestMapping("/toIndex")
    public String toIndex() {
        return "/index";
    }

    //查询数据库user里的所有数据
    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(User user) {
        return userService.getAll();
    }

    //easyexcel获取数据数据导出Excel到指定位置，此处使用本项目resources下excel作为路径
    @GetMapping("/exportFile")
    @ResponseBody
    public String export2File() {
        ExcelUtils.export2File(path, "用户表", "用户信息", User.class, userService.getAll());
        return "导出成功";
    }

    // easyexcel获取数据数据并导出Excel到浏览器下载下来
    @GetMapping("/exportWeb")
    public void export2Web(HttpServletResponse response) {
        try {
            ExcelUtils.export2Web(response, "用户表", "用户信息", User.class, userService.getAll());
        } catch (Exception e) {
            log.error("报表导出异常:", e);
        }
    }

    //将指定路径（此处使用resources下excel作为示例）下指定名称的excel表格导出到浏览器
    //该功能一般情况下用于导出模板，别人下载模板之后按照模板写入数据到excel，然后导入数据库
    @GetMapping("/exportFileWeb/{excelName}")
    @ResponseBody
    public String export2Web4File(HttpServletResponse response, @PathVariable String excelName) {
        try {
            return ExcelUtils.export2Web4File(response, path, excelName);
        } catch (Exception e) {
            log.error("文件导出异常：", e);
        }
        return "文件导出成功";
    }

    //easyexcel读取文件到数据库（适用于已知文件绝对路径与名称，此处使用resources下excel里面的用户表导入作为示例）
    @GetMapping("/readFile")
    @ResponseBody
    public String read4File() {
        String fileName = path + "用户表导入.xlsx";
        EasyExcel.read(fileName, User.class, new UserDataListener(userService)).sheet().doRead();
        return "读取成功";
    }

    //跳转到上传页面，上传页面可上传本机excel，将表格里面的数据存储到数据库
    //格式应当与resources下excel里面的用户表导入格式一致
    @RequestMapping("/toUploadPage")
    public String toUploadPage() {
        return "/upload";
    }

    // easyexcel上传文件
    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), User.class, new UserDataListener(userService)).sheet().doRead();
        return "上传成功";
    }

}
