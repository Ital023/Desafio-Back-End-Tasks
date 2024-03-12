package br.com.italomiranda.DesafioBackEndTasks.domain.tasks;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TasksRepository extends JpaRepository <Task,UUID>{
}
