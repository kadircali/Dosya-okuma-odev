import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\akadi\\OneDrive\\Masaüstü\\dnm.txt";
        File file = new File(path);
        String sayilar = "0123456789";
        String islemler = "+-*/";

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String satir;
            while ((satir = br.readLine()) != null) {
                System.out.println(satir);

                String birinci = "";
                char islem = ' ';
                String ikinci = "";


                for (int i = 0; i < satir.length(); i++) {
                    char ch = satir.charAt(i);
                    if (islemler.indexOf(ch) != -1) {
                        birinci = satir.substring(0, i);
                        islem = ch;
                        ikinci = satir.substring(i + 1);
                        break;
                    }
                }

                try {
                    System.out.println(islem+" "+"işleminin sonucu:"+islemYap(birinci,ikinci,islem));
                }catch (Exception e){
                    System.out.println(e);
                }
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı");
        } catch (IOException e) {
            System.out.println("Giriş/Çıkış hatası");
        }
    }


    public static double  islemYap(String s1 , String s2,char islem) throws MyException {
        double sayi1=0;
        double sayi2=0;
    try {
        sayi1 = Double.parseDouble(s1);
        sayi2 = Double.parseDouble(s2);

    }catch (Exception e){
        throw new MyException("Geçersiz sayı");

    }

        if(islem == '+'){

          return sayi1+sayi2;

        }else if(islem == '-'){

                return sayi1-sayi2;

        }else if(islem == '*'){

                return sayi1*sayi2;
        }else if(islem == '/'){

            return sayi1/sayi2;
        }else{
            return 0.0;
        }


    }
}
