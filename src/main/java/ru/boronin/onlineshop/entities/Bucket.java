package ru.boronin.onlineshop.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buckets")
public class Bucket {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@OneToOne
    @JoinColumn(name = "user_id")
    private MyUser user;

@OneToMany(cascade = CascadeType.REFRESH,mappedBy = "bucket")
    private List<BucketDetail> bucketDetails=new ArrayList<>();

}


