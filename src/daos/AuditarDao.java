/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Auditar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import util.HibernateUtil;

/**
 *
 * @author Ramon
 */
public class AuditarDao extends Dao {

    public static Auditar auditar() {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Auditar a = (Auditar) sessao.get(Auditar.class, 1);
            return a;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static boolean arquivar(Timestamp inicio, Timestamp fim) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            sessao.doWork(new Work() {
                public void execute(Connection connection) throws SQLException {
                    CallableStatement callTabelas = connection.prepareCall("SELECT tablename from pg_tables where tablename like '%_aud'");
                    callTabelas.execute();
                    ResultSet rTabelas = callTabelas.executeQuery();
                    while (rTabelas.next()) {
                        CallableStatement callArquivar = connection.prepareCall("SELECT * from auditoria a, " + rTabelas.getString(1) + " aud WHERE a.id = aud.rev AND a.timestamp BETWEEN "
                                + inicio.getTime() + " AND " + fim.getTime());
                        callArquivar.execute();
                        ResultSet rArquivar = callArquivar.executeQuery();
                        int colunas = rArquivar.getMetaData().getColumnCount();
                        while (rArquivar.next()) {
                            String arquivar = "";
                            for (int i = 1; i <= colunas; i++) {
                                if (i != 5) {
                                    arquivar = arquivar + rArquivar.getString(i) + "; ";
                                }
                            }
                            CallableStatement callInsertArquivo = connection.prepareCall("INSERT INTO arquivo_auditoria VALUES(default, '" + arquivar + "', '" + rTabelas.getString(1) + "')");
                            callInsertArquivo.execute();
                            CallableStatement callExcluiArquivo = connection.prepareCall("DELETE FROM " + rTabelas.getString(1) + " WHERE rev = " + rArquivar.getString(1));
                            callExcluiArquivo.execute();
                        }
                    }
                    CallableStatement callExcluiAuditar = connection.prepareCall("DELETE FROM auditoria WHERE timestamp BETWEEN " + inicio.getTime() + " AND " + fim.getTime());
                    callExcluiAuditar.execute();
                }
            });
            sessao.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.out.println("erro arquivar auditoria: " + e);
            return false;
        }
    }
}
