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
import org.hibernate.Session;

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
        Runtime rt = Runtime.getRuntime();
        Process p;
        ProcessBuilder pb;
        rt = Runtime.getRuntime();

        pb = new ProcessBuilder(
                "C:\\Program Files\\PostgreSQL\\10\\bin\\pg_restore.exe",
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
            if (p.exitValue() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
