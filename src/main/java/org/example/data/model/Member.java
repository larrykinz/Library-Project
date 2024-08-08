package org.example.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Member {
   @Id
   private String memberId;
   private String name;
   private int age;
   private String gender;

}
