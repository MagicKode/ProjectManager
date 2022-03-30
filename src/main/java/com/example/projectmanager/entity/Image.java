package com.example.projectmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long imgId;
    @Column(name = "name")
    private String imgName;
    @Column(name = "originalFileName")
    private String imgOriginalFileName;
    @Column(name = "size")
    private Long imgSize;
    @Column(name = "contentType")
    private String imgContentType;
    @Column(name = "isPreviewImage")
    private boolean imgIsPreviewImage;
    @Lob
    private byte[] bytes;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER) // сразу подгружаем товар, при просмотре фото
    private Product product;
}
