/*     */ import java.io.IOException;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.SocketException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class cdht
/*     */ {
/*     */   public static int peerN;
/* 101 */   public static int successor1 = 0;
/* 102 */   public static int successor2 = 0;
/*     */   
/*     */   public static void main(String[] args) throws SocketException {
/* 105 */     peerN = Integer.parseInt(args[0]);
/* 106 */     successor1 = Integer.parseInt(args[1]);
/* 107 */     successor2 = Integer.parseInt(args[2]);
/* 108 */     DatagramSocket udpServerSocket = new DatagramSocket(50000 + peerN);
/*     */     
/* 110 */     udpServerSocket.setSoTimeout(8000);
/* 111 */     ServerSocket tcpServerSocket = null;
/*     */     try {
/* 113 */       tcpServerSocket = new ServerSocket(50000 + peerN);
/*     */     }
/*     */     catch (IOException localIOException) {}
/* 116 */     DHT newDHT = new DHT(peerN, successor1, successor2, udpServerSocket, tcpServerSocket);
/* 117 */     newDHT.start();
/*     */   }
/*     */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\cdht.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */