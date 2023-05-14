package ru.boronin.onlineshop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originFileName")
    private String originFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "conentType")
    private String contentType;
    @Column(name = "isPreview")
    private boolean isPreview;
    @Lob
    private byte[] imageBytes;
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
private Product product;
}
