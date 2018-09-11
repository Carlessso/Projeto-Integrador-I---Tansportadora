/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Grupo;
import entidades.GrupoProgramas;
import entidades.Programas;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Matheus
 */
public class GrupoProgamaDao {
    
    public static void deletarTodos(Grupo grupo)
    {
        Session sessao = null;
        try
            {
            sessao = HibernateUtil.getSessionFactory().openSession();
            List dados = null;
            Criteria crit;

            crit = sessao.createCriteria(GrupoProgramas.class);
            crit.add(Restrictions.eq("grupo", grupo));
            
            dados = crit.list();

            for (Object dado : dados) {
                GrupoProgramas gp = (GrupoProgramas) dado;

                Transaction t = sessao.beginTransaction();
                sessao.delete(gp);
                t.commit();
                           
            }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }
    }
    public static GrupoProgramas buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            GrupoProgramas g = (GrupoProgramas) sessao.get(GrupoProgramas.class, id);
            return g;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }
    public static void popularTabelaFiltro(JTable tabela, Grupo codigo, String filtro) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Programa";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            crit = sessao.createCriteria(GrupoProgramas.class);
            
            crit.add(Restrictions.eq(filtro, codigo));
            dados = crit.list();

            dadosTabela = new Object[dados.size()][2];

            int lin = 0;

            for (Object dado : dados) {
                GrupoProgramas gp = (GrupoProgramas) dado;
                Programas p = ProgramaDao.buscaId(gp.getProgramas().getId());
                
                dadosTabela[lin][0] = p.getId();
                dadosTabela[lin][1] = p.getDescricao();
                
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
                return false;
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {

                if (column == 2) {
                    //   return ImageIcon.class;
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

    public static GrupoProgramas getMaxId() {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        List dados = null;
        Criteria crit;

        crit = sessao.createCriteria(GrupoProgramas.class);
        
        crit.addOrder(Order.desc("id"));
        crit.setMaxResults(1);       

        return (GrupoProgramas)crit.uniqueResult();
        
    }
}
