package com.example.librarymgmt.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;
    @Pattern(regexp = "^DA-\\d{4}$", message = "Mã dự án không đúng định dạng")
    private String projectCode;
    @NotEmpty(message = "Tên dự án không thể trống")
    private String projectName;
    @Min(value = 30000000,message = "Kinh phí không thể dưới 30 triệu")
    private int projectCost;
    @Column(name = "project_desc", length = 2000)
    @NotEmpty
    private String projectDesc;
    private Date announDate;
    @Min(value = 2,message = "Thời gian đăng ký không bé hơn 2 tháng")
    @Max(value = 12,message = "Thời gian đăng ký không lâu hơn 12 tháng")
    private int announMonth;
    private int fee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    public void setFee(){
    	this.fee = projectCost<100000000?projectCost*0.01*announMonth:projectCost<=500000000?projectCost*0.02*announMonth:projectCost*0.03*announMonth;


        if(projectCost<100000000){
            this.fee = (int) (projectCost*0.01*announMonth);
        } else if (projectCost<=500000000){
            this.fee = (int) (projectCost*0.02*announMonth);
        } else {
            this.fee = (int) (projectCost*0.03*announMonth);
        }
    }
}
