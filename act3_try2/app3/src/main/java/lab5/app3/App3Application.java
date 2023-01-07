package lab5.app3;

import org.springframework.boot.SpringApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Controller
@SpringBootApplication
@JsonIgnoreProperties
public class App3Application {

	public static void main(String[] args) {
		SpringApplication.run(App3Application.class, args);
	}

	@GetMapping("/phonebook")
	public String getBook(Model model){
		model.addAttribute("phonebook", "phonebook");
		return "phonebook";
	}

}
