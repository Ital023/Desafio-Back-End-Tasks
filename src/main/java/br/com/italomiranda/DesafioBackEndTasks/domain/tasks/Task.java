package br.com.italomiranda.DesafioBackEndTasks.domain.tasks;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    private String title;
    private String description;
    private Date completed_at;
    @CreationTimestamp
    private Date created_at;
    private Date update_at;


}
