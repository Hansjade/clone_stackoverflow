package seb_39.pre_36.clone_stackoverflow.board.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

//    public Board(long contentId) {
//        this.contentId = contentId;
//    }
//
//    public Board(long contentId, String title, String content) {
//        this.contentId = contentId;
//        this.title = title;
//        this.content = content;
//    }
}
