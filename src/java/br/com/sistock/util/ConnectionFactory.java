/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistock.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author guilh
 */
public class ConnectionFactory {

    public static Connection conectar() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("Conectou");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/venturini1563_filial?serverTimezone=UTC", "venturini1563_admin", "@Mar#Keting19");
            //return DriverManager.getConnection("jdbc:mysql://localhost:3306/saboraki?serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new Exception("Erro ao conectar no banco: " + e.getMessage());
        }
    }

    public static void fecharConexao(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new Exception("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
