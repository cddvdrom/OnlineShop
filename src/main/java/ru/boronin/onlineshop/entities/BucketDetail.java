package ru.boronin.onlineshop.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bucketDetails")
public class BucketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
   @JoinColumn(name = "bucket_id",referencedColumnName = "id")
    private Bucket bucket;
    @Column(name = "product")
    private Product product;
    @Column(name = "quantity")
    private int quantity;
    @Transient
    private BigDecimal sum;

    public BucketDetail(Product product,int quantity){
        this.product=product;
        this.quantity=quantity;
        this.sum=product.getPrice().multiply(BigDecimal.valueOf(quantity));;
    }
}
