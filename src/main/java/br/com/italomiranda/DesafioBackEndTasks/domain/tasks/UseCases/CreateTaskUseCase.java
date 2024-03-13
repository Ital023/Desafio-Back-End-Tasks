package br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.Task;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {

    @Autowired
    private TasksRepository tasksRepository;

    public Task createTask(Task task){
        if(task.getTitle() != null && task.getDescription() != null){
            tasksRepository.save(task);
            return task;
        }else{
            throw new NullPointerException();
        }
    }


}
