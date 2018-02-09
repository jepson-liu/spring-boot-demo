package cn.liuzhiping.intergration.model;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;


@Data
public class ValidatorReqDemo {
    @NotBlank
    private String name;
    @Range(min = 0,max = 200)
    private Integer age;


    @Pattern(regexp="[a-za-z0-9._%+-]+@[a-za-z0-9.-]+\\.[a-za-z]{2,4}",message = "邮件格式错误")
    private String email;


}
