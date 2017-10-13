package ru.smurtazin.springtesting.notes;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.smurtazin.springtesting.notes.model.Note;
import ru.smurtazin.springtesting.notes.model.NoteRepository;
import ru.smurtazin.springtesting.notes.model.User;
import ru.smurtazin.springtesting.notes.model.UserRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class App {
    @Bean
    CommandLineRunner init(UserRepository userRepository, NoteRepository noteRepository) {
    	return (evt) -> {
	    	User user = new User();
	    	user.setUsername("vladson");
	    	user.setPassword("111");
	    	userRepository.save(user);
	    	Note note = new Note();
	    	note.setUser(user);
	    	note.setText("test note");
	    	noteRepository.save(note);
	    	
	    	user = new User();
	    	user.setUsername("vvv");
	    	user.setPassword("222");
	    	userRepository.save(user);
	    	note = new Note();
	    	note.setUser(user);
	    	note.setText("vvv note");
	    	noteRepository.save(note);
    	};
    }

    public static void main(String[] args) {
	    SpringApplication.run(App.class, args);
    }
}
