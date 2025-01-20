package com.letelumiere.board.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "board")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @Column(name = "no")
    private int no;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @Column(name = "content")
    private String content;

    @Column(name = "regDate")
    @CreationTimestamp
    private Date regDate;

    @Column(name = "updDate")
  	@UpdateTimestamp
    private Date updDate;
}
