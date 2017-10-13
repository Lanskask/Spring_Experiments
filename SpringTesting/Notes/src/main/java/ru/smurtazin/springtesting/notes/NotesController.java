package ru.smurtazin.springtesting.notes;

import java.util.Collection;

import javax.validation.Valid;

import ru.smurtazin.springtesting.notes.model.Note;
import ru.smurtazin.springtesting.notes.model.NoteRepository;
import ru.smurtazin.springtesting.notes.model.User;
import ru.smurtazin.springtesting.notes.model.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Example: http://localhost:8080/vladson/notes
 */
@RestController
@RequestMapping("{username}/notes")
public class NotesController {
	@Autowired
	NoteRepository noteRepository;
	@Autowired
	UserRepository userRepository;

	@RequestMapping
	Collection<Note> readNotes(@PathVariable String username) {
		return noteRepository.findByUserUsername(username);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void addNote(@PathVariable String username, @Valid @RequestBody Note note){
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));
		note.setUser(user);
		noteRepository.save(note);
	}
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("could not find user '" + username + "'.");
    }
}
