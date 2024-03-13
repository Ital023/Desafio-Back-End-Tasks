package br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.Task;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CompleteTaskUseCase {

    @Autowired
    private TasksRepository tasksRepository;

    public void CompleteTask(UUID id){
        Optional<Task> taskToComplete = tasksRepository.findById(id);

        if(taskToComplete.isPresent()){
            Task taskCompleted = taskToComplete.get();

            Date dateNow = new Date();

            taskCompleted.setCompleted_at(dateNow);
        }else{
            throw new EntityNotFoundException();
        }
    }
}
