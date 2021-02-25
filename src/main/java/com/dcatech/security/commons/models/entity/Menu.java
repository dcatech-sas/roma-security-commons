package com.dcatech.security.commons.models.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menus")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu implements Serializable {


    private static final long serialVersionUID = 390430886782969189L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String description;
    private String icon;
    private Boolean status;
    private Integer orden;
    private String url;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonBackReference
    private Menu parentMenu;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuId")
    private List<MenuRole> menuRoles;

}