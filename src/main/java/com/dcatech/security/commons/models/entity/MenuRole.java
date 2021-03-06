package com.dcatech.security.commons.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "menus_roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuRole implements Serializable {


    private static final long serialVersionUID = -4096052863066961347L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Menu.class )
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menuId;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role roleId;

    private Boolean optSelect;
    private Boolean optCreate;
    private Boolean optUpdate;
    private Boolean optDelete;

}
