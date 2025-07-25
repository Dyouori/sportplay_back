package com.deyunjiaoyu.sportplay.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 *  文件上传接口
 */
@RestController
@RequestMapping("/classes")
public class ClassPicController {

    // 文件上传存储路径
    private static final String filePath = System.getProperty("user.dir") + "/class/";
    /**
     * 文件上传
     */
    @PostMapping("/cover")
    public String upload(MultipartFile file) {
        synchronized (ClassPicController.class) {
            // 获取当前时间戳
            String flag = System.currentTimeMillis() + "";
            // 获取原始文件名（就是你上传的文件本身的名字）
            String fileName = file.getOriginalFilename();
            try {
                // 如果没有file文件夹，会给你在项目根目录下创建一个file文件夹
                if (!FileUtil.isDirectory(filePath)) {

                    FileUtil.mkdir(filePath);
                }
                // 文件存储形式：时间戳-文件名
                FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
                System.out.println(fileName + "--上传成功");
                Thread.sleep(1L);
            } catch (Exception e) {
                System.err.println(fileName + "--文件上传失败");
            }
            return flag;
        }
    }


    /**
     * 获取文件
     */
//    其实前端根本没有用到这个
//    安全性：可以在服务器端进行权限验证，确保只有授权用户才能访问图片。
//    灵活性：可以在服务器端添加额外的逻辑，如日志记录、访问统计、动态处理图片等。
//    避免直接暴露文件系统结构：不直接暴露文件存储路径，增加系统的安全性。
//
    @GetMapping("/{flag}")
    public void avatarPath(@PathVariable String flag, HttpServletResponse response) {
        if (!FileUtil.isDirectory(filePath)) {
            FileUtil.mkdir(filePath);
        }
        OutputStream os;
        List<String> fileNames = FileUtil.listFileNames(filePath);
        String avatar = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");
        try {
            if (StrUtil.isNotEmpty(avatar)) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(avatar, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(filePath + avatar);
                os = response.getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            System.out.println("文件下载失败");
        }
    }

}