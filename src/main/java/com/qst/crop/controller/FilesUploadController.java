package com.qst.crop.controller;

import com.qst.crop.common.Result;
import com.qst.crop.common.StatusCode;
import com.qst.crop.exception.FileFormatException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * @author QST
 * @Description 文件上传
 * @Date 2021-08-24
 */
@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/file")
public class FilesUploadController {
    @Value("${application.upload-path}")
    private String fileDirectory;

    //    头像上传
    @ApiOperation(value = "头像上传")
    @PostMapping("/upload/{type}")
    public Result<String> upload(@PathVariable("type") String type,
                                 @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println("请求图片");
        String originalFilename = file.getOriginalFilename();
        String tail = originalFilename.substring(originalFilename.lastIndexOf("."));
//    图片常见的格式有：bmp、jpg、tiff、gif、pcx、tga、exif、fpx、svg、psd、cdr、pcd、dxf、ufo、eps、ai、raw等
        if (!tail.equals(".jpg") & !tail.equals(".gif") & !tail.equals(".png") & !tail.equals(" eg") &
                !tail.equals(".webp") & !tail.equals(".mp4")) {
            throw new FileFormatException("请传入正确格式文件");
        }
//        创建目录
        String header = UUID.randomUUID().toString().replaceAll("-", "");
        String newFileName = header + tail;
        String targetFileLocation = fileDirectory + File.separator + type;
        File file1 = new File(targetFileLocation);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //创建文件
        String targetFileName = targetFileLocation + File.separator + newFileName;
        File targetFile = new File(targetFileName);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        file.transferTo(targetFile);
        return new Result<String>(true, StatusCode.OK, "上传成功", newFileName);
    }
    //    资料上传
    @ApiOperation(value = "资料上传")
    @PostMapping("/uploadInfo/{type}")
    public Result<String> uploadInfo(@PathVariable("type") String type,
                                 @RequestParam("file") MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();
        String tail = originalFilename.substring(originalFilename.lastIndexOf("."));
        if (!tail.equals(".jpg") & !tail.equals(".gif") & !tail.equals(".png") & !tail.equals(" eg") &
                !tail.equals(".webp") & !tail.equals(".mp4")) {
            throw new FileFormatException("请传入正确格式文件");
        }
//        创建目录
        String header = UUID.randomUUID().toString().replaceAll("-", "");
//        Calendar calendar = Calendar.getInstance();
//        Date time = calendar.getTime();
//        String header = time.toString();
        String newFileName = header + tail;
        String targetFileLocation = fileDirectory + File.separator + type;
        File file1 = new File(targetFileLocation);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //创建文件
        String targetFileName = targetFileLocation + File.separator + newFileName;
        File targetFile = new File(targetFileName);
        if (!targetFile.exists()) {
            targetFile.createNewFile();
        }
        file.transferTo(targetFile);
        return new Result<String>(true, StatusCode.OK, "上传成功", newFileName);
    }
}
