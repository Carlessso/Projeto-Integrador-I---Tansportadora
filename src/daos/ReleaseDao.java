/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entidades.Cidade;
import entidades.Estado;
import entidades.Pais;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import entidades.ComboItens;
import entidades.Release;
import entidades.ReleaseItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import transoft.TranSOFT;
import util.HibernateUtil;

/**
 *
 * @author Matheus
 */
public class ReleaseDao extends Dao {

    public static Release buscaId(int id) {
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Release r = (Release) sessao.get(Release.class, id);
            return r;

        } catch (HibernateException he) {
            he.printStackTrace();

            return null;
        } finally {
            sessao.close();
        }
    }

    public static void popularTabelaFiltro(JTable tabela, String criterio, String filtro) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Versão";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Lido";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            int count = 0;

            crit = sessao.createCriteria(Release.class);

            dados = crit.list();

            for (Object dado : dados) {
                Release r = (Release) dado;

                if (!ReleaseUsuarioDao.isLido(TranSOFT.USUARIO.getId(), r.getId())) {
                    count++;
                }
            }

            dadosTabela = new Object[count][3];

            int lin = 0;

            for (Object dado : dados) {
                Release r = (Release) dado;

                if (!ReleaseUsuarioDao.isLido(TranSOFT.USUARIO.getId(), r.getId())) {
                    dadosTabela[lin][0] = r.getVersao();
                    dadosTabela[lin][1] = r.getDescricao();
                    dadosTabela[lin][2] = false;

                    lin++;
                }
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

    public static Release getByDescricao(String descricao) {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();

            Criteria criterio = sessao.createCriteria(Release.class);
            criterio.add(Restrictions.eq("descricao", descricao));

            dados = criterio.list();

            for (Object dado : dados) {
                Release r = (Release) dado;

                return r;

            }
        } catch (HibernateException he) {
            he.printStackTrace();

        } finally {
            sessao.close();
        }
        return null;
    }

    public static void popularTabelaItens(JTable tabela, Release r) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Versão";
        cabecalho[1] = "Descrição";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            int count = 0;

            crit = sessao.createCriteria(ReleaseItem.class);
            crit.add(Restrictions.eq("release", r));

            dados = crit.list();

            dadosTabela = new Object[dados.size()][2];

            int lin = 0;

            for (Object dado : dados) {
                ReleaseItem ri = (ReleaseItem) dado;

                dadosTabela[lin][0] = r.getVersao();
                dadosTabela[lin][1] = ri.getDescricao();

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

    public static void popularTabelaHistorico(JTable tabela, String criterio, String filtro) {
        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Versão";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Não Lido";

        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            int count = 0;

            crit = sessao.createCriteria(Release.class);

            dados = crit.list();

            for (Object dado : dados) {
                Release r = (Release) dado;

                if (ReleaseUsuarioDao.isLido(TranSOFT.USUARIO.getId(), r.getId())) {
                    count++;
                }
            }

            dadosTabela = new Object[count][3];

            int lin = 0;

            for (Object dado : dados) {
                Release r = (Release) dado;

                if (ReleaseUsuarioDao.isLido(TranSOFT.USUARIO.getId(), r.getId())) {
                    dadosTabela[lin][0] = r.getVersao();
                    dadosTabela[lin][1] = r.getDescricao();
                    dadosTabela[lin][2] = false;

                    lin++;
                }
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

    public static void gravaReleases() throws FileNotFoundException, IOException, ParseException {
        File file = new File("release");
        File[] arquivos = file.listFiles();

        for (File fileRelease : arquivos) 
        {
            Properties p = new Properties();
            p.load(new FileInputStream(fileRelease.getPath()));
            String descricao = p.getProperty("descricao");

            if(ReleaseDao.releaseNovo(descricao))
            {
                Release r = new Release();
                
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
                r.setDescricao(descricao);
                r.setVersao(p.getProperty("versao"));
                Date date = sdf.parse(p.getProperty("data"));
                r.setData(date);

                Dao.salvar(r);               
                
                String propItem = p.getProperty("itens");
                
                String[] Itens = propItem.split(",");
                
                for (String item : Itens) 
                {
                    ReleaseItem ri = new ReleaseItem();
                    
                    ri.setDescricao(item);
                    ri.setRelease(r);
                    Dao.salvar(ri);
                }
                
            }
            
        }
    }

    public static boolean releaseNovo(String descricao) {
        Session sessao = null;
        List dados = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Criteria crit;

            crit = sessao.createCriteria(Release.class);
            crit.add(Restrictions.eq("descricao", descricao));
            sessao = HibernateUtil.getSessionFactory().openSession();

            dados = crit.list();

            for (Object dado : dados) {
                return false;
            }
            
        } catch (HibernateException he) {
            he.printStackTrace();

        } finally {
            sessao.close();
        }
        return true;
    }
}
