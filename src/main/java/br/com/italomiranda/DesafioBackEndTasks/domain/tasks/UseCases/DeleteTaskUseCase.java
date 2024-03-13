package br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.Task;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.TasksRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeleteTaskUseCase {
    @Autowired
    private TasksRepository tasksRepository;

    public void deleteTask(UUID id){
        Optional<Task> task = tasksRepository.findById(id);

        if(task.isPresent()){
            tasksRepository.deleteById(id);
        }else{
            throw new EntityNotFoundException();
        }
    }
}
