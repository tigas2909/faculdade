package atividade3.tigas2909.controllers;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import atividade3.tigas2909.model.Tarefa;


@Controller
@RequestMapping("/tarefas")
public class TarefasControllers {
    private ArrayList<Tarefa> tarefas;
    
    public TarefasControllers() {
        this.tarefas = new ArrayList<>();
    }


    @GetMapping("/")
    public String listarTarefas(Model model) {
        model.addAttribute("tarefas", tarefas);

        return "view/Tarefa";
    }

    @GetMapping("/adicionar1")
    public String mostrarFormulario(Model model) {
        model.addAttribute("modo", "Adicionar Tarefa");
        return "view/form";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicao(@PathVariable UUID id, Model model) {
        model.addAttribute("modo", "Editar Tarefa");
        for(Tarefa t: tarefas) {
            if(t.getId().equals(id)) {
                model.addAttribute("tarefa", t);
                break;
            }
        }
        return "view/form";
    }

    @PostMapping("/adicionar")
    public String adicionarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
        return "redirect:/tarefas/";
    }

    @PostMapping("/editar")
    public String editarTarefa(Tarefa tarefa) {
        for(int i = 0; i < tarefas.size(); i++) {
            if(tarefas.get(i).getId().equals(tarefa.getId())) {
                tarefas.set(i, tarefa);
                break;
            }
        }
        return "redirect:/tarefas/";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable UUID id) {
        tarefas.removeIf(t -> t.getId().equals(id));
        return "redirect:/tarefas/";
    }

}
