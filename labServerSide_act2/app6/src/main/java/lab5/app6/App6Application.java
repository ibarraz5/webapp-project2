package lab5.app6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@Controller
public class App6Application {

	public static void main(String[] args) {
		SpringApplication.run(App6Application.class, args);
	}

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	//http://localhost:8080/greeting?name=User

	@GetMapping("/booktown/list")
	public String getList(Model model){
		model.addAttribute("list", "list");
		return "list";
	}

	@GetMapping("/booktown/add")
	public String addAuthor(Model author){
		author.addAttribute("author", "author");
		return "list";
	}

	//http://localhost:8080/booktown/delete?id=1
	@GetMapping("/booktown/delete")
	public String delete(@RequestParam(name="id", required=false) String id, Model model) {
		model.addAttribute("id", id);
		return "list";
	}

}

