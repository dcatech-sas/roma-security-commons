package com.dcatech.security.commons.models.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String label;
    private String description;
    private String details;
    private String routerLink;
    private String iconType;
    private String iconName;
    private String toggle;
    private String menuItemBasedOnId;
    private Boolean visible;
    private Integer orden;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "submenus"})
    @ManyToOne
    @JoinColumn(name="parent_menu_id")
    private Menu parentMenu;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "parentMenu"})
    @OneToMany(mappedBy="parentMenu", fetch = FetchType.LAZY)
    private List<Menu> submenu;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "menuId"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "menuId")
    //@JoinColumn
    private List<MenuRole> menuRoles;



}