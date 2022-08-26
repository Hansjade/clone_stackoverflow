package seb_39.pre_36.clone_stackoverflow.board.mapper;

import org.mapstruct.Mapper;
import seb_39.pre_36.clone_stackoverflow.board.entity.Board;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardPatchDto;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardPostDto;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardResponseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board boardPostDtoToBoard(BoardPostDto boardPostDto);

    Board boardPatchDtoToBoard(BoardPatchDto boardPatchDto);

    BoardResponseDto boardToBoardResponseDto(Board board);

    List<BoardResponseDto> boardsToboardResponseDtos(List<Board> boards);
}
