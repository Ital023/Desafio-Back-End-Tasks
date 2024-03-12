package br.com.italomiranda.DesafioBackEndTasks.domain.tasks.UseCases;

import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.DTO.TaskDTO;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.Task;
import br.com.italomiranda.DesafioBackEndTasks.domain.tasks.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AlterTaskUseCase {

    @Autowired
    private TasksRepository tasksRepository;

    public void AlterarTask(UUID id, TaskDTO taskDTO){
        Optional<Task> taskExist = tasksRepository.findById(id);

        if(taskExist.isPresent()){
            Task taskOriginal = taskExist.get();
            Date dateNow = new Date();

            if(taskDTO.title() != null && taskDTO.description() != null){
                taskOriginal.setTitle(taskDTO.title());
                taskOriginal.setDescription(taskDTO.description());
                taskOriginal.setUpdated_at(dateNow);

            }else if(taskDTO.title() == null){
                taskOriginal.setDescription(taskDTO.description());
                taskOriginal.setUpdated_at(dateNow);
            }else{

                taskOriginal.setTitle(taskDTO.title());
                taskOriginal.setUpdated_at(dateNow);
            }
        }

    }
}
