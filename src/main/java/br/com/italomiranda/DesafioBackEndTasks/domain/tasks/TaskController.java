package br.com.italomiranda.DesafioBackEndTasks.domain.tasks;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases.CreateTaskUseCase;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases.DeleteTaskUseCase;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases.ViewAllTasksUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private CreateTaskUseCase create;
    @Autowired
    private ViewAllTasksUseCase view;
    @Autowired
    private DeleteTaskUseCase delete;

    @GetMapping
    public ResponseEntity allTasks(){
        return ResponseEntity.ok().body(view.viewAllTasks());
    }

    @PostMapping
    public ResponseEntity createTask(@RequestBody Task task){
        Task taskSaved = create.createTask(task);
        return ResponseEntity.ok().body(taskSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable UUID id){
        delete.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}
