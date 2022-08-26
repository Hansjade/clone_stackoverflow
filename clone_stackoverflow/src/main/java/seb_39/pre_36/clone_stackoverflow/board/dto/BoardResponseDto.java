package seb_39.pre_36.clone_stackoverflow.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {
    private long contentId;
    private String title;
    private String content;
}
