package nhom7.thh.meomeonoteserver.repository;


import nhom7.thh.meomeonoteserver.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, String> {

    List<Note> findByUserId(int userId);
}
