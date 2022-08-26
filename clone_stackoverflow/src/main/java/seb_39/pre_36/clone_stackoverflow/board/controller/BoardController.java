package seb_39.pre_36.clone_stackoverflow.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seb_39.pre_36.clone_stackoverflow.board.entity.Board;
import seb_39.pre_36.clone_stackoverflow.board.mapper.BoardMapper;
import seb_39.pre_36.clone_stackoverflow.board.service.BoardService;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardPatchDto;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardPostDto;
import seb_39.pre_36.clone_stackoverflow.board.dto.BoardResponseDto;
import seb_39.pre_36.clone_stackoverflow.dto.MultiResponseDto;
import seb_39.pre_36.clone_stackoverflow.dto.SingleResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final BoardMapper mapper;

    public BoardController(BoardService boardService, BoardMapper mapper) {
        this.boardService = boardService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity boardPost(@RequestBody BoardPostDto boardDto) {
        Board board = boardService.createBoard(mapper.boardPostDtoToBoard(boardDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.CREATED);
    }

    @PatchMapping("/{content-id}")
    public ResponseEntity boardPatch(@PathVariable("content-id") long contentId,
                                     @RequestBody BoardPatchDto boardPatchDto) {
        boardPatchDto.setContentId(contentId);
// memberId와 비교해서 같으면 가능 틀리면 에러(권한이 없습니다.or 글쓴이가 아닙니다.)
        Board board =  boardService.updateBoard(mapper.boardPatchDtoToBoard(boardPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.OK);
    }

    @GetMapping("/{content-id}")
    public ResponseEntity getContent(@PathVariable("content-id") long contentId){

        Board board = boardService.findBoard(contentId);
        return new ResponseEntity<>(
                new SingleResponseDto<>(mapper.boardToBoardResponseDto(board)),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getContents(@RequestParam int page,
                                      @RequestParam int size) {
        Page<Board> pageBoards = boardService.findBoards(page - 1, size);
        List<Board> boards = pageBoards.getContent();
//
//        List<BoardResponseDto> response =
//                boards.stream()
//                        .map(board -> mapper.boardToBoardResponseDto(board))
//                        .collect(Collectors.toList());

        return new ResponseEntity<>(
                new MultiResponseDto<>(mapper.boardsToboardResponseDtos(boards),pageBoards),
                HttpStatus.OK);
    }

    @DeleteMapping("/{content-id}")
    public ResponseEntity deleteContent(@PathVariable("content-id") long contentId) {

        boardService.deleteBoard(contentId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
