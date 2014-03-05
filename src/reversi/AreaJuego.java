
package reversi;

/**
 * @author Yuli
 */
//import java.awt.event.ActionEvent;import java.awt.event.ActionListener;
//import javax.swing.JButton;import javax.swing.JMenuItem;import java.util.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AreaJuego extends javax.swing.JFrame {
/**
     * @param args the command line arguments
     */
    
 public int matriz[][]    = new int [8][8];//[renglones][columnas]
 private ImageIcon user   = new ImageIcon("rosa.jpg");
 private ImageIcon compu  = new ImageIcon("naranja.jpg");
 private ImageIcon verde  = new ImageIcon("verde.jpg");
 public int turno=0,turno2=1, bandera=0, x, y;    // 1: usuario
 int contador1=0; int contador2=0;
 
 public  List <Integer> listaJugadorX = new ArrayList <Integer>();
 public  List <Integer> listaJugadorY = new ArrayList <Integer>();
 public  List <Integer> listaFinalX   = new ArrayList <Integer>();
 public  List <Integer> listaFinalY   = new ArrayList <Integer>();
 
// ArrayList lista = new ArrayList (100); // Capacidad inicial: 100
// ArrayList<Integer> lista2 = new ArrayList<Integer> ();

 
    public AreaJuego() {
        initComponents();
        InicializarMatriz();
        MostrarResultados();
     }
    
    public void InicializarMatriz(){
         for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
         matriz[i][j]=2; }  }
         matriz[3][3]=1;
         matriz[3][4]=0;
         matriz[4][3]=0;
         matriz[4][4]=1;
         
         this.jMenu1.setMnemonic('G');
         this.jMenu2.setMnemonic('A');
  }

    
    public void DefinirMovimiento(){
        bandera=1; //bandera para verificar turnos
        int r=0;   //Para evaluar que fichas se agregan
        do{
           if(matriz[x][y]==2 && r==0){

                r=0; int u=0; int j=y+1; //para que no cuente el boton presionado
                do{                      //definir derecha
                    if(j<=7){
                        if(matriz[x][j]==turno){ r=1;listaJugadorX.add(x); listaJugadorY.add(j); }
                        else if(matriz[x][j]==turno2 && r==1){ bandera=0; listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal(); u=1; } 
                         else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                      j++;   }
                    else{ u=1; }
               }while(u==0);
 
                
      
                r=0; u=0;j=y-1;  //definir izquierda
                do{        
                    if(j>=0){
                      if(matriz[x][j]==turno){ r=1; listaJugadorX.add(x);listaJugadorY.add(j);}
                        else if(matriz[x][j]==turno2 && r==1){ bandera=0; listaFinalX.add(x);listaFinalY.add(y); MovimientoFinal();u=1; } 
                        else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                      j--;   }
                    else{ u=1;}
                }while(u==0);
      
                
                
                r=0; u=0;   int i=x-1;  //definir arriba
                do{      
                     if(i>=0){
                       if(matriz[i][y]==turno){ r=1; listaJugadorX.add(i); listaJugadorY.add(y); }
                           else if(matriz[i][y]==turno2 && r==1){bandera=0; listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal();u=1; } 
                           else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i--; }
                     else{ u=1;}
               }while(u==0);

                
                
                r=0; u=0;  i=x+1;   //definir abajo
                do{        
                    if(i<=7){
                      if(matriz[i][y]==turno){ r=1; listaJugadorX.add(i); listaJugadorY.add(y); }
                         else if(matriz[i][y]==turno2 && r==1){bandera=0; listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal();u=1; }
                         else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i++;  }
                    else{ u=1;}
               }while(u==0);
                 
                
                r=0; u=0;   i=x-1;  j=y+1;  //definir diagonal derecha arriba
                do{                
                    if(i>=0 && j<=7){
                      if(matriz[i][j]==turno){ r=1;listaJugadorX.add(i); listaJugadorY.add(j); }  
                         else if(matriz[i][j]==turno2 && r==1){bandera=0; listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal(); u=1;} 
                          else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i--;   j++; }  
                   else{ u=1; }     
                }while(u==0);

   
                r=0; u=0;   i=x-1;   j=y-1;   //comprobar diagonal izquierda arriba
                 do{                
                    if(i>=0 && j>=0){
                      if(matriz[i][j]==turno){ r=1; listaJugadorX.add(i); listaJugadorY.add(j); }
                         else if(matriz[i][j]==turno2 && r==1){ bandera=0;listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal(); u=1;} 
                      else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i--;    j--;  }
                    else{ u=1; } 
                }while(u==0);

                 
                r=0; u=0;   i=x+1;  j=y-1;   //definir diagonal izquierda abajo
                 do{                
                    if(i<=7 && j>=0){
                      if(matriz[i][j]==turno){ r=1;listaJugadorX.add(i); listaJugadorY.add(j); }
                        else if(matriz[i][j]==turno2 && r==1){bandera=0;listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal();  u=1; } 
                      else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i++;  j--;   }
                    else{ u=1; } 
                }while(u==0);
           
   
                 r=0; u=0; i=x+1;  j=y+1;  //definir diagonal derecha abajo
                 do{                
                    if(i<=7 && j<=7){ 
                      if(matriz[i][j]==turno){ r=1; listaJugadorX.add(i); listaJugadorY.add(j); }
                        else if(matriz[i][j]==turno2 && r==1){bandera=0; listaFinalX.add(x);listaFinalY.add(y);MovimientoFinal();  u=1; } 
                      else {listaJugadorX.clear();listaJugadorY.clear();u=1;}
                     i++;  j++;  }
                    else{ u=1; } 
                }while(u==0);
                 r=1;
           } 
           
               else{ JOptionPane.showMessageDialog(this,"Movimiento invalido","Registro", JOptionPane.INFORMATION_MESSAGE);r=1;bandera=1;}
       }while(r==0);
   } 
      
    
   public void MovimientoFinal(){
    
       for(int i=0;i<listaJugadorX.size();i++){ 
               listaFinalX.add(listaJugadorX.get(i));  }  
       for(int i=0;i<listaJugadorY.size();i++){ 
               listaFinalY.add(listaJugadorY.get(i));  } 
       
            listaJugadorX.clear(); //limpiar las listas, para reiniciar
            listaJugadorY.clear();
       
   } 
        

    public void ActualizarMatriz(){
      if(bandera==0){
        if(turno==1){  //agrega naranja 
           for(int i=0;i<listaFinalX.size();i++){ 
               matriz[listaFinalX.get(i)][listaFinalY.get(i)]=0; }  
       }
       
       if(turno==0){  //agrega rosa
           for(int i=0;i<listaFinalX.size();i++){ 
               matriz[listaFinalX.get(i)][listaFinalY.get(i)]=1; }  
       }
        Marcador();
      }
  } 
    
    
    public void ComprobarGanador(){
        int h=0;
         for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(matriz[i][j]==2){
                h=1;   }
            }
         }
         if(h==1){     } //No hase nada
             else{       //Al entrar aqui inisializa el juego
                  if(contador1 > contador2){
                  JOptionPane.showMessageDialog(this,"Ganaste Jugador Naranja\n"+contador1+" a "+contador2,"Puntuación", JOptionPane.INFORMATION_MESSAGE);
                   }
                  else if(contador1 < contador2){
                  JOptionPane.showMessageDialog(this,"Ganaste Jugador Rosa"+contador2+" a "+contador1,"Puntuación", JOptionPane.INFORMATION_MESSAGE);
                   }
                  else{
                  JOptionPane.showMessageDialog(this,"Empate","Puntuación", JOptionPane.INFORMATION_MESSAGE);
                  }
                  InicializarMatriz(); Marcador();MostrarResultados();
             }
 }
            
    
    public void Marcador(){
        int h=0;
         if(bandera==0){
         contador1=0; contador2=0; 
         for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(matriz[i][j]==0){ contador1++;  }      //naranja
                else if (matriz[i][j]==1){ contador2++; } //rosa
              }
         } 
         String s = Integer.toString(contador1);
         String s2 = Integer.toString(contador2);
         jLabel1.setText(s2);  //rosas
         jLabel2.setText(s); //naranjas
    }}
    
       
    public void MostrarResultados(){
         if(bandera==0){
         if(matriz[0][0]==0){ jButton81.setIcon(compu);} else if (matriz[0][0]==1){ jButton81.setIcon(user);}else{jButton81.setIcon(verde);}
         if(matriz[0][1]==0){ jButton82.setIcon(compu);} else if (matriz[0][1]==1){ jButton82.setIcon(user);}else{jButton82.setIcon(verde);}
         if(matriz[0][2]==0){ jButton83.setIcon(compu);} else if (matriz[0][2]==1){ jButton83.setIcon(user);}else{jButton83.setIcon(verde);}
         if(matriz[0][3]==0){ jButton84.setIcon(compu);} else if (matriz[0][3]==1){ jButton84.setIcon(user);}else{jButton84.setIcon(verde);}
         if(matriz[0][4]==0){ jButton85.setIcon(compu);} else if (matriz[0][4]==1){ jButton85.setIcon(user);}else{jButton85.setIcon(verde);}
         if(matriz[0][5]==0){ jButton86.setIcon(compu);} else if (matriz[0][5]==1){ jButton86.setIcon(user);}else{jButton86.setIcon(verde);}
         if(matriz[0][6]==0){ jButton87.setIcon(compu);} else if (matriz[0][6]==1){ jButton87.setIcon(user);}else{jButton87.setIcon(verde);}
         if(matriz[0][7]==0){ jButton88.setIcon(compu);} else if (matriz[0][7]==1){ jButton88.setIcon(user);}else{jButton88.setIcon(verde);}
         if(matriz[1][0]==0){ jButton89.setIcon(compu);} else if (matriz[1][0]==1){ jButton89.setIcon(user);}else{jButton89.setIcon(verde);}
         if(matriz[1][1]==0){ jButton90.setIcon(compu);} else if (matriz[1][1]==1){ jButton90.setIcon(user);}else{jButton90.setIcon(verde);}
         if(matriz[1][2]==0){ jButton91.setIcon(compu);} else if (matriz[1][2]==1){ jButton91.setIcon(user);}else{jButton91.setIcon(verde);}
         if(matriz[1][3]==0){ jButton92.setIcon(compu);} else if (matriz[1][3]==1){ jButton92.setIcon(user);}else{jButton92.setIcon(verde);}
         if(matriz[1][4]==0){ jButton93.setIcon(compu);} else if (matriz[1][4]==1){ jButton93.setIcon(user);}else{jButton93.setIcon(verde);}
         if(matriz[1][5]==0){ jButton94.setIcon(compu);} else if (matriz[1][5]==1){ jButton94.setIcon(user);}else{jButton94.setIcon(verde);}
         if(matriz[1][6]==0){ jButton95.setIcon(compu);} else if (matriz[1][6]==1){ jButton95.setIcon(user);}else{jButton95.setIcon(verde);}
         if(matriz[1][7]==0){ jButton96.setIcon(compu);} else if (matriz[1][7]==1){ jButton96.setIcon(user);}else{jButton96.setIcon(verde);}
         if(matriz[2][0]==0){ jButton97.setIcon(compu);} else if (matriz[2][0]==1){ jButton97.setIcon(user);}else{jButton97.setIcon(verde);}
         if(matriz[2][1]==0){ jButton98.setIcon(compu);} else if (matriz[2][1]==1){ jButton98.setIcon(user);}else{jButton98.setIcon(verde);}
         if(matriz[2][2]==0){ jButton99.setIcon(compu);} else if (matriz[2][2]==1){ jButton99.setIcon(user);}else{jButton99.setIcon(verde);}
         if(matriz[2][3]==0){ jButton100.setIcon(compu);} else if (matriz[2][3]==1){ jButton100.setIcon(user);}else{jButton100.setIcon(verde);}
         if(matriz[2][4]==0){ jButton101.setIcon(compu);} else if (matriz[2][4]==1){ jButton101.setIcon(user);}else{jButton101.setIcon(verde);}
         if(matriz[2][5]==0){ jButton102.setIcon(compu);} else if (matriz[2][5]==1){ jButton102.setIcon(user);}else{jButton102.setIcon(verde);}
         if(matriz[2][6]==0){ jButton103.setIcon(compu);} else if (matriz[2][6]==1){ jButton103.setIcon(user);}else{jButton103.setIcon(verde);}
         if(matriz[2][7]==0){ jButton104.setIcon(compu);} else if (matriz[2][7]==1){ jButton104.setIcon(user);}else{jButton104.setIcon(verde);}
         if(matriz[3][0]==0){ jButton105.setIcon(compu);} else if (matriz[3][0]==1){ jButton105.setIcon(user);}else{jButton105.setIcon(verde);}
         if(matriz[3][1]==0){ jButton106.setIcon(compu);} else if (matriz[3][1]==1){ jButton106.setIcon(user);}else{jButton106.setIcon(verde);}
         if(matriz[3][2]==0){ jButton107.setIcon(compu);} else if (matriz[3][2]==1){ jButton107.setIcon(user);}else{jButton107.setIcon(verde);}
         if(matriz[3][3]==0){ jButton108.setIcon(compu);} else if (matriz[3][3]==1){ jButton108.setIcon(user);}else{jButton108.setIcon(verde);}
         if(matriz[3][4]==0){ jButton109.setIcon(compu);} else if (matriz[3][4]==1){ jButton109.setIcon(user);}else{jButton109.setIcon(verde);}
         if(matriz[3][5]==0){ jButton110.setIcon(compu);} else if (matriz[3][5]==1){ jButton110.setIcon(user);}else{jButton110.setIcon(verde);}
         if(matriz[3][6]==0){ jButton111.setIcon(compu);} else if (matriz[3][6]==1){ jButton111.setIcon(user);}else{jButton111.setIcon(verde);}
         if(matriz[3][7]==0){ jButton112.setIcon(compu);} else if (matriz[3][7]==1){ jButton112.setIcon(user);}else{jButton112.setIcon(verde);}
         if(matriz[4][0]==0){ jButton113.setIcon(compu);} else if (matriz[4][0]==1){ jButton113.setIcon(user);}else{jButton113.setIcon(verde);}
         if(matriz[4][1]==0){ jButton114.setIcon(compu);} else if (matriz[4][1]==1){ jButton114.setIcon(user);}else{jButton114.setIcon(verde);}
         if(matriz[4][2]==0){ jButton115.setIcon(compu);} else if (matriz[4][2]==1){ jButton115.setIcon(user);}else{jButton115.setIcon(verde);}
         if(matriz[4][3]==0){ jButton116.setIcon(compu);} else if (matriz[4][3]==1){ jButton116.setIcon(user);}else{jButton116.setIcon(verde);}
         if(matriz[4][4]==0){ jButton117.setIcon(compu);} else if (matriz[4][4]==1){ jButton117.setIcon(user);}else{jButton117.setIcon(verde);}
         if(matriz[4][5]==0){ jButton118.setIcon(compu);} else if (matriz[4][5]==1){ jButton118.setIcon(user);}else{jButton118.setIcon(verde);}
         if(matriz[4][6]==0){ jButton119.setIcon(compu);} else if (matriz[4][6]==1){ jButton119.setIcon(user);}else{jButton119.setIcon(verde);}
         if(matriz[4][7]==0){ jButton120.setIcon(compu);} else if (matriz[4][7]==1){ jButton120.setIcon(user);}else{jButton120.setIcon(verde);}
         if(matriz[5][0]==0){ jButton121.setIcon(compu);} else if (matriz[5][0]==1){ jButton121.setIcon(user);}else{jButton121.setIcon(verde);}
         if(matriz[5][1]==0){ jButton122.setIcon(compu);} else if (matriz[5][1]==1){ jButton122.setIcon(user);}else{jButton122.setIcon(verde);}
         if(matriz[5][2]==0){ jButton123.setIcon(compu);} else if (matriz[5][2]==1){ jButton123.setIcon(user);}else{jButton123.setIcon(verde);}
         if(matriz[5][3]==0){ jButton124.setIcon(compu);} else if (matriz[5][3]==1){ jButton124.setIcon(user);}else{jButton124.setIcon(verde);}
         if(matriz[5][4]==0){ jButton125.setIcon(compu);} else if (matriz[5][4]==1){ jButton125.setIcon(user);}else{jButton125.setIcon(verde);}
         if(matriz[5][5]==0){ jButton126.setIcon(compu);} else if (matriz[5][5]==1){ jButton126.setIcon(user);}else{jButton126.setIcon(verde);}
         if(matriz[5][6]==0){ jButton127.setIcon(compu);} else if (matriz[5][6]==1){ jButton127.setIcon(user);}else{jButton127.setIcon(verde);}
         if(matriz[5][7]==0){ jButton128.setIcon(compu);} else if (matriz[5][7]==1){ jButton128.setIcon(user);}else{jButton128.setIcon(verde);}
         if(matriz[6][0]==0){ jButton129.setIcon(compu);} else if (matriz[6][0]==1){ jButton129.setIcon(user);}else{jButton129.setIcon(verde);}
         if(matriz[6][1]==0){ jButton130.setIcon(compu);} else if (matriz[6][1]==1){ jButton130.setIcon(user);}else{jButton130.setIcon(verde);}
         if(matriz[6][2]==0){ jButton131.setIcon(compu);} else if (matriz[6][2]==1){ jButton131.setIcon(user);}else{jButton131.setIcon(verde);}
         if(matriz[6][3]==0){ jButton132.setIcon(compu);} else if (matriz[6][3]==1){ jButton132.setIcon(user);}else{jButton132.setIcon(verde);}
         if(matriz[6][4]==0){ jButton133.setIcon(compu);} else if (matriz[6][4]==1){ jButton133.setIcon(user);}else{jButton133.setIcon(verde);}
         if(matriz[6][5]==0){ jButton134.setIcon(compu);} else if (matriz[6][5]==1){ jButton134.setIcon(user);}else{jButton134.setIcon(verde);}
         if(matriz[6][6]==0){ jButton135.setIcon(compu);} else if (matriz[6][6]==1){ jButton135.setIcon(user);}else{jButton135.setIcon(verde);}
         if(matriz[6][7]==0){ jButton136.setIcon(compu);} else if (matriz[6][7]==1){ jButton136.setIcon(user);}else{jButton136.setIcon(verde);}
         if(matriz[7][0]==0){ jButton137.setIcon(compu);} else if (matriz[7][0]==1){ jButton137.setIcon(user);}else{jButton137.setIcon(verde);}
         if(matriz[7][1]==0){ jButton138.setIcon(compu);} else if (matriz[7][1]==1){ jButton138.setIcon(user);}else{jButton138.setIcon(verde);}
         if(matriz[7][2]==0){ jButton139.setIcon(compu);} else if (matriz[7][2]==1){ jButton139.setIcon(user);}else{jButton139.setIcon(verde);}
         if(matriz[7][3]==0){ jButton140.setIcon(compu);} else if (matriz[7][3]==1){ jButton140.setIcon(user);}else{jButton140.setIcon(verde);}
         if(matriz[7][4]==0){ jButton141.setIcon(compu);} else if (matriz[7][4]==1){ jButton141.setIcon(user);}else{jButton141.setIcon(verde);}
         if(matriz[7][5]==0){ jButton142.setIcon(compu);} else if (matriz[7][5]==1){ jButton142.setIcon(user);}else{jButton142.setIcon(verde);}
         if(matriz[7][6]==0){ jButton143.setIcon(compu);} else if (matriz[7][6]==1){ jButton143.setIcon(user);}else{jButton143.setIcon(verde);}
         if(matriz[7][7]==0){ jButton144.setIcon(compu);} else if (matriz[7][7]==1){ jButton144.setIcon(user);}else{jButton144.setIcon(verde);}
             
         listaJugadorX.clear();
         listaJugadorY.clear();
         listaFinalX.clear();
         listaFinalY.clear();         
     }
 } 
    
    
    public void CambiarTurno(){
        if(bandera==0){
        if(turno==0){ turno=1; }
        else{turno=0;}
      
        if(turno2==0){ turno2=1; }
        else{turno2=0;}
       }
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton88 = new javax.swing.JButton();
        jButton87 = new javax.swing.JButton();
        jButton86 = new javax.swing.JButton();
        jButton85 = new javax.swing.JButton();
        jButton84 = new javax.swing.JButton();
        jButton83 = new javax.swing.JButton();
        jButton82 = new javax.swing.JButton();
        jButton81 = new javax.swing.JButton();
        jButton89 = new javax.swing.JButton();
        jButton97 = new javax.swing.JButton();
        jButton105 = new javax.swing.JButton();
        jButton113 = new javax.swing.JButton();
        jButton121 = new javax.swing.JButton();
        jButton129 = new javax.swing.JButton();
        jButton137 = new javax.swing.JButton();
        jButton90 = new javax.swing.JButton();
        jButton98 = new javax.swing.JButton();
        jButton106 = new javax.swing.JButton();
        jButton114 = new javax.swing.JButton();
        jButton122 = new javax.swing.JButton();
        jButton130 = new javax.swing.JButton();
        jButton138 = new javax.swing.JButton();
        jButton91 = new javax.swing.JButton();
        jButton99 = new javax.swing.JButton();
        jButton107 = new javax.swing.JButton();
        jButton115 = new javax.swing.JButton();
        jButton123 = new javax.swing.JButton();
        jButton131 = new javax.swing.JButton();
        jButton139 = new javax.swing.JButton();
        jButton140 = new javax.swing.JButton();
        jButton132 = new javax.swing.JButton();
        jButton124 = new javax.swing.JButton();
        jButton116 = new javax.swing.JButton();
        jButton108 = new javax.swing.JButton();
        jButton100 = new javax.swing.JButton();
        jButton92 = new javax.swing.JButton();
        jButton93 = new javax.swing.JButton();
        jButton101 = new javax.swing.JButton();
        jButton109 = new javax.swing.JButton();
        jButton117 = new javax.swing.JButton();
        jButton125 = new javax.swing.JButton();
        jButton133 = new javax.swing.JButton();
        jButton141 = new javax.swing.JButton();
        jButton94 = new javax.swing.JButton();
        jButton102 = new javax.swing.JButton();
        jButton110 = new javax.swing.JButton();
        jButton118 = new javax.swing.JButton();
        jButton126 = new javax.swing.JButton();
        jButton134 = new javax.swing.JButton();
        jButton142 = new javax.swing.JButton();
        jButton95 = new javax.swing.JButton();
        jButton103 = new javax.swing.JButton();
        jButton111 = new javax.swing.JButton();
        jButton119 = new javax.swing.JButton();
        jButton127 = new javax.swing.JButton();
        jButton135 = new javax.swing.JButton();
        jButton143 = new javax.swing.JButton();
        jButton96 = new javax.swing.JButton();
        jButton104 = new javax.swing.JButton();
        jButton112 = new javax.swing.JButton();
        jButton120 = new javax.swing.JButton();
        jButton128 = new javax.swing.JButton();
        jButton136 = new javax.swing.JButton();
        jButton144 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(525, 650));
        getContentPane().setLayout(null);

        jButton88.setBackground(new java.awt.Color(5, 120, 5));
        jButton88.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton88MousePressed(evt);
            }
        });
        getContentPane().add(jButton88);
        jButton88.setBounds(410, 120, 45, 45);

        jButton87.setBackground(new java.awt.Color(5, 120, 5));
        jButton87.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton87.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton87MousePressed(evt);
            }
        });
        getContentPane().add(jButton87);
        jButton87.setBounds(360, 120, 45, 45);

        jButton86.setBackground(new java.awt.Color(5, 120, 5));
        jButton86.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton86.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton86MousePressed(evt);
            }
        });
        getContentPane().add(jButton86);
        jButton86.setBounds(310, 120, 45, 45);

        jButton85.setBackground(new java.awt.Color(5, 120, 5));
        jButton85.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton85.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton85MousePressed(evt);
            }
        });
        getContentPane().add(jButton85);
        jButton85.setBounds(260, 120, 45, 45);

        jButton84.setBackground(new java.awt.Color(5, 120, 5));
        jButton84.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton84MousePressed(evt);
            }
        });
        getContentPane().add(jButton84);
        jButton84.setBounds(210, 120, 45, 45);

        jButton83.setBackground(new java.awt.Color(5, 120, 5));
        jButton83.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton83MousePressed(evt);
            }
        });
        getContentPane().add(jButton83);
        jButton83.setBounds(160, 120, 45, 45);

        jButton82.setBackground(new java.awt.Color(5, 120, 5));
        jButton82.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton82MousePressed(evt);
            }
        });
        getContentPane().add(jButton82);
        jButton82.setBounds(110, 120, 45, 45);

        jButton81.setBackground(new java.awt.Color(5, 120, 5));
        jButton81.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton81MousePressed(evt);
            }
        });
        getContentPane().add(jButton81);
        jButton81.setBounds(60, 120, 45, 45);

        jButton89.setBackground(new java.awt.Color(5, 120, 5));
        jButton89.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton89MousePressed(evt);
            }
        });
        getContentPane().add(jButton89);
        jButton89.setBounds(60, 170, 45, 45);

        jButton97.setBackground(new java.awt.Color(5, 120, 5));
        jButton97.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton97.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton97MousePressed(evt);
            }
        });
        getContentPane().add(jButton97);
        jButton97.setBounds(60, 220, 45, 45);

        jButton105.setBackground(new java.awt.Color(5, 120, 5));
        jButton105.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton105.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton105MousePressed(evt);
            }
        });
        getContentPane().add(jButton105);
        jButton105.setBounds(60, 270, 45, 45);

        jButton113.setBackground(new java.awt.Color(5, 120, 5));
        jButton113.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton113.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton113MousePressed(evt);
            }
        });
        getContentPane().add(jButton113);
        jButton113.setBounds(60, 320, 45, 45);

        jButton121.setBackground(new java.awt.Color(5, 120, 5));
        jButton121.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton121MousePressed(evt);
            }
        });
        getContentPane().add(jButton121);
        jButton121.setBounds(60, 370, 45, 45);

        jButton129.setBackground(new java.awt.Color(5, 120, 5));
        jButton129.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton129.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton129MousePressed(evt);
            }
        });
        getContentPane().add(jButton129);
        jButton129.setBounds(60, 420, 45, 45);

        jButton137.setBackground(new java.awt.Color(5, 120, 5));
        jButton137.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton137.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton137MousePressed(evt);
            }
        });
        getContentPane().add(jButton137);
        jButton137.setBounds(60, 470, 45, 45);

        jButton90.setBackground(new java.awt.Color(5, 120, 5));
        jButton90.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton90MousePressed(evt);
            }
        });
        getContentPane().add(jButton90);
        jButton90.setBounds(110, 170, 45, 45);

        jButton98.setBackground(new java.awt.Color(5, 120, 5));
        jButton98.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton98MousePressed(evt);
            }
        });
        getContentPane().add(jButton98);
        jButton98.setBounds(110, 220, 45, 45);

        jButton106.setBackground(new java.awt.Color(5, 120, 5));
        jButton106.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton106.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton106MousePressed(evt);
            }
        });
        getContentPane().add(jButton106);
        jButton106.setBounds(110, 270, 45, 45);

        jButton114.setBackground(new java.awt.Color(5, 120, 5));
        jButton114.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton114.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton114MousePressed(evt);
            }
        });
        getContentPane().add(jButton114);
        jButton114.setBounds(110, 320, 45, 45);

        jButton122.setBackground(new java.awt.Color(5, 120, 5));
        jButton122.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton122MousePressed(evt);
            }
        });
        getContentPane().add(jButton122);
        jButton122.setBounds(110, 370, 45, 45);

        jButton130.setBackground(new java.awt.Color(5, 120, 5));
        jButton130.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton130.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton130MousePressed(evt);
            }
        });
        getContentPane().add(jButton130);
        jButton130.setBounds(110, 420, 45, 45);

        jButton138.setBackground(new java.awt.Color(5, 120, 5));
        jButton138.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton138.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton138MousePressed(evt);
            }
        });
        getContentPane().add(jButton138);
        jButton138.setBounds(110, 470, 45, 45);

        jButton91.setBackground(new java.awt.Color(5, 120, 5));
        jButton91.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton91MousePressed(evt);
            }
        });
        getContentPane().add(jButton91);
        jButton91.setBounds(160, 170, 45, 45);

        jButton99.setBackground(new java.awt.Color(5, 120, 5));
        jButton99.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton99MousePressed(evt);
            }
        });
        getContentPane().add(jButton99);
        jButton99.setBounds(160, 220, 45, 45);

        jButton107.setBackground(new java.awt.Color(5, 120, 5));
        jButton107.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton107.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton107MousePressed(evt);
            }
        });
        getContentPane().add(jButton107);
        jButton107.setBounds(160, 270, 45, 45);

        jButton115.setBackground(new java.awt.Color(5, 120, 5));
        jButton115.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton115MousePressed(evt);
            }
        });
        getContentPane().add(jButton115);
        jButton115.setBounds(160, 320, 45, 45);

        jButton123.setBackground(new java.awt.Color(5, 120, 5));
        jButton123.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton123.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton123MousePressed(evt);
            }
        });
        getContentPane().add(jButton123);
        jButton123.setBounds(160, 370, 45, 45);

        jButton131.setBackground(new java.awt.Color(5, 120, 5));
        jButton131.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton131.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton131MousePressed(evt);
            }
        });
        getContentPane().add(jButton131);
        jButton131.setBounds(160, 420, 45, 45);

        jButton139.setBackground(new java.awt.Color(5, 120, 5));
        jButton139.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton139.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton139MousePressed(evt);
            }
        });
        getContentPane().add(jButton139);
        jButton139.setBounds(160, 470, 45, 45);

        jButton140.setBackground(new java.awt.Color(5, 120, 5));
        jButton140.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton140.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton140MousePressed(evt);
            }
        });
        getContentPane().add(jButton140);
        jButton140.setBounds(210, 470, 45, 45);

        jButton132.setBackground(new java.awt.Color(5, 120, 5));
        jButton132.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton132.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton132MousePressed(evt);
            }
        });
        getContentPane().add(jButton132);
        jButton132.setBounds(210, 420, 45, 45);

        jButton124.setBackground(new java.awt.Color(5, 120, 5));
        jButton124.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton124.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton124MousePressed(evt);
            }
        });
        getContentPane().add(jButton124);
        jButton124.setBounds(210, 370, 45, 45);

        jButton116.setBackground(new java.awt.Color(5, 120, 5));
        jButton116.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton116.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton116MousePressed(evt);
            }
        });
        getContentPane().add(jButton116);
        jButton116.setBounds(210, 320, 45, 45);

        jButton108.setBackground(new java.awt.Color(5, 120, 5));
        jButton108.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton108.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton108MousePressed(evt);
            }
        });
        getContentPane().add(jButton108);
        jButton108.setBounds(210, 270, 45, 45);

        jButton100.setBackground(new java.awt.Color(5, 120, 5));
        jButton100.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton100MousePressed(evt);
            }
        });
        getContentPane().add(jButton100);
        jButton100.setBounds(210, 220, 45, 45);

        jButton92.setBackground(new java.awt.Color(5, 120, 5));
        jButton92.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton92MousePressed(evt);
            }
        });
        getContentPane().add(jButton92);
        jButton92.setBounds(210, 170, 45, 45);

        jButton93.setBackground(new java.awt.Color(5, 120, 5));
        jButton93.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton93MousePressed(evt);
            }
        });
        getContentPane().add(jButton93);
        jButton93.setBounds(260, 170, 45, 45);

        jButton101.setBackground(new java.awt.Color(5, 120, 5));
        jButton101.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton101MousePressed(evt);
            }
        });
        getContentPane().add(jButton101);
        jButton101.setBounds(260, 220, 45, 45);

        jButton109.setBackground(new java.awt.Color(5, 120, 5));
        jButton109.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton109.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton109MousePressed(evt);
            }
        });
        getContentPane().add(jButton109);
        jButton109.setBounds(260, 270, 45, 45);

        jButton117.setBackground(new java.awt.Color(5, 120, 5));
        jButton117.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton117.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton117MousePressed(evt);
            }
        });
        getContentPane().add(jButton117);
        jButton117.setBounds(260, 320, 45, 45);

        jButton125.setBackground(new java.awt.Color(5, 120, 5));
        jButton125.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton125MousePressed(evt);
            }
        });
        getContentPane().add(jButton125);
        jButton125.setBounds(260, 370, 45, 45);

        jButton133.setBackground(new java.awt.Color(5, 120, 5));
        jButton133.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton133.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton133MousePressed(evt);
            }
        });
        getContentPane().add(jButton133);
        jButton133.setBounds(260, 420, 45, 45);

        jButton141.setBackground(new java.awt.Color(5, 120, 5));
        jButton141.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton141.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton141MousePressed(evt);
            }
        });
        getContentPane().add(jButton141);
        jButton141.setBounds(260, 470, 45, 45);

        jButton94.setBackground(new java.awt.Color(5, 120, 5));
        jButton94.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton94MousePressed(evt);
            }
        });
        getContentPane().add(jButton94);
        jButton94.setBounds(310, 170, 45, 45);

        jButton102.setBackground(new java.awt.Color(5, 120, 5));
        jButton102.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton102MousePressed(evt);
            }
        });
        getContentPane().add(jButton102);
        jButton102.setBounds(310, 220, 45, 45);

        jButton110.setBackground(new java.awt.Color(5, 120, 5));
        jButton110.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton110.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton110MousePressed(evt);
            }
        });
        getContentPane().add(jButton110);
        jButton110.setBounds(310, 270, 45, 45);

        jButton118.setBackground(new java.awt.Color(5, 120, 5));
        jButton118.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton118MousePressed(evt);
            }
        });
        getContentPane().add(jButton118);
        jButton118.setBounds(310, 320, 45, 45);

        jButton126.setBackground(new java.awt.Color(5, 120, 5));
        jButton126.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton126.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton126MousePressed(evt);
            }
        });
        getContentPane().add(jButton126);
        jButton126.setBounds(310, 370, 45, 45);

        jButton134.setBackground(new java.awt.Color(5, 120, 5));
        jButton134.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton134.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton134MousePressed(evt);
            }
        });
        getContentPane().add(jButton134);
        jButton134.setBounds(310, 420, 45, 45);

        jButton142.setBackground(new java.awt.Color(5, 120, 5));
        jButton142.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton142.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton142MousePressed(evt);
            }
        });
        getContentPane().add(jButton142);
        jButton142.setBounds(310, 470, 45, 45);

        jButton95.setBackground(new java.awt.Color(5, 120, 5));
        jButton95.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton95.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton95MousePressed(evt);
            }
        });
        getContentPane().add(jButton95);
        jButton95.setBounds(360, 170, 45, 45);

        jButton103.setBackground(new java.awt.Color(5, 120, 5));
        jButton103.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton103MousePressed(evt);
            }
        });
        getContentPane().add(jButton103);
        jButton103.setBounds(360, 220, 45, 45);

        jButton111.setBackground(new java.awt.Color(5, 120, 5));
        jButton111.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton111.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton111MousePressed(evt);
            }
        });
        getContentPane().add(jButton111);
        jButton111.setBounds(360, 270, 45, 45);

        jButton119.setBackground(new java.awt.Color(5, 120, 5));
        jButton119.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton119MousePressed(evt);
            }
        });
        getContentPane().add(jButton119);
        jButton119.setBounds(360, 320, 45, 45);

        jButton127.setBackground(new java.awt.Color(5, 120, 5));
        jButton127.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton127.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton127MousePressed(evt);
            }
        });
        getContentPane().add(jButton127);
        jButton127.setBounds(360, 370, 45, 45);

        jButton135.setBackground(new java.awt.Color(5, 120, 5));
        jButton135.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton135.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton135MousePressed(evt);
            }
        });
        getContentPane().add(jButton135);
        jButton135.setBounds(360, 420, 45, 45);

        jButton143.setBackground(new java.awt.Color(5, 120, 5));
        jButton143.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton143.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton143MousePressed(evt);
            }
        });
        getContentPane().add(jButton143);
        jButton143.setBounds(360, 470, 45, 45);

        jButton96.setBackground(new java.awt.Color(5, 120, 5));
        jButton96.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton96.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton96MousePressed(evt);
            }
        });
        getContentPane().add(jButton96);
        jButton96.setBounds(410, 170, 45, 45);

        jButton104.setBackground(new java.awt.Color(5, 120, 5));
        jButton104.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton104.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton104MousePressed(evt);
            }
        });
        getContentPane().add(jButton104);
        jButton104.setBounds(410, 220, 45, 45);

        jButton112.setBackground(new java.awt.Color(5, 120, 5));
        jButton112.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton112.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton112MousePressed(evt);
            }
        });
        getContentPane().add(jButton112);
        jButton112.setBounds(410, 270, 45, 45);

        jButton120.setBackground(new java.awt.Color(5, 120, 5));
        jButton120.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton120MousePressed(evt);
            }
        });
        getContentPane().add(jButton120);
        jButton120.setBounds(410, 320, 45, 45);

        jButton128.setBackground(new java.awt.Color(5, 120, 5));
        jButton128.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton128.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton128MousePressed(evt);
            }
        });
        getContentPane().add(jButton128);
        jButton128.setBounds(410, 370, 45, 45);

        jButton136.setBackground(new java.awt.Color(5, 120, 5));
        jButton136.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton136.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton136MousePressed(evt);
            }
        });
        getContentPane().add(jButton136);
        jButton136.setBounds(410, 420, 45, 45);

        jButton144.setBackground(new java.awt.Color(5, 120, 5));
        jButton144.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton144.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton144MousePressed(evt);
            }
        });
        getContentPane().add(jButton144);
        jButton144.setBounds(410, 470, 45, 45);

        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 54, 182));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 204), 1, true));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 50, 50, 30);

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 50, 50, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reversi/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 510, 580);

        jMenu1.setMnemonic('r');
        jMenu1.setText("Game");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItem1.setText("Quit");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Reversy");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem2MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("Help");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton81MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton81MousePressed
       x=0; y=0; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton81MousePressed

    private void jButton110MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton110MousePressed
       x=3; y=5; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();    
    }//GEN-LAST:event_jButton110MousePressed

    private void jButton100MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton100MousePressed
       x=2; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton100MousePressed

    private void jButton82MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton82MousePressed
       x=0; y=1; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton82MousePressed

    private void jButton83MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton83MousePressed
       x=0; y=2; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton83MousePressed

    private void jButton84MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton84MousePressed
       x=0; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton84MousePressed

    private void jButton85MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton85MousePressed
       x=0; y=4;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton85MousePressed

    private void jButton86MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton86MousePressed
       x=0; y=5; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton86MousePressed

    private void jButton87MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton87MousePressed
        x=0; y=6; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton87MousePressed

    private void jButton88MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton88MousePressed
        x=0; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton88MousePressed

    private void jButton89MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton89MousePressed
        x=1; y=0; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton89MousePressed

    private void jButton90MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton90MousePressed
        x=1; y=1; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton90MousePressed

    private void jButton91MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton91MousePressed
         x=1; y=2; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton91MousePressed

    private void jButton92MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton92MousePressed
         x=1; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton92MousePressed

    private void jButton93MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton93MousePressed
         x=1; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton93MousePressed

    private void jButton94MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton94MousePressed
         x=1; y=5; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton94MousePressed

    private void jButton95MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton95MousePressed
         x=1; y=6; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton95MousePressed

    private void jButton96MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton96MousePressed
         x=1; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton96MousePressed

    private void jButton97MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton97MousePressed
         x=2; y=0; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton97MousePressed

    private void jButton98MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton98MousePressed
        x=2; y=1; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton98MousePressed

    private void jButton99MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton99MousePressed
        x=2; y=2;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton99MousePressed

    private void jButton101MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton101MousePressed
        x=2; y=4;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton101MousePressed

    private void jButton102MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton102MousePressed
        x=2; y=5;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
        
    }//GEN-LAST:event_jButton102MousePressed

    private void jButton103MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton103MousePressed
        x=2; y=6; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton103MousePressed

    private void jButton104MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton104MousePressed
        x=2; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton104MousePressed

    private void jButton105MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton105MousePressed
        x=3; y=0;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton105MousePressed

    private void jButton106MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton106MousePressed
        x=3; y=1;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton106MousePressed

    private void jButton107MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton107MousePressed
       x=3; y=2; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton107MousePressed

    private void jButton108MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton108MousePressed
       x=3; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton108MousePressed

    private void jButton109MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton109MousePressed
       x=3; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton109MousePressed

    private void jButton111MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton111MousePressed
       x=3; y=6;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton111MousePressed

    private void jButton112MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton112MousePressed
       x=3; y=7;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton112MousePressed

    private void jButton113MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton113MousePressed
       x=4; y=0;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton113MousePressed

    private void jButton114MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton114MousePressed
       x=4; y=1;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton114MousePressed

    private void jButton115MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton115MousePressed
       x=4; y=2; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton115MousePressed

    private void jButton116MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton116MousePressed
       x=4; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton116MousePressed

    private void jButton117MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton117MousePressed
       x=4; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton117MousePressed

    private void jButton118MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton118MousePressed
       x=4; y=5;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton118MousePressed

    private void jButton119MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton119MousePressed
       x=4; y=6;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton119MousePressed

    private void jButton120MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton120MousePressed
        x=4; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador();  
    }//GEN-LAST:event_jButton120MousePressed

    private void jButton121MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton121MousePressed
       x=5; y=0;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton121MousePressed

    private void jButton122MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton122MousePressed
        x=5; y=1;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton122MousePressed

    private void jButton123MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton123MousePressed
        x=5; y=2;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton123MousePressed

    private void jButton124MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton124MousePressed
       x=5; y=3;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton124MousePressed

    private void jButton125MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton125MousePressed
        x=5; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton125MousePressed

    private void jButton126MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton126MousePressed
         x=5; y=5;DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton126MousePressed

    private void jButton127MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton127MousePressed
        x=5; y=6;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton127MousePressed

    private void jButton128MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton128MousePressed
        x=5; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton128MousePressed

    private void jButton129MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton129MousePressed
        x=6; y=0; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton129MousePressed

    private void jButton130MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton130MousePressed
         x=6; y=1; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton130MousePressed

    private void jButton131MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton131MousePressed
         x=6; y=2;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton131MousePressed

    private void jButton132MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton132MousePressed
        x=6; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton132MousePressed

    private void jButton133MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton133MousePressed
       x=6; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton133MousePressed

    private void jButton134MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton134MousePressed
       x=6; y=5;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton134MousePressed

    private void jButton135MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton135MousePressed
       x=6; y=6;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton135MousePressed

    private void jButton136MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton136MousePressed
        x=6; y=7;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton136MousePressed

    private void jButton137MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton137MousePressed
        x=7; y=0; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton137MousePressed

    private void jButton138MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton138MousePressed
        x=7; y=1;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton138MousePressed

    private void jButton139MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton139MousePressed
        x=7; y=2;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton139MousePressed

    private void jButton140MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton140MousePressed
        x=7; y=3; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton140MousePressed

    private void jButton141MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton141MousePressed
        x=7; y=4; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton141MousePressed

    private void jButton142MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton142MousePressed
        x=7; y=5;  DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno();ComprobarGanador(); 
    }//GEN-LAST:event_jButton142MousePressed

    private void jButton143MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton143MousePressed
        x=7; y=6; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton143MousePressed

    private void jButton144MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton144MousePressed
        x=7; y=7; DefinirMovimiento();ActualizarMatriz();MostrarResultados();CambiarTurno(); ComprobarGanador(); 
    }//GEN-LAST:event_jButton144MousePressed

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jMenuItem2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MousePressed
        JOptionPane.showMessageDialog(null,
        "  Desarrollador Reversi:\n" +
        " Yuliana Murillo Hurtado\n" +
        "Ing. Sistemas Computacionales\n" +
        "  Universidad de Guanajuato",
        "About Reversi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem2MousePressed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
        JOptionPane.showMessageDialog(null,
        "**INSTRUCCIONES REVERSI**\n" +
        "- Inicia el jugador Rosa\n" +
        "- Solo es un turno a la ves por cada jugador\n" +
        "- Se pueden rellenar filas horizontales, verticales y en diagonal\n" +
        "- No se pueden colocar fichas en lugares ya ocupados"+
        "- Al final gana el jugador con mas fichas a su favor",
        "About Reversi", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jButton82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton82ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton82ActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
            public void run() { new AreaJuego().setVisible(true);} });
        
      AreaJuego AJ = new AreaJuego();
      AJ.InicializarMatriz();
              
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton100;
    private javax.swing.JButton jButton101;
    private javax.swing.JButton jButton102;
    private javax.swing.JButton jButton103;
    private javax.swing.JButton jButton104;
    private javax.swing.JButton jButton105;
    private javax.swing.JButton jButton106;
    private javax.swing.JButton jButton107;
    private javax.swing.JButton jButton108;
    private javax.swing.JButton jButton109;
    private javax.swing.JButton jButton110;
    private javax.swing.JButton jButton111;
    private javax.swing.JButton jButton112;
    private javax.swing.JButton jButton113;
    private javax.swing.JButton jButton114;
    private javax.swing.JButton jButton115;
    private javax.swing.JButton jButton116;
    private javax.swing.JButton jButton117;
    private javax.swing.JButton jButton118;
    private javax.swing.JButton jButton119;
    private javax.swing.JButton jButton120;
    private javax.swing.JButton jButton121;
    private javax.swing.JButton jButton122;
    private javax.swing.JButton jButton123;
    private javax.swing.JButton jButton124;
    private javax.swing.JButton jButton125;
    private javax.swing.JButton jButton126;
    private javax.swing.JButton jButton127;
    private javax.swing.JButton jButton128;
    private javax.swing.JButton jButton129;
    private javax.swing.JButton jButton130;
    private javax.swing.JButton jButton131;
    private javax.swing.JButton jButton132;
    private javax.swing.JButton jButton133;
    private javax.swing.JButton jButton134;
    private javax.swing.JButton jButton135;
    private javax.swing.JButton jButton136;
    private javax.swing.JButton jButton137;
    private javax.swing.JButton jButton138;
    private javax.swing.JButton jButton139;
    private javax.swing.JButton jButton140;
    private javax.swing.JButton jButton141;
    private javax.swing.JButton jButton142;
    private javax.swing.JButton jButton143;
    private javax.swing.JButton jButton144;
    private javax.swing.JButton jButton81;
    private javax.swing.JButton jButton82;
    private javax.swing.JButton jButton83;
    private javax.swing.JButton jButton84;
    private javax.swing.JButton jButton85;
    private javax.swing.JButton jButton86;
    private javax.swing.JButton jButton87;
    private javax.swing.JButton jButton88;
    private javax.swing.JButton jButton89;
    private javax.swing.JButton jButton90;
    private javax.swing.JButton jButton91;
    private javax.swing.JButton jButton92;
    private javax.swing.JButton jButton93;
    private javax.swing.JButton jButton94;
    private javax.swing.JButton jButton95;
    private javax.swing.JButton jButton96;
    private javax.swing.JButton jButton97;
    private javax.swing.JButton jButton98;
    private javax.swing.JButton jButton99;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}











