package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;
import java.io.*;
import java.time.*;

public class init {
    public static void main(String[] args){
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        
        ciudad[] Datos = new ciudad[77];
        
            Datos[1] = new ciudad(1, 3600, 2300);
            Datos[2] = new ciudad(2, 3100, 3300);
            Datos[3] = new ciudad(3, 4700, 5750);
            Datos[4] = new ciudad(4, 5400, 5750);
            Datos[5] = new ciudad(5, 5608, 7103);
            Datos[6] = new ciudad(6, 4493, 7102);
            Datos[7] = new ciudad(7, 3600, 6950);
            Datos[8] = new ciudad(8, 3100, 7250);
            Datos[9] = new ciudad(9, 4700, 8450);
            Datos[10] = new ciudad(10, 5400, 8450);
            Datos[11] = new ciudad(11, 5610, 10053);
            Datos[12] = new ciudad(12, 4492, 10052);
            Datos[13] = new ciudad(13, 3600, 10800);
            Datos[14] = new ciudad(14, 3100, 10950);
            Datos[15] = new ciudad(15, 4700, 11650);
            Datos[16] = new ciudad(16, 5400, 11650);
            Datos[17] = new ciudad(17, 6650, 10800);
            Datos[18] = new ciudad(18, 7300, 10950);
            Datos[19] = new ciudad(19, 7300, 7250);
            Datos[20] = new ciudad(20, 6650, 6950);
            Datos[21] = new ciudad(21, 7300, 3300);
            Datos[22] = new ciudad(22, 6650, 2300);
            Datos[23] = new ciudad(23, 5400, 1600);
            Datos[24] = new ciudad(24, 8350, 2300);
            Datos[25] = new ciudad(25, 7850, 3300);
            Datos[26] = new ciudad(26, 9450, 5750);
            Datos[27] = new ciudad(27, 10150, 5750);
            Datos[28] = new ciudad(28, 10358, 7103);
            Datos[29] = new ciudad(29, 9243, 7102);
            Datos[30] = new ciudad(30, 8350, 6950);
            Datos[31] = new ciudad(31, 7850, 7250);
            Datos[32] = new ciudad(32, 9450, 8450);
            Datos[33] = new ciudad(33, 10150, 8450);
            Datos[34] = new ciudad(34, 10360, 10053);
            Datos[35] = new ciudad(35, 9242, 10052);
            Datos[36] = new ciudad(36, 8350, 10800);
            Datos[37] = new ciudad(37, 7850, 10950);
            Datos[38] = new ciudad(38, 9450, 11650);
            Datos[39] = new ciudad(39, 10150, 11650);
            Datos[40] = new ciudad(40, 11400, 10800);
            Datos[41] = new ciudad(41, 12050, 10950);
            Datos[42] = new ciudad(42, 12050, 7250);
            Datos[43] = new ciudad(43, 11400, 6950);
            Datos[44] = new ciudad(44, 12050, 3300);
            Datos[45] = new ciudad(45, 11400, 2300);
            Datos[46] = new ciudad(46, 10150, 1600);
            Datos[47] = new ciudad(47, 13100, 2300);
            Datos[48] = new ciudad(48, 12600, 3300);
            Datos[49] = new ciudad(49, 14200, 5750);
            Datos[50] = new ciudad(50, 14900, 5750);
            Datos[51] = new ciudad(51, 15108, 7103);
            Datos[52] = new ciudad(52, 13993, 7102);
            Datos[53] = new ciudad(53, 13100, 6950);
            Datos[54] = new ciudad(54, 12600, 7250);
            Datos[55] = new ciudad(55, 14200, 8450);
            Datos[56] = new ciudad(56, 14900, 8450);
            Datos[57] = new ciudad(57, 15110, 10053);
            Datos[58] = new ciudad(58, 13992, 10052);
            Datos[59] = new ciudad(59, 13100, 10800);
            Datos[60] = new ciudad(60, 12600, 10950);
            Datos[61] = new ciudad(61, 14200, 11650);
            Datos[62] = new ciudad(62, 14900, 11650);
            Datos[63] = new ciudad(63, 16150, 10800);
            Datos[64] = new ciudad(64, 16800, 10950);
            Datos[65] = new ciudad(65, 16800, 7250);
            Datos[66] = new ciudad(66, 16150, 6950);
            Datos[67] = new ciudad(67, 16800, 3300);
            Datos[68] = new ciudad(68, 16150, 2300);
            Datos[69] = new ciudad(69, 14900, 1600);
            Datos[70] = new ciudad(70, 19800, 800);
            Datos[71] = new ciudad(71, 19800, 10000);
            Datos[72] = new ciudad(72, 19800, 11900);
            Datos[73] = new ciudad(73, 19800, 12200);
            Datos[74] = new ciudad(74, 200, 12200);
            Datos[75] = new ciudad(75, 200, 1100);
            Datos[76] = new ciudad(76, 200, 800);
        
        List<ciudad> lista = new ArrayList<ciudad>();     
        for (int i=1; i <= 10; i++)
            lista.add(Datos[i]);
                
        
        File Ffichero=new File("C:\\Users\\Jara\\Desktop\\TSP Solucion.txt");
        
        PermutacionesIterator iter = new PermutacionesIterator(lista);
        int id = 0, contador = 0;
        List<String> optimo = new ArrayList<String>(); //lista en la que se guardan los optimos
        double total, auxiliar = 0;
        
        while (iter.hasNext()){
            TspSol sol = new TspSol(id, iter.next());
            total = sol.getFitness();
            
            
            if (total > 0 && auxiliar == 0)
            {
                auxiliar = total;
                optimo.add(sol.toString());
                contador++;
            }
            
            if (auxiliar < total)
            {
            }
            
            if (auxiliar == total)
            {
                optimo.add(sol.toString());
                contador++;
            }
            
            if (auxiliar > total)
            {
                auxiliar = total;
                optimo.clear();
                contador = 0;
                optimo.add(sol.toString());
                contador++;
            }
            id++;
        }
        Iterator listarOptimo = optimo.iterator();
        String Optimos;
        EscribirFichero(Ffichero,"Los Tours Optimos son los siguientes");
        while (listarOptimo.hasNext()){
            //System.out.println(listarOptimo.next());
            Optimos = optimo.toString();
            listarOptimo.next();
            EscribirFichero(Ffichero,Optimos);
        }
      long end = System.currentTimeMillis();
      long res = end - time_start;
      EscribirFichero(Ffichero,"La ejecucion del programa demora "+res/1000+" segundos.");
        
        
    }
    public static  void BorrarFichero(File Ffichero){  
     try {    
         if(Ffichero.exists()){     
           Ffichero.delete();  
         }  
     } catch (Exception ex) { 
         System.out.println(ex.getMessage());  
     }  
}   
    public static void EscribirFichero(File Ffichero,String SCadena){  
  try {    
           if(!Ffichero.exists()){  
               Ffichero.createNewFile();  
           }  
          BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero,true), "utf-8"));  
          Fescribe.write(SCadena + "\r\n");   
          Fescribe.close();  
       } catch (Exception ex) {  
          System.out.println(ex.getMessage());  
       }   
}  
    
    
}
