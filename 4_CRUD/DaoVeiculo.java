import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoVeiculo {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar(){
        try {
            this.st.close();
            this.conn.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Veiculo v){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO tb_veiculos VALUES("
            + "NULL, '" + v.getMarca() + "', '" + v.getModelo()
            + "', '" + v.getChassi() + "', " + v.getAno() + ");";
            // System.out.println(comando);
            st.executeUpdate(comando);
            resultado = true;
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultado;
    }
    public ArrayList<Veiculo> select(){
        ArrayList<Veiculo> resultado = new ArrayList<>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("select * from tb_veiculos order by modelo;");
            while (rs.next()){
                Veiculo v = new Veiculo();
                v.setAno(rs.getInt("ano"));
                v.setChassi(rs.getString("chassi"));
                v.setMarca(rs.getString("marca"));
                v.setCodigo(rs.getInt("codigo"));
                v.setModelo(rs.getString("modelo"));
                resultado.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }


        return resultado;
    }
    
    public ArrayList<Veiculo> selectById(int codigo){
        ArrayList<Veiculo> resultado = new ArrayList<>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("select * from tb_veiculos where codigo = " + codigo + " order by modelo;");
            while (rs.next()){
                Veiculo v = new Veiculo();
                v.setAno(rs.getInt("ano"));
                v.setChassi(rs.getString("chassi"));
                v.setMarca(rs.getString("marca"));
                v.setCodigo(rs.getInt("codigo"));
                v.setModelo(rs.getString("modelo"));
                resultado.add(v);
            }
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        }
        finally{
            this.desconectar();
        }


        return resultado;
    }

    public int delete(int codigo){
        int resultado = 0;
        try {
            this.conectar();
            String comando = "delete from tb_veiculos where codigo = " + codigo + ";";
            // System.out.println(comando);
            st.executeUpdate(comando);
            resultado = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultado;
    }

    public int Update(Veiculo v){
       int resultado = 0;
        try {
            this.conectar();
            String comando = "update tb_veiculos set ano = " + v.getAno() +
            "modelo = '" + v.getModelo() +
            "' marca = '" + v.getMarca() + 
            "' chassi = '" + v.getChassi() +
            "' where codigo = " + v.getCodigo() + ";";
            // System.out.println(comando);
            st.executeUpdate(comando);
            resultado = st.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        } finally{
            this.desconectar();
        }
        return resultado;
    }
}
