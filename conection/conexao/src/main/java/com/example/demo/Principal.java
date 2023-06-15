package com.example.demo;
import java.sql.*;

public class Principal {
	String nome;

    public static void main(String[] args) {
        
        try {
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
         
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aulajava",
                    "marcosjr",
                    "235777"
                    );

            String sql = "INSERT INTO aluno (nome, curso) VALUES (?, ?)";
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, "Marcos da Silva");
            stmt.setString(2, "Software");
            
            int linhasAfetadas = stmt.executeUpdate();
            
            
            
            String sql2 = "SELECT nome, curso FROM aluno";           
           
            Statement stmt2 = conn.createStatement();            
          
            ResultSet rs = stmt2.executeQuery(sql2);            
           
            while (rs.next()) {
                String nome = rs.getString("nome");
                String curso = rs.getString("curso");
                System.out.println(nome + " - " + curso);
            }
            
            
            if (linhasAfetadas > 0) {
                System.out.println("Insert executado com sucesso!");
            } else {
                System.out.println("Não foi possível executar o insert.");
            }
            
        } catch (SQLException e) {
            
            System.out.println("Erro ao estabelecer a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
