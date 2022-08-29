package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.dto;

import lombok.Getter;

@Getter
public class BoardPatchDto {
    private long contentId;

    private String title;

    private String content;

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }
}
