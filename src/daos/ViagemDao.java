/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

/**
 *
 * @author Matheus
 */
import entidades.Unidade;
import entidades.Viagem;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

public class ViagemDao extends Dao {

    public static Viagem buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Viagem v = (Viagem) sessao.get(Viagem.class, id);
            return v;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static void popularTabelaFiltro(JTable tabela, Unidade origem, String ativo) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Id";
        cabecalho[1] = "Origem";
        cabecalho[2] = "Destino";
        cabecalho[3] = "Motorista";
        cabecalho[4] = "Veículo";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            crit = sessao.createCriteria(Viagem.class);
            if(origem != null){
                crit.add(Restrictions.eq("unidadeByRefUnidadeOrigem", origem));
            }
            if(!ativo.isEmpty()){
                if(ativo.equals("true")){
                    crit.add(Restrictions.isNull("dataFinal"));
                } else if(ativo.equals("false")){
                    crit.add(Restrictions.isNotNull("dataFinal"));
                }
            }
            dados = crit.list();

            dadosTabela = new Object[dados.size()][5];

            int lin = 0;

            for (Object dado : dados) {
                Viagem v = (Viagem) dado;
                dadosTabela[lin][0] = v.getId();
                dadosTabela[lin][1] = v.getUnidadeByRefUnidadeOrigem().getDescricao();
                dadosTabela[lin][2] = v.getUnidadeByRefUnidadeDestino().getDescricao();
                if (v.getUsuario() != null) {
                    dadosTabela[lin][3] = v.getUsuario().getPessoa().getNome();
                }
                dadosTabela[lin][4] = v.getVeiculo().getDescricao();

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

    public static Double capacidadeRestante(Viagem viagem) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();

            Long retorno = sessao.doReturningWork(connection -> {
                try (CallableStatement function = connection.prepareCall(
                        "{ ? = call capacidade_restante(?) }")) {
                    function.registerOutParameter(1, Types.NUMERIC);
                    function.setInt(2, viagem.getId());
                    function.execute();
                    return function.getBigDecimal(1).longValue();
                }
            });
            
            return retorno + 0.00;
        } catch (Exception e) {
            System.out.println("erro consulta capacidade: " + e);
            return null;
        }
    }

    public static void registrarChegada(int idViagem) {

    }
}
