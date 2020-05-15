/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author root
 */
public class Projeto7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        String servidor = "localhost";
        String base = "universidade";
        String porta = "8889";
        String usuario = "aluno";
        String senha = "123456";
        String sql = "select aluno.nome as aluno, professor.nome as professor, disciplina.nome as disciplina\n" +
                     "from aluno, professor, disciplina, aluno_disciplina\n" +
                     "where aluno.professor=professor.id and aluno_disciplina.aluno=aluno.id and aluno_disciplina.disciplina=disciplina.id;";
    
        
        Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://"+servidor+":"+porta+"/"+base, usuario,senha);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
    
    while (rs.next()) 
       System.out.println(rs.getString("aluno") + "  " + rs.getString("professor") + "  " + rs.getString("disciplina"));
    }
    
}
