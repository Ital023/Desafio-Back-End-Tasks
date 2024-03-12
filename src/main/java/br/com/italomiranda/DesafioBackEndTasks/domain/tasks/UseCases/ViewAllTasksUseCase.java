package br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.Task;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewAllTasksUseCase {

    @Autowired
    private TasksRepository tasksRepository;

    public List<Task> viewAllTasks(){
        return tasksRepository.findAll();
    }
}
