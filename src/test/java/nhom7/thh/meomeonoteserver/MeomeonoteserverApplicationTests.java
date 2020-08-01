package nhom7.thh.meomeonoteserver;

import nhom7.thh.meomeonoteserver.entity.Note;
import nhom7.thh.meomeonoteserver.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MeomeonoteserverApplicationTests {

    @Autowired
    NoteRepository noteRepository;

    @Test
    void contextLoads() {
        Note note = new Note();
        note.setTitle("abc");
        note.setContent("xyz");
        noteRepository.save(note);
    }

}
