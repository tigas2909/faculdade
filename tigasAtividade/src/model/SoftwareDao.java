package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SoftwareDao {

    private Connection conn;
    private Statement st;

    private void conectar() {
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar() {
        try {
            this.st.close();
            this.conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Software s) {
        boolean resultado = false;

        try {
            this.conectar();

            String comando =
                "INSERT INTO softwares " +
                "(nome, versao, desenvolvedor, sistema_operacional, licenca, descricao, id_categoria) " +
                "VALUES (" +
                "'" + s.getNome() + "', '" +
                s.getVersao() + "', '" +
                s.getDesenvolvedor() + "', '" +
                s.getSistemaOperacional() + "', '" +
                s.getLicenca() + "', '" +
                s.getDescricao() + "', " +
                s.getCategoria() +
                ");";
            st.executeUpdate(comando);
            resultado = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }

    public ArrayList<Software> buscarTodos() {

        ArrayList<Software> resultados = new ArrayList<>();

        try {
            this.conectar();

            ResultSet rs = st.executeQuery(
                "SELECT softwares.*, categorias.nome AS nome_categoria " +
                "FROM softwares " +
                "INNER JOIN categorias ON softwares.id_categoria = categorias.id_categoria " +
                "ORDER BY softwares.nome"
            );

            while (rs.next()) {

                Software s = new Software();

                s.setIdSoftware(rs.getInt("id_software"));
                s.setNome(rs.getString("nome"));
                s.setVersao(rs.getString("versao"));
                s.setDesenvolvedor(rs.getString("desenvolvedor"));
                s.setSistemaOperacional(rs.getString("sistema_operacional"));
                s.setLicenca(Licenca.fromString(rs.getString("licenca")));
                s.setDescricao(rs.getString("descricao"));
                s.setCategoria(rs.getString("categoria"));

                resultados.add(s);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultados;
    }

    public Software consultar(int id) {

        Software s = null;

        try {
            this.conectar();

            ResultSet rs = st.executeQuery(
                "SELECT softwares.*, categorias.nome AS nome_categoria " +
                "FROM softwares " +
                "INNER JOIN categorias ON softwares.id_categoria = categorias.id_categoria " +
                "WHERE softwares.id_software = " + id
            );

            if (rs.next()) {

                s = new Software();

                s.setIdSoftware(rs.getInt("id_software"));
                s.setNome(rs.getString("nome"));
                s.setVersao(rs.getString("versao"));
                s.setDesenvolvedor(rs.getString("desenvolvedor"));
                s.setSistemaOperacional(rs.getString("sistema_operacional"));
                s.setLicenca(Licenca.fromString(rs.getString("licenca")));
                s.setDescricao(rs.getString("descricao"));
                s.setCategoria(rs.getString("categoria"));
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return s;
    }

    public int excluir(int id) {

        int qtde = 0;

        try {
            this.conectar();

            String comando =
                    "DELETE FROM softwares WHERE id_software = " + id + ";";

            st.executeUpdate(comando);

            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return qtde;
    }

    public int alterar(Software s) {

        int qtde = 0;

        try {
            this.conectar();

            String comando =
                    "UPDATE softwares SET " +
                    "nome = '" + s.getNome() + "', " +
                    "versao = '" + s.getVersao() + "', " +
                    "desenvolvedor = '" + s.getDesenvolvedor() + "', " +
                    "sistema_operacional = '" + s.getSistemaOperacional() + "', " +
                    "licenca = '" + s.getLicenca() + "', " +
                    "descricao = '" + s.getDescricao() + "', " +
                    "id_categoria = " + s.getCategoria() +
                    " WHERE id_software = " + s.getIdSoftware() + ";";

            st.executeUpdate(comando);

            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro ao atualizar registro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return qtde;
    }
}