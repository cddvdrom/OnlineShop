package ru.boronin.onlineshop.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import ru.boronin.onlineshop.enums.Roles;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class MyUser{

@Id
@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

@Column(name = "name")
private String name;
    @Column(name = "password",length = 2000)
private String password;
    @Column(name = "email",unique = true)
private String email;
    @Column(name = "phonenumber")
private String phonenumber;
    @Column(name = "active")
private boolean active;
    @Column(name = "role")
@Enumerated(EnumType.STRING)
    private Roles role;
   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bucket_id")
   private Bucket bucket;

@OneToMany(mappedBy = "user")
private List<Order> orderList;

}
