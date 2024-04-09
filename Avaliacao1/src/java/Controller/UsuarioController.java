package Controller;

import DAO.UsuarioDAO;
import Model.Usuario;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Leonardo Fanck
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/UsuarioController", "/cadastrarUsuario", "/login", "/listaUsuarios", "/excluirUsuario", "/editarUsuario", "/alterarUsuario"})
public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getServletPath();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();
        
        if (action.equals("/listaUsuarios")) {

            List<Usuario> lista = usuarioDAO.getListaUsuario();
            
            request.setAttribute("lista", lista);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ListagemUsuarios.jsp");
            dispatcher.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String action = request.getServletPath();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = new Usuario();

        if (action.equals("/cadastrarUsuario")) {

            //nome, senha, dtNascimento, email, cep, estado, cidade, bairro, rua, numero, complemento
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setDtNascimento(request.getParameter("dtNascimento"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setCep(request.getParameter("cep"));
            usuario.setEstado(request.getParameter("estado"));
            usuario.setCidade(request.getParameter("cidade"));
            usuario.setBairro(request.getParameter("bairro"));
            usuario.setRua(request.getParameter("rua"));
            usuario.setNumero(request.getParameter("numero"));
            usuario.setComplemento(request.getParameter("complemento"));
            if (usuarioDAO.salvarUsuario(usuario) == 1) {
                //response.sendRedirect("Index.jsp");
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
                dispatcher.forward(request, response);
            }
        }
        else if (action.equals("/login")){
            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            usuario = usuarioDAO.getUsuarioByEmail(email);
            
            if (usuario != null && usuario.getEmail() != null){
                
                if(usuario.getSenha().equals(senha)){
                    request.setAttribute("usuario", usuario);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
                    dispatcher.forward(request, response);
                }
                else{
                    request.setAttribute("mensagem", "Senha incorreta!");

                    RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                    dispatcher.forward(request, response);
                }
            }
            else{
                request.setAttribute("mensagem", "Email incorreto ou não cadastrado!");

                RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
                dispatcher.forward(request, response);
            }            
        }
        else if (action.equals("/excluirUsuario")) {
            
            usuario = usuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("id")));
            
            if (usuarioDAO.deletarUsuario(usuario) == 1) {
                //response.sendRedirect("cadcontsucesso.jsp");
                
                List<Usuario> lista = usuarioDAO.getListaUsuario();
                
                request.setAttribute("mensagem", "Usuario deletado com sucesso!");
                request.setAttribute("lista", lista);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("ListagemUsuarios.jsp");
                dispatcher.forward(request, response);
            }
        }
        else if(action.equals("/editarUsuario")){
            usuario = usuarioDAO.getUsuarioById(Integer.parseInt(request.getParameter("id")));
            
            request.setAttribute("usuario", usuario);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("EditarUsuario.jsp");
            dispatcher.forward(request, response);
        }
        else if (action.equals("/alterarUsuario")){

            usuario.setId(Integer.parseInt(request.getParameter("id")));
            usuario.setNome(request.getParameter("nome"));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setDtNascimento(request.getParameter("dtNascimento"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setCep(request.getParameter("cep"));
            usuario.setEstado(request.getParameter("estado"));
            usuario.setCidade(request.getParameter("cidade"));
            usuario.setBairro(request.getParameter("bairro"));
            usuario.setRua(request.getParameter("rua"));
            usuario.setNumero(request.getParameter("numero"));
            usuario.setComplemento(request.getParameter("complemento"));
            
            if (usuarioDAO.alterarUsuario(usuario) == 1) {
               
                List<Usuario> lista = usuarioDAO.getListaUsuario();
                
                request.setAttribute("mensagem", "Usuario alterado com sucesso!");
                request.setAttribute("lista", lista);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("ListagemUsuarios.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

}
