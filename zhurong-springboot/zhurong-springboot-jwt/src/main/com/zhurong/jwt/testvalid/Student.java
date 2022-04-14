package com.zhurong.jwt.testvalid;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author LZG
 * @date 2022.04.14
 */
//@AtLeastOneNotNull(fieldNames = {"password", "verificationCode"}, message = "password，verificationCode不能都为空")
public class Student {

    /**
     * 分组校验 总结：
     * （1）group = { group1, group2}
     * （2）controller里验证方法时，@Validated(value = Student.UpdateGroup.class)，只有（1）为updateGroup的属性才校验
     *
     * 默认（适用于绝大多数情况）
     * 只在id属性的group上updateGroup
     * controller只用最简单的@Validated就行。
     */

    /**
     * id
     *
     */
    @NotNull(message = "Valid校验：更新id不能为空！", groups = {UpdateGroup.class})
    private String id;

    /**
     * 学生姓名
     */
    @NotNull(message = "Valid校验：请输入学生姓名！")
    @Length(message = "名称不能超过个 {max} 字符", max = 10)
    private String name;

    /**
     * 学生年龄
     */
    @NotNull(message = "Valid校验：请输入学生年龄！")
    @Range(message = "年龄范围为 {min} 到 {max} 之间", min = 1, max = 100)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //修改的分组
    public interface UpdateGroup {
    }

    //添加的分组
    public interface AddGroup {
    }


}
