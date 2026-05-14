/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Software;
import model.SoftwareDao;



/**
 *
 * @author aluno.lab
 */
public class softwareTableModel extends AbstractTableModel {
    public static final int COL_ID = 0;
    public static final int COL_NOME = 1;
    public static final int COL_DEV = 2;
    public static final int COL_DESCRI = 3;
    public static final int COL_CATEGORIA = 4;
    public static final int COL_LICENCA = 5;
    public static final int COL_VERSAO = 6;
    public static final int COL_SIS = 7;
    
    SoftwareDao dao = new SoftwareDao();
    public ArrayList<Software> listaSoftware;
    
    public softwareTableModel(ArrayList<Software> soft){
        listaSoftware = soft;
    }
    
     @Override
    public int getColumnCount(){
        return 8;
    }
    
    @Override
    public int getRowCount(){
        return listaSoftware.size();
    }
    
    @Override
    public String getColumnName(int coluna){
        String nome = "";
        if(coluna == COL_ID){nome = "ID";}
        if(coluna == COL_NOME){nome = "Nome";}
        if(coluna == COL_DEV){nome = "desenvolvedor";}
        if(coluna == COL_DESCRI){nome = "Descrição";}
        if(coluna == COL_CATEGORIA){nome = "Categoria";}
        if(coluna == COL_LICENCA){nome = "Licença";}
        if(coluna == COL_VERSAO){nome = "Versão";}
        if(coluna == COL_SIS){nome = "Sistema operacional";}
        return nome;
    }
    
    @Override
    public Object getValueAt(int linha, int coluna){
        Software v = listaSoftware.get(linha);
        Object conteudo = "";
        if(coluna ==COL_ID){conteudo = v.getIdSoftware();}
        if(coluna == COL_NOME){conteudo = v.getNome();}
        if(coluna == COL_DEV){conteudo = v.getDesenvolvedor();}
        if(coluna == COL_DESCRI){conteudo = v.getDescricao();}
        if(coluna == COL_CATEGORIA){conteudo = v.getCategoria();} 
        if(coluna == COL_LICENCA) {conteudo = v.getLicenca();}
        if(coluna == COL_VERSAO){conteudo = v.getVersao();}
        if(coluna == COL_SIS){conteudo = v.getSistemaOperacional();}
        return conteudo;
    }
    
    
}
