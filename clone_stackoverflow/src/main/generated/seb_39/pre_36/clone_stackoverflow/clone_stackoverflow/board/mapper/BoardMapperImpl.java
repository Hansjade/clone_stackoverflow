package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.dto.BoardPatchDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.dto.BoardPostDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.dto.BoardResponseDto;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.entity.Board;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-29T14:29:08+0900",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Azul Systems, Inc.)"
)
@Component
public class BoardMapperImpl implements BoardMapper {

    @Override
    public Board boardPostDtoToBoard(BoardPostDto boardPostDto) {
        if ( boardPostDto == null ) {
            return null;
        }

        Board board = new Board();

        board.setTitle( boardPostDto.getTitle() );
        board.setContent( boardPostDto.getContent() );

        return board;
    }

    @Override
    public Board boardPatchDtoToBoard(BoardPatchDto boardPatchDto) {
        if ( boardPatchDto == null ) {
            return null;
        }

        Board board = new Board();

        board.setContentId( boardPatchDto.getContentId() );
        board.setTitle( boardPatchDto.getTitle() );
        board.setContent( boardPatchDto.getContent() );

        return board;
    }

    @Override
    public BoardResponseDto boardToBoardResponseDto(Board board) {
        if ( board == null ) {
            return null;
        }

        BoardResponseDto.BoardResponseDtoBuilder boardResponseDto = BoardResponseDto.builder();

        if ( board.getContentId() != null ) {
            boardResponseDto.contentId( board.getContentId() );
        }
        boardResponseDto.title( board.getTitle() );
        boardResponseDto.content( board.getContent() );

        return boardResponseDto.build();
    }

    @Override
    public List<BoardResponseDto> boardsToboardResponseDtos(List<Board> boards) {
        if ( boards == null ) {
            return null;
        }

        List<BoardResponseDto> list = new ArrayList<BoardResponseDto>( boards.size() );
        for ( Board board : boards ) {
            list.add( boardToBoardResponseDto( board ) );
        }

        return list;
    }
}
