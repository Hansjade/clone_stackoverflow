package seb_39.pre_36.clone_stackoverflow.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seb_39.pre_36.clone_stackoverflow.board.entity.Board;
import seb_39.pre_36.clone_stackoverflow.board.repository.BoardRepository;
import seb_39.pre_36.clone_stackoverflow.exception.BusinessLoginException;
import seb_39.pre_36.clone_stackoverflow.exception.ExceptionCode;



import java.util.Optional;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

@Service
@Transactional
//@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }



    public Board createBoard(Board board) {
        verifyExistsTitle(board.getTitle());

        return boardRepository.save(board);
    }

    public Board updateBoard(Board board) {
        Board findBoard = findVerifiedBoard(board.getContentId());

        Optional.ofNullable(board.getTitle())
                .ifPresent(title -> findBoard.setTitle(title));
        Optional.ofNullable(board.getContent())
                .ifPresent(content -> findBoard.setContent(content));



        return boardRepository.save(findBoard);
    }

    public Board findBoard(long contentId) {

        return findVerifiedBoard(contentId);
    }

    public Page<Board> findBoards(int page, int size) {

        return boardRepository.findAll(PageRequest.of(page, size,
                Sort.by("contentId").descending()));
    }

    public void deleteBoard(long contentId) {
        Board findBoard = findVerifiedBoard(contentId);

        boardRepository.delete(findBoard);
    }

    public Board findVerifiedBoard(long contentId) {
        Optional<Board> optionalBoard =
                boardRepository.findByContentId(contentId);
        Board findBoard =
                optionalBoard.orElseThrow(() ->
                        new BusinessLoginException(ExceptionCode.MEMBER_NOT_FOUND));
        return findBoard;
    }

    private void verifyExistsTitle(String title) {
//        Optional<Board> board = boardRepository.findByTitle(title);
        Optional<Board> board = boardRepository.findByTitle(title);
        if(board.isPresent())
            throw new BusinessLoginException(ExceptionCode.MEMBER_EXISTS);
    }

}
