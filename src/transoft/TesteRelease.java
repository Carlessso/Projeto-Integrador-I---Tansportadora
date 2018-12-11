/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transoft;

import daos.Dao;
import daos.ReleaseDao;
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

/**
 *
 * @author Matheus
 */
public class TesteRelease {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
    {
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
}
