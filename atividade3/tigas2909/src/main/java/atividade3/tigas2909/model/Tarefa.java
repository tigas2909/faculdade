package atividade3.tigas2909.model;

import java.time.LocalDate;
import java.util.UUID;

public class Tarefa {
    private UUID id;
    private String titulo;
    private String descricao;
    private LocalDate data;

    public Tarefa() {
        this.id = UUID.randomUUID();
        this.data = LocalDate.now();
    }

    public Tarefa(String titulo, String descricao) {
        this(); // reaproveita o construtor vazio
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}