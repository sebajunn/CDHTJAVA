/*     */ import java.io.BufferedReader;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.net.UnknownHostException;
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
/*     */ public class DHT$UDP_PING_Server
/*     */   extends Thread
/*     */ {
/* 186 */   public int incomingP = -1;
/* 187 */   public int incomingN = -1;
/* 188 */   public String request = new String("request");
/* 189 */   public String response = new String("response");
/* 190 */   public String operationCode = new String();
/*     */   
/*     */   public DHT$UDP_PING_Server(DHT this$0) {}
/*     */   
/*     */   public void run() {
/* 195 */     while ((!this.this$0.confirm1) || (!this.this$0.confirm2) || (!this.this$0.confirm3) || (!this.this$0.confirm4)) {
/* 196 */       InetAddress serverAddress = null;
/*     */       try {
/* 198 */         serverAddress = InetAddress.getLocalHost();
/*     */       } catch (UnknownHostException localUnknownHostException) {}
/* 200 */       InetAddress clientAddress = null;
/* 201 */       String serverMessage = null;
/*     */       
/* 203 */       DatagramPacket serverListen = new DatagramPacket(new byte['Ѐ'], 1024);
/*     */       try {
/* 205 */         this.this$0.udpServerSocket.receive(serverListen);
/* 206 */         clientAddress = serverListen.getAddress();
/* 207 */         this.incomingP = serverListen.getPort();
/* 208 */         this.incomingN = (this.incomingP - 50000);
/* 209 */         int i = 77;int j = i - 1;int k = i * j;k %= 2; if (((k < 0 ^ true) & true)) i = 35; String incomingSeq = M240536415(serverListen, this.incomingN, i);
/* 210 */         if (this.operationCode.equals(this.request)) {
/* 211 */           System.out.println("A ping request message was received from Peer " + this.incomingN + ".");
/* 212 */           int m = 7;int n = m - 1;int i1 = m * n;i1 %= 2; if (((i1 < 0 ^ true) & true)) m = 8; M637417425(this.incomingN, m);
/* 213 */           serverMessage = incomingSeq + ":" + this.response + ":end";
/* 214 */           byte[] serverData = serverMessage.getBytes();
/*     */           
/* 216 */           DatagramPacket echoReply = new DatagramPacket(serverData, serverData.length, clientAddress, this.incomingP);
/*     */           try {
/* 218 */             this.this$0.udpServerSocket.send(echoReply);
/*     */           } catch (IOException localIOException) {}
/*     */         }
/* 221 */         if (this.operationCode.equals(this.response)) {
/* 222 */           System.out.println("A ping response message was received from Peer " + this.incomingN + ".");
/* 223 */           if (this.incomingN == this.this$0.successor1) {
/* 224 */             this.this$0.successorLost1 = 0;
/* 225 */             this.this$0.successorLost2 += 1;
/*     */           }
/* 227 */           else if (this.incomingN == this.this$0.successor2) {
/* 228 */             this.this$0.successorLost2 = 0;
/* 229 */             this.this$0.successorLost1 += 1;
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (Exception localException) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 239 */       if (this.this$0.successorLost1 == 6) {
/* 240 */         this.this$0.successorFull = false;
/* 241 */         System.out.println("Peer " + this.this$0.successor1 + " is no longer alive.");
/* 242 */         this.this$0.successor1 = this.this$0.successor2;
/* 243 */         System.out.println("My first successor is now peer " + this.this$0.successor1 + ".");
/*     */         
/* 245 */         Socket peerfindingSocket = null;
/*     */         try {
/* 247 */           peerfindingSocket = new Socket(serverAddress, this.this$0.successor1 + 50000);
/*     */         } catch (IOException localIOException1) {}
/* 249 */         DataOutputStream outToServer = null;
/*     */         try {
/* 251 */           outToServer = new DataOutputStream(peerfindingSocket.getOutputStream());
/*     */         }
/*     */         catch (IOException localIOException2) {}
/*     */         
/*     */ 
/* 256 */         String sentSentence1 = "requiresuccessor1:" + Integer.toString(this.this$0.peerN) + ":" + Integer.toString(DHT.predecessor1) + ":end";
/*     */         try
/*     */         {
/* 259 */           outToServer.writeBytes(sentSentence1);
/*     */         } catch (IOException localIOException3) {}
/*     */         try {
/* 262 */           peerfindingSocket.close();
/*     */         } catch (IOException localIOException4) {}
/* 264 */         this.this$0.successorLost1 = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public String M240536415(DatagramPacket echoRequest, int peerN, byte arg3) throws Exception
/*     */   {
/* 271 */     echoReplyData = echoRequest.getData();
/*     */     
/* 273 */     ByteArrayInputStream baisData = new ByteArrayInputStream(echoReplyData);
/*     */     
/* 275 */     InputStreamReader isrData = new InputStreamReader(baisData);
/*     */     
/* 277 */     BufferedReader fromClientData = new BufferedReader(isrData);
/* 278 */     String sentence = fromClientData.readLine();
/* 279 */     String[] splitSentence = sentence.split(":");
/* 280 */     this.operationCode = splitSentence[1];
/* 281 */     return splitSentence[0];
/*     */   }
/*     */   
/*     */   public void M637417425(int clientN, byte paramByte) {
/* 285 */     if (clientN != -1) {
/* 286 */       if ((DHT.predecessor1 == -1) && (DHT.predecessor2 == -1)) {
/* 287 */         DHT.predecessor1 = clientN;
/* 288 */       } else if ((DHT.predecessor1 != -1) && (DHT.predecessor2 == -1) && (DHT.predecessor1 != clientN)) {
/* 289 */         DHT.predecessor2 = clientN;
/* 290 */       } else if ((DHT.predecessor1 == -1) && (DHT.predecessor2 != -1) && (DHT.predecessor2 != clientN))
/* 291 */         DHT.predecessor1 = clientN;
/*     */     }
/* 293 */     if ((DHT.predecessor1 >= 0) && (DHT.predecessor2 >= 0) && (this.this$0.successor1 >= 0) && (this.this$0.successor2 >= 0)) {
/* 294 */       this.this$0.predecessorFull = true;
/* 295 */       int i = 112;int j = i - 1;int k = i * j;k %= 2; if (((k < 0 ^ true) & true)) i = 15; M550437005(i);
/*     */     }
/*     */   }
/*     */   
/*     */   public void M550437005(byte arg1) {
/* 300 */     if ((DHT.predecessor1 > this.this$0.peerN) && (DHT.predecessor2 > this.this$0.peerN)) {
/* 301 */       this.this$0.firstNode = true;
/* 302 */       if (DHT.predecessor1 < DHT.predecessor2)
/*     */       {
/* 304 */         temp = DHT.predecessor2;
/* 305 */         DHT.predecessor2 = DHT.predecessor1;
/* 306 */         DHT.predecessor1 = temp;
/*     */       }
/*     */     }
/* 309 */     else if (((DHT.predecessor1 > this.this$0.peerN) && (DHT.predecessor2 < this.this$0.peerN)) || ((DHT.predecessor1 < this.this$0.peerN) && (DHT.predecessor2 > this.this$0.peerN))) {
/* 310 */       this.this$0.secondNode = true;
/* 311 */       if (DHT.predecessor1 > DHT.predecessor2)
/*     */       {
/* 313 */         int temp = DHT.predecessor2;
/* 314 */         DHT.predecessor2 = DHT.predecessor1;
/* 315 */         DHT.predecessor1 = temp;
/*     */       }
/*     */       
/*     */     }
/* 319 */     else if (DHT.predecessor1 < DHT.predecessor2)
/*     */     {
/* 321 */       int temp = DHT.predecessor2;
/* 322 */       DHT.predecessor2 = DHT.predecessor1;
/* 323 */       DHT.predecessor1 = temp;
/*     */     }
/*     */     
/* 326 */     if ((this.this$0.successor1 < this.this$0.peerN) && (this.this$0.successor2 < this.this$0.peerN)) {
/* 327 */       this.this$0.lastNode = true;
/* 328 */       if (this.this$0.successor1 > this.this$0.successor2)
/*     */       {
/* 330 */         int temp = this.this$0.successor2;
/* 331 */         this.this$0.successor2 = this.this$0.successor1;
/* 332 */         this.this$0.successor1 = temp;
/*     */       }
/*     */     }
/* 335 */     else if (((this.this$0.successor1 < this.this$0.peerN) && (this.this$0.successor2 > this.this$0.peerN)) || ((this.this$0.successor2 < this.this$0.peerN) && (this.this$0.successor1 > this.this$0.peerN))) {
/* 336 */       this.this$0.penultimateNode = true;
/* 337 */       if (this.this$0.successor1 < this.this$0.successor2)
/*     */       {
/* 339 */         int temp = this.this$0.successor2;
/* 340 */         this.this$0.successor2 = this.this$0.successor1;
/* 341 */         this.this$0.successor1 = temp;
/*     */       }
/*     */       
/*     */     }
/* 345 */     else if (this.this$0.successor1 > this.this$0.successor2)
/*     */     {
/* 347 */       int temp = this.this$0.successor2;
/* 348 */       this.this$0.successor2 = this.this$0.successor1;
/* 349 */       this.this$0.successor1 = temp;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\DHT$UDP_PING_Server.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */