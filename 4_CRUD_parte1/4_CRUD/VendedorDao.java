
    import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VendedorDao {
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

    public boolean inserir(Vendedor v){
        boolean resultado = false;
        try {
            this.conectar();
            String comando = "INSERT INTO vendedor VALUES("
            + "NULL, '" + v.getNome() + "', '" + v.getEmail()
            + "', '" + v.getVendas() + "',  '" + v.getStatus()+ "');";
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
    public ArrayList<Vendedor> select(){
        ArrayList<Vendedor> resultado = new ArrayList<>();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("select * from vendedor order by codigo;");
            while (rs.next()){
                Vendedor v = new Vendedor();
                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setVendas(rs.getInt("vendas"));
                v.setEmail(rs.getString("email"));
                v.setStatus(VendedorEnum.fromValor(rs.getString("Estatus")));
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
    
    public Vendedor selectById(int codigo){
        Vendedor resultado = null;

        try {
            this.conectar();

            ResultSet rs = st.executeQuery(
                "select * from vendedor where codigo = " + codigo
            );

            if (rs.next()){
                resultado = new Vendedor();
                resultado.setCodigo(rs.getInt("codigo"));;
                resultado.setNome(rs.getString("nome"));;
                resultado.setEmail(rs.getString("email"));;
                resultado.setVendas(rs.getInt("vendas"));;
                resultado.setStatus(VendedorEnum.fromValor(rs.getString("Estatus")));
            }

            
        } catch (Exception e) {
            System.out.println("Erro ao buscar registro: " + e.getMessage());
        } finally {
            this.desconectar();
        }

            return resultado;
    }

    public int delete(int codigo){
        int resultado = 0;
        try {
            this.conectar();
            String comando = "delete from vendedor where codigo = " + codigo + ";";
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

    public int Update(Vendedor v){
       int resultado = 0;
        try {
            this.conectar();
            String comando = "UPDATE vendedor SET " +
            "ano = " + v.getNome() + ", " +
            "modelo = '" + v.getEmail() + "', " +
            "marca = " + v.getVendas()+ ", " +
            "chassi = '" + v.getStatus().getValor() + "' " +
            "WHERE codigo = " + v.getCodigo() + ";";
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


