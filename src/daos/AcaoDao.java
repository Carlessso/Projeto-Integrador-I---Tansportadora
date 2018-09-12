/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Acao;
import entidades.Programas;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author ramon
 */
public class AcaoDao {
    
    public static Acao buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Acao a = (Acao) sessao.get(Acao.class, id);
            return a;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }
    
    public static void popularTabelaFiltro(JTable tabela, Programas programa) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Ação";
        cabecalho[2] = "Permitir";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;
            
            crit = sessao.createCriteria(Acao.class);
            crit.add(Restrictions.eq("programas", programa));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][3];

            int lin = 0;

            for (Object dado : dados) {
                Acao a = (Acao) dado;
                
                dadosTabela[lin][0] = a.getId();
                dadosTabela[lin][1] = a.getDescricao();
                dadosTabela[lin][2] = false;
                
                lin++;
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                if (column == 2) {
                    return true;
                }
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    return Boolean.class;
                }
                return Object.class;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(50);
                    column.setMaxWidth(50);
                case 1:
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(70);
                    break;
                case 3:
                    column.setPreferredWidth(25);
                    break;
            }
        }
    }
    
}
