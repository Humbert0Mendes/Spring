package humberto.io.projeto1.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import humberto.io.projeto1.entity.User;
import humberto.io.projeto1.repository.UserRepository;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
			
		List<User> users = userRepository.findAll();
		
		if(users.isEmpty()) {
			
			createUser("Beto", "Beto@gmail.com");
			createUser("Neto", "Neto@gmail.com");
			createUser("Mendes", "Mendes@gmail.com");
		}
		
		User user = userRepository.findByEmailQualquerCoisa("Beto@gmail.com");
		//User user = userRepository.findByNameIgnoreCaseLike("bet");
		
		System.out.println(user.getEmail());
		
	}
	
	public void createUser(String name, String email) {
		
		User user = new User(name, email);
		
		userRepository.save(user);
	}
	

}
