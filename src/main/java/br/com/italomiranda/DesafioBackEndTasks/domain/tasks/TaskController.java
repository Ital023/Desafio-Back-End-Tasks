package br.com.italomiranda.DesafioBackEndTasks.domain.tasks;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.DTO.TaskDTO;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private CreateTaskUseCase create;
    @Autowired
    private ViewAllTasksUseCase view;
    @Autowired
    private DeleteTaskUseCase delete;
    @Autowired
    private AlterTaskUseCase alter;
    @Autowired
    private CompleteTaskUseCase complete;

    @GetMapping
    public ResponseEntity allTasks(){
        return ResponseEntity.ok().body(view.viewAllTasks());
    }

    @PostMapping
    public ResponseEntity createTask(@RequestBody Task task){
        Task taskSaved = create.createTask(task);
        return ResponseEntity.ok().body(taskSaved);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity alterTask(@PathVariable UUID id,@RequestBody TaskDTO taskDTO){
        alter.AlterarTask(id,taskDTO);
        return ResponseEntity.ok().body("Deu certo");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTask(@PathVariable UUID id){
        delete.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/complete")
    @Transactional
    public ResponseEntity completeTask(@PathVariable UUID id){
        complete.CompleteTask(id);
        return ResponseEntity.ok("Task completada!");
    }

}
