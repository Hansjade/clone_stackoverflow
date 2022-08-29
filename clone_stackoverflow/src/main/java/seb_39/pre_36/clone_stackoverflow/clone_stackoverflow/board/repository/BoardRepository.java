package seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seb_39.pre_36.clone_stackoverflow.clone_stackoverflow.board.entity.Board;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findByContentId(Long contentId);

    Optional<Board> findByTitle(String title);

}
