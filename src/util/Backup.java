/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

/**
 *
 * @author ramon
 */
public class Backup {

    public static boolean backupBD(String local) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        rt = Runtime.getRuntime();
        pb = new ProcessBuilder(
                "postgres\\pg_dump.exe",
                "--host", "localhost",
                "--port", "5432",
                "--username", "postgres",
                "--no-password",
                "--format", "custom",
                "--blobs",
                "--verbose", "--file", local, "transoft");
        try {
            pb.environment().put("PGPASSWORD", "postgres");
            p = pb.start();
            final BufferedReader r = new BufferedReader(
                    new InputStreamReader(p.getErrorStream()));
            String line = r.readLine();
            while (line != null) {
                System.err.println(line);
                line = r.readLine();
            }
            r.close();
            p.waitFor();
            System.out.println(p.exitValue());
            if (p.exitValue() == 0) {
                return true;
            } else {
                new File(local).delete();
                return false;
            }
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            new File(local).delete();
            return false;
        }
    }

    public static boolean restoreBD(String local) throws IOException {
        if (derrubarConexoes()) {
            Runtime rt = Runtime.getRuntime();
            Process p;
            ProcessBuilder pb;
            rt = Runtime.getRuntime();

            pb = new ProcessBuilder(
                    "postgres\\pg_restore.exe",
                    "--host", "localhost",
                    "--port", "5432",
                    "--username", "postgres",
                    "--no-password",
                    "--clean",
                    "--verbose",
                    "--dbname", "transoft",
                    local);
            try {
                pb.environment().put("PGPASSWORD", "postgres");
                pb.redirectErrorStream(true);
                p = pb.start();
                InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String ll;
                while ((ll = br.readLine()) != null) {
                    System.out.println(ll);
                }
                System.out.println(p.exitValue());

                return p.exitValue() == 0;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean derrubarConexoes() {
        Runtime rt = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        rt = Runtime.getRuntime();

        pb = new ProcessBuilder(
                "postgres\\psql.exe",
                "--host", "localhost",
                "--port", "5432",
                "--username", "postgres",
                "--no-password",
                "--dbname", "transoft",
                "-c SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'transoft'");
        try {
            pb.environment().put("PGPASSWORD", "postgres");
            pb.redirectErrorStream(true);
            p = pb.start();
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String ll;
            while ((ll = br.readLine()) != null) {
                System.out.println(ll);
            }
            System.out.println(p.exitValue());

            return p.exitValue() == 0;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
