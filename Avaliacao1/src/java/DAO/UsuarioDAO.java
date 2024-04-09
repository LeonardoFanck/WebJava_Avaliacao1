
package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo Fanck
 */
public class UsuarioDAO {
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            //ALTERAR O CAMINHO DO ARQUIVO TEST.DB F:\Leonardo da Silva Fanck\UNIVATES\Desenvolvimento de Aplicações para Intenet\Avaliação 1
            con = DriverManager.getConnection("jdbc:sqlite:F:\\Leonardo da Silva Fanck\\UNIVATES\\Desenvolvimento de Aplicações para Intenet\\Avaliação 1\\dbLeonardoFanck.db");
      
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return con;
    }
    
    public int salvarUsuario(Usuario usuario) {
        int status = 0;
        
        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();
            String query = "INSERT INTO Usuario (nome, dataNasc, senha, email, CEP, estado, cidade, bairro, rua, numero, complemento) "
                                    + "VALUES ('" + usuario.getNome() + "','" + usuario.getDtNascimento()+ "','" + usuario.getSenha()
                                    + "','" + usuario.getEmail() + "','" + usuario.getCep() + "','" + usuario.getEstado() 
                                    + "','" + usuario.getCidade() + "','" + usuario.getBairro() + "','" + usuario.getRua() 
                                    + "'," + usuario.getNumero() + ",'" + usuario.getComplemento() + "')";
            System.out.println("Query -> " + query);
            status = ps.executeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return status;
    }

    public int alterarUsuario(Usuario usuario) {
        int status = 0;
        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();
            
            String query = "UPDATE Usuario "
                        + "SET nome = '" + usuario.getNome() + "', dataNasc = '" + usuario.getDtNascimento() + "', senha = '" + usuario.getSenha() 
                        + "', email = '" + usuario.getEmail() + "', CEP = '" + usuario.getCep() + "', estado = '" + usuario.getEstado() 
                        + "', cidade = '" + usuario.getCidade() + "', bairro = '" + usuario.getBairro() + "', rua = '" + usuario.getRua() 
                        + "', numero = " + usuario.getNumero() + ", complemento = '" + usuario.getComplemento() + "' "
                        + "WHERE id = " + usuario.getId() + ";";
            
            status = ps.executeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return status;
    }

    public int deletarUsuario(Usuario usuario) {
        int status = 0;
        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();
            status= ps.executeUpdate("DELETE FROM Usuario WHERE id = " + usuario.getId());
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("STATUS  " + status);
        
        return status;
    }

    public List<Usuario> getListaUsuario() {
        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Usuario");

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                
                String data = rs.getString("dataNasc").replaceAll("-", "/"); 
                String[] s = data.split("/"); 
                String novaData = s[2]+"/"+s[1]+"/"+s[0];

                usuario.setDtNascimento(novaData);
                usuario.setCep(rs.getString("CEP"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setRua(rs.getString("rua"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setComplemento(rs.getString("complemento"));
                
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return listaUsuario;
    }

    public Usuario getUsuarioById(int id) {
        Usuario usuario = null;
        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Usuario WHERE id = " + id);
            
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                
                //String data = rs.getString("dataNasc").replaceAll("-", "/"); 
                //String[] s = data.split("/"); 
                //String novaData = s[2]+"/"+s[1]+"/"+s[0];

                //usuario.setDtNascimento(novaData);
                String data = rs.getString("dataNasc");
                usuario.setDtNascimento(data);
                usuario.setCep(rs.getString("CEP"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setRua(rs.getString("rua"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setComplemento(rs.getString("complemento"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }
    
    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = null;
        try {
            Connection con = getConnection();
            Statement ps = con.createStatement();

            ResultSet rs = ps.executeQuery("SELECT * FROM Usuario WHERE email = '" + email + "'");
            
            while (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                String data = rs.getString("dataNasc").replaceAll("-", "/"); 
                String[] s = data.split("/"); 
                String novaData = s[2]+"/"+s[1]+"/"+s[0];

                usuario.setDtNascimento(novaData);
                usuario.setCep(rs.getString("CEP"));
                usuario.setEstado(rs.getString("estado"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setBairro(rs.getString("bairro"));
                usuario.setRua(rs.getString("rua"));
                usuario.setNumero(rs.getString("numero"));
                usuario.setComplemento(rs.getString("complemento"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return usuario;
    }
}
