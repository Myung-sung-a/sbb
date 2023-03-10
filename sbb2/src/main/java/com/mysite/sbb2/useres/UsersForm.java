package com.mysite.sbb2.useres;

import jakarta.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {
   
   
   
      @NotEmpty(message="이름은 필수 사항입니다.")   
   
      private String name;
      
      @NotEmpty(message="비밀번호는 필수 항목 입니다.")
      private String pass;
      
      @NotEmpty(message="이메일은 필수 항목 입니다.")
      private String email;
      

}
