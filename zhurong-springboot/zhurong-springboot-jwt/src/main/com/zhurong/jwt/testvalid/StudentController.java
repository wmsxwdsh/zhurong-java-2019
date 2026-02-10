package com.zhurong.jwt.testvalid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date 2022.04.14
 */
@RestController
public class StudentController {


    @GetMapping("/add")
    public String add(@Validated(value = Student.UpdateGroup.class) Student student, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
//            return bindingResult.getAllErrors().get(0).getDefaultMessage();
            StringBuffer errorResult = new StringBuffer();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorResult.append(error.getObjectName() + " : " + error.getDefaultMessage() + "\n");
            }
            return errorResult.toString();
        }
        return "添加成功";
    }

}
