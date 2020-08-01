package nhom7.thh.meomeonoteserver.controller;

import nhom7.thh.meomeonoteserver.entity.Note;
import nhom7.thh.meomeonoteserver.entity.User;
import nhom7.thh.meomeonoteserver.repository.NoteRepository;
import nhom7.thh.meomeonoteserver.repository.UserRepository;
import nhom7.thh.meomeonoteserver.util.BaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllerImpl {

    @Autowired
    UserRepository userRepository;

    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/log")
    public int log(@RequestBody User u) {
        User user = userRepository.getByUsername(u.getUsername());
        if (user != null) {
            if (BaseUtils.hashingPassword(u.getPassword(), "SHA-256").equals(user.getPassword())) {
                return user.getId();
            } else {
                return -1;
            }
        }
        u.setPassword(BaseUtils.hashingPassword(u.getPassword(), "SHA-256"));
        userRepository.save(u);
        return userRepository.getByUsername(u.getUsername()).getId();
    }

    @GetMapping("/pull")
    public ResponseEntity<List<Note>> pull(@RequestParam(name = "id") int userId) {
        List<Note> notes = noteRepository.findByUserId(userId);
        return new ResponseEntity<List<Note>>(notes, HttpStatus.OK);
    }

    @PostMapping("/push")
    public String push(@RequestBody List<Note> notes) {
        if (notes != null && notes.size() > 0) {
            List<Note> current = noteRepository.findByUserId(notes.get(0).getUserId());
            if (current != null) {
                noteRepository.deleteAll(current);
            }
            int MAX = noteRepository.findAll().size();
            for (Note i : notes) {
                MAX++;
                i.setId(MAX);
                noteRepository.save(i);
            }
            return "ok";
        }
        return "not ok";
    }
}
