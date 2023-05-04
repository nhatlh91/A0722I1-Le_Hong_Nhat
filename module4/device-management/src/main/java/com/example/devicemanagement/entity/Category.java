package com.example.devicemanagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @NotEmpty
    @Column(name = "category_name", length = 500)
    private String categoryName;
    @Column(name = "category_desc", length = 2000)
    private String categoryDesc;
    @JsonBackReference
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    private Set<Device> devices = new LinkedHashSet<>();

}
