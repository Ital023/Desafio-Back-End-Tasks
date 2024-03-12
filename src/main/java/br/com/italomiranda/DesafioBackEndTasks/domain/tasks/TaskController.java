package br.com.italomiranda.DesafioBackEndTasks.domain.tasks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping
    public String allTasks(){
        return "Teste";
    }
}
