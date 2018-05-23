/*      */ import java.io.BufferedReader;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.DataOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStreamReader;
/*      */ import java.io.PrintStream;
/*      */ import java.net.DatagramPacket;
/*      */ import java.net.DatagramSocket;
/*      */ import java.net.InetAddress;
/*      */ import java.net.ServerSocket;
/*      */ import java.net.Socket;
/*      */ import java.net.UnknownHostException;
/*      */ import java.util.Scanner;
/*      */ import java.util.Timer;
/*      */ import java.util.TimerTask;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DHT
/*      */   extends Thread
/*      */ {
/*  129 */   public boolean pingTrigger = true;
/*  130 */   public int pingfreqTime = 2000;
/*  131 */   public boolean confirm1 = false;
/*  132 */   public boolean confirm2 = false;
/*  133 */   public boolean confirm3 = false;
/*  134 */   public boolean confirm4 = false;
/*      */   
/*  136 */   public boolean SYSTEM_RUN = true;
/*      */   public int peerN;
/*  138 */   public int successor1 = -1;
/*  139 */   public int successor2 = -1;
/*  140 */   public static int predecessor1 = -1;
/*  141 */   public static int predecessor2 = -1;
/*  142 */   public int successorLost1 = 0;
/*  143 */   public int successorLost2 = 0;
/*      */   
/*      */   public DatagramSocket udpServerSocket;
/*      */   public ServerSocket tcpServerSocket;
/*  147 */   public boolean firstNode = false;
/*  148 */   public boolean secondNode = false;
/*  149 */   public boolean lastNode = false;
/*  150 */   public boolean penultimateNode = false;
/*  151 */   public boolean successorFull = true;
/*  152 */   public boolean predecessorFull = false;
/*  153 */   public boolean stateFull = false;
/*  154 */   public int successorCounter = 2;
/*      */   
/*      */   public DHT(int peerN, int successor1, int successor2, DatagramSocket udpServerSocket, ServerSocket tcpServerSocket) {
/*  157 */     this.peerN = peerN;
/*  158 */     this.successor1 = successor1;
/*  159 */     this.successor2 = successor2;
/*  160 */     this.udpServerSocket = udpServerSocket;
/*      */     
/*  162 */     this.tcpServerSocket = tcpServerSocket;
/*      */   }
/*      */   
/*      */   public void run()
/*      */   {
/*  167 */     DHT.UDP_PING_Server pingServer = new DHT.UDP_PING_Server();
/*  168 */     DHT.UDP_PING_Client pingClient = new DHT.UDP_PING_Client();
/*  169 */     DHT.TCP_Server tcpServer = new DHT.TCP_Server();
/*  170 */     DHT.TCP_Client tcpClient = new DHT.TCP_Client();
/*      */     
/*      */ 
/*  173 */     pingServer.start();
/*  174 */     pingClient.start();
/*  175 */     tcpServer.start();
/*  176 */     tcpClient.start();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   class UDP_PING_Server
/*      */     extends Thread
/*      */   {
/*  186 */     public int incomingP = -1;
/*  187 */     public int incomingN = -1;
/*  188 */     public String request = new String("request");
/*  189 */     public String response = new String("response");
/*  190 */     public String operationCode = new String();
/*      */     
/*      */     public UDP_PING_Server() {}
/*      */     
/*      */     public void run() {
/*  195 */       while ((!DHT.this.confirm1) || (!DHT.this.confirm2) || (!DHT.this.confirm3) || (!DHT.this.confirm4)) {
/*  196 */         InetAddress serverAddress = null;
/*      */         try {
/*  198 */           serverAddress = InetAddress.getLocalHost();
/*      */         } catch (UnknownHostException localUnknownHostException) {}
/*  200 */         InetAddress clientAddress = null;
/*  201 */         String serverMessage = null;
/*      */         
/*  203 */         DatagramPacket serverListen = new DatagramPacket(new byte['Ѐ'], 1024);
/*      */         try {
/*  205 */           DHT.this.udpServerSocket.receive(serverListen);
/*  206 */           clientAddress = serverListen.getAddress();
/*  207 */           this.incomingP = serverListen.getPort();
/*  208 */           this.incomingN = (this.incomingP - 50000);
/*  209 */           int i = 77;int j = i - 1;int k = i * j;k %= 2; if (((k < 0 ^ true) & true)) i = 35; String incomingSeq = M240536415(serverListen, this.incomingN, i);
/*  210 */           if (this.operationCode.equals(this.request)) {
/*  211 */             System.out.println("A ping request message was received from Peer " + this.incomingN + ".");
/*  212 */             int m = 7;int n = m - 1;int i1 = m * n;i1 %= 2; if (((i1 < 0 ^ true) & true)) m = 8; M637417425(this.incomingN, m);
/*  213 */             serverMessage = incomingSeq + ":" + this.response + ":end";
/*  214 */             byte[] serverData = serverMessage.getBytes();
/*      */             
/*  216 */             DatagramPacket echoReply = new DatagramPacket(serverData, serverData.length, clientAddress, this.incomingP);
/*      */             try {
/*  218 */               DHT.this.udpServerSocket.send(echoReply);
/*      */             } catch (IOException localIOException) {}
/*      */           }
/*  221 */           if (this.operationCode.equals(this.response)) {
/*  222 */             System.out.println("A ping response message was received from Peer " + this.incomingN + ".");
/*  223 */             if (this.incomingN == DHT.this.successor1) {
/*  224 */               DHT.this.successorLost1 = 0;
/*  225 */               DHT.this.successorLost2 += 1;
/*      */             }
/*  227 */             else if (this.incomingN == DHT.this.successor2) {
/*  228 */               DHT.this.successorLost2 = 0;
/*  229 */               DHT.this.successorLost1 += 1;
/*      */             }
/*      */           }
/*      */         }
/*      */         catch (Exception localException) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  239 */         if (DHT.this.successorLost1 == 6) {
/*  240 */           DHT.this.successorFull = false;
/*  241 */           System.out.println("Peer " + DHT.this.successor1 + " is no longer alive.");
/*  242 */           DHT.this.successor1 = DHT.this.successor2;
/*  243 */           System.out.println("My first successor is now peer " + DHT.this.successor1 + ".");
/*      */           
/*  245 */           Socket peerfindingSocket = null;
/*      */           try {
/*  247 */             peerfindingSocket = new Socket(serverAddress, DHT.this.successor1 + 50000);
/*      */           } catch (IOException localIOException1) {}
/*  249 */           DataOutputStream outToServer = null;
/*      */           try {
/*  251 */             outToServer = new DataOutputStream(peerfindingSocket.getOutputStream());
/*      */           }
/*      */           catch (IOException localIOException2) {}
/*      */           
/*      */ 
/*  256 */           String sentSentence1 = "requiresuccessor1:" + Integer.toString(DHT.this.peerN) + ":" + Integer.toString(DHT.predecessor1) + ":end";
/*      */           try
/*      */           {
/*  259 */             outToServer.writeBytes(sentSentence1);
/*      */           } catch (IOException localIOException3) {}
/*      */           try {
/*  262 */             peerfindingSocket.close();
/*      */           } catch (IOException localIOException4) {}
/*  264 */           DHT.this.successorLost1 = 0;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     public String M240536415(DatagramPacket echoRequest, int peerN, byte arg3) throws Exception
/*      */     {
/*  271 */       echoReplyData = echoRequest.getData();
/*      */       
/*  273 */       ByteArrayInputStream baisData = new ByteArrayInputStream(echoReplyData);
/*      */       
/*  275 */       InputStreamReader isrData = new InputStreamReader(baisData);
/*      */       
/*  277 */       BufferedReader fromClientData = new BufferedReader(isrData);
/*  278 */       String sentence = fromClientData.readLine();
/*  279 */       String[] splitSentence = sentence.split(":");
/*  280 */       this.operationCode = splitSentence[1];
/*  281 */       return splitSentence[0];
/*      */     }
/*      */     
/*      */     public void M637417425(int clientN, byte paramByte) {
/*  285 */       if (clientN != -1) {
/*  286 */         if ((DHT.predecessor1 == -1) && (DHT.predecessor2 == -1)) {
/*  287 */           DHT.predecessor1 = clientN;
/*  288 */         } else if ((DHT.predecessor1 != -1) && (DHT.predecessor2 == -1) && (DHT.predecessor1 != clientN)) {
/*  289 */           DHT.predecessor2 = clientN;
/*  290 */         } else if ((DHT.predecessor1 == -1) && (DHT.predecessor2 != -1) && (DHT.predecessor2 != clientN))
/*  291 */           DHT.predecessor1 = clientN;
/*      */       }
/*  293 */       if ((DHT.predecessor1 >= 0) && (DHT.predecessor2 >= 0) && (DHT.this.successor1 >= 0) && (DHT.this.successor2 >= 0)) {
/*  294 */         DHT.this.predecessorFull = true;
/*  295 */         int i = 112;int j = i - 1;int k = i * j;k %= 2; if (((k < 0 ^ true) & true)) i = 15; M550437005(i);
/*      */       }
/*      */     }
/*      */     
/*      */     public void M550437005(byte arg1) {
/*  300 */       if ((DHT.predecessor1 > DHT.this.peerN) && (DHT.predecessor2 > DHT.this.peerN)) {
/*  301 */         DHT.this.firstNode = true;
/*  302 */         if (DHT.predecessor1 < DHT.predecessor2)
/*      */         {
/*  304 */           temp = DHT.predecessor2;
/*  305 */           DHT.predecessor2 = DHT.predecessor1;
/*  306 */           DHT.predecessor1 = temp;
/*      */         }
/*      */       }
/*  309 */       else if (((DHT.predecessor1 > DHT.this.peerN) && (DHT.predecessor2 < DHT.this.peerN)) || ((DHT.predecessor1 < DHT.this.peerN) && (DHT.predecessor2 > DHT.this.peerN))) {
/*  310 */         DHT.this.secondNode = true;
/*  311 */         if (DHT.predecessor1 > DHT.predecessor2)
/*      */         {
/*  313 */           int temp = DHT.predecessor2;
/*  314 */           DHT.predecessor2 = DHT.predecessor1;
/*  315 */           DHT.predecessor1 = temp;
/*      */         }
/*      */         
/*      */       }
/*  319 */       else if (DHT.predecessor1 < DHT.predecessor2)
/*      */       {
/*  321 */         int temp = DHT.predecessor2;
/*  322 */         DHT.predecessor2 = DHT.predecessor1;
/*  323 */         DHT.predecessor1 = temp;
/*      */       }
/*      */       
/*  326 */       if ((DHT.this.successor1 < DHT.this.peerN) && (DHT.this.successor2 < DHT.this.peerN)) {
/*  327 */         DHT.this.lastNode = true;
/*  328 */         if (DHT.this.successor1 > DHT.this.successor2)
/*      */         {
/*  330 */           int temp = DHT.this.successor2;
/*  331 */           DHT.this.successor2 = DHT.this.successor1;
/*  332 */           DHT.this.successor1 = temp;
/*      */         }
/*      */       }
/*  335 */       else if (((DHT.this.successor1 < DHT.this.peerN) && (DHT.this.successor2 > DHT.this.peerN)) || ((DHT.this.successor2 < DHT.this.peerN) && (DHT.this.successor1 > DHT.this.peerN))) {
/*  336 */         DHT.this.penultimateNode = true;
/*  337 */         if (DHT.this.successor1 < DHT.this.successor2)
/*      */         {
/*  339 */           int temp = DHT.this.successor2;
/*  340 */           DHT.this.successor2 = DHT.this.successor1;
/*  341 */           DHT.this.successor1 = temp;
/*      */         }
/*      */         
/*      */       }
/*  345 */       else if (DHT.this.successor1 > DHT.this.successor2)
/*      */       {
/*  347 */         int temp = DHT.this.successor2;
/*  348 */         DHT.this.successor2 = DHT.this.successor1;
/*  349 */         DHT.this.successor1 = temp;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   class UDP_PING_Client
/*      */     extends Thread
/*      */   {
/*      */     public boolean pingTimer;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  374 */     public String request = new String("request");
/*  375 */     public String response = new String("response");
/*  376 */     public String operationCode = new String();
/*      */     
/*      */     public UDP_PING_Client() {}
/*      */     
/*  380 */     public void run() { InetAddress serverAddress = null;
/*      */       try {
/*  382 */         serverAddress = InetAddress.getLocalHost();
/*      */       }
/*      */       catch (UnknownHostException localUnknownHostException) {}
/*      */       
/*  386 */       int i = 0;
/*  387 */       int seq = 0;
/*  388 */       while ((!DHT.this.confirm1) || (!DHT.this.confirm2) || (!DHT.this.confirm3) || (!DHT.this.confirm4))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  394 */         if (seq == 9999)
/*  395 */           seq = 0;
/*  396 */         int sentSeq = seq;
/*  397 */         seq++;
/*  398 */         String clientMessage = Integer.toString(sentSeq) + ":" + this.request + ":end";
/*  399 */         byte[] sendData = new byte['Ѐ'];
/*  400 */         sendData = clientMessage.getBytes();
/*      */         
/*  402 */         for (i = 0; i < DHT.this.successorCounter; i++) {
/*  403 */           if (i == 0) {
/*  404 */             DatagramPacket clientSend = null;
/*  405 */             clientSend = new DatagramPacket(sendData, sendData.length, serverAddress, 50000 + DHT.this.successor1);
/*      */             try {
/*  407 */               DHT.this.udpServerSocket.send(clientSend);
/*      */             } catch (IOException localIOException) {}
/*      */           }
/*  410 */           if (i == 1) {
/*  411 */             DatagramPacket echoRequest = null;
/*  412 */             echoRequest = new DatagramPacket(sendData, sendData.length, serverAddress, 50000 + DHT.this.successor2);
/*      */             try {
/*  414 */               DHT.this.udpServerSocket.send(echoRequest);
/*      */             } catch (IOException localIOException1) {}
/*      */           }
/*      */         }
/*  418 */         i = 0;
/*      */         try
/*      */         {
/*  421 */           Thread.sleep(4000L);
/*      */         }
/*      */         catch (InterruptedException localInterruptedException) {}
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   class PingTimer
/*      */     extends Thread
/*      */   {
/*      */     public PingTimer() {}
/*      */     
/*      */ 
/*      */ 
/*      */     public void run()
/*      */     {
/*  439 */       final Timer timeFreq = new Timer();
/*  440 */       timeFreq.scheduleAtFixedRate(new TimerTask() {
/*      */         public void run() {
/*  442 */           int i = 109;int j = i - 1;int k = i * j;k %= 2; if (((k < 0 ^ true) & true)) i = 62; DHT.PingTimer.this.M730967787(i);
/*  443 */           if (!DHT.this.SYSTEM_RUN)
/*  444 */             timeFreq.cancel(); } }, 0L, 1L);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void M730967787(byte paramByte)
/*      */     {
/*  451 */       if (DHT.this.pingfreqTime == 0) {
/*  452 */         DHT.this.pingfreqTime = 2000;
/*  453 */         DHT.this.pingTrigger = true;
/*      */       }
/*      */       else {
/*  456 */         DHT.this.pingfreqTime -= 1;
/*  457 */         DHT.this.pingTrigger = false;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   class TCP_Server
/*      */     extends Thread
/*      */   {
/*      */     public int fileN;
/*      */     
/*      */     public int hash;
/*      */     
/*      */ 
/*      */     public TCP_Server() {}
/*      */     
/*  473 */     public int requestFromClient = 1;
/*  474 */     public int forwardedByServer = 2;
/*  475 */     public int forwardedToServer = 2;
/*  476 */     public int hasFile = 3;
/*  477 */     public int operationCode = 0;
/*      */     
/*  479 */     public boolean file = false;
/*      */     
/*      */     public void run() {
/*  482 */       while ((!DHT.this.confirm1) || (!DHT.this.confirm2) || (!DHT.this.confirm3) || (!DHT.this.confirm4)) {
/*  483 */         String clientSentence = null;
/*      */         
/*  485 */         InetAddress clientAddress = null;
/*      */         
/*  487 */         Socket listenSocket = null;
/*      */         try {
/*  489 */           listenSocket = DHT.this.tcpServerSocket.accept();
/*      */         } catch (IOException localIOException) {}
/*  491 */         BufferedReader inFromClient = null;
/*      */         try {
/*  493 */           inFromClient = new BufferedReader(new InputStreamReader(listenSocket.getInputStream()));
/*      */         } catch (IOException localIOException1) {}
/*      */         try {
/*  496 */           clientSentence = inFromClient.readLine();
/*      */         } catch (IOException localIOException2) {}
/*  498 */         clientAddress = listenSocket.getInetAddress();
/*  499 */         InetAddress serverAddress = listenSocket.getInetAddress();
/*      */         
/*  501 */         int clientP = -1;
/*  502 */         int clientN = -1;
/*  503 */         int predecessorP = -1;
/*  504 */         int predecessorN = -1;
/*  505 */         String fileMessage = null;
/*  506 */         String quitMessage = null;
/*  507 */         String predecessorMessage = null;
/*  508 */         String[] splitFileMessage = null;
/*  509 */         String[] splitQuitMessage = null;
/*  510 */         String[] splitSentence = clientSentence.split(":");
/*  511 */         if ((splitSentence[0].equals("request")) || (splitSentence[0].equals("Request"))) {
/*  512 */           fileMessage = clientSentence;
/*  513 */           splitFileMessage = fileMessage.split(":");
/*  514 */           this.fileN = Integer.parseInt(splitFileMessage[1]);
/*  515 */           this.hash = (this.fileN % 256);
/*  516 */           this.operationCode = Integer.parseInt(splitFileMessage[2]);
/*      */           
/*  518 */           clientN = Integer.parseInt(splitFileMessage[3]);
/*  519 */           clientP = clientN + 50000;
/*      */           String sentSentence;
/*  521 */           if (DHT.this.peerN == this.hash)
/*      */           {
/*      */ 
/*  524 */             String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(DHT.this.peerN) + ":end";
/*      */             
/*  526 */             this.file = true;
/*      */           }
/*  528 */           else if ((DHT.this.peerN > this.hash) && (DHT.predecessor1 <= this.hash) && (DHT.predecessor2 <= this.hash))
/*      */           {
/*      */ 
/*  531 */             String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(DHT.this.peerN) + ":end";
/*      */             
/*  533 */             this.file = true;
/*      */           }
/*  535 */           else if ((DHT.this.peerN > this.hash) && (DHT.predecessor1 <= this.hash) && (DHT.predecessor2 > this.hash))
/*      */           {
/*      */ 
/*  538 */             String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(DHT.this.peerN) + ":end";
/*      */             
/*  540 */             this.file = true;
/*      */           }
/*  542 */           else if ((DHT.this.firstNode) && (this.hash > DHT.predecessor1) && (this.hash > DHT.predecessor2))
/*      */           {
/*      */ 
/*  545 */             String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(DHT.this.peerN) + ":end";
/*      */             
/*  547 */             this.file = true;
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*  552 */             sentSentence = "request:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.forwardedToServer) + ":" + Integer.toString(clientN) + ":end";
/*      */             
/*  554 */             this.file = false;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*  560 */           if (this.file == true) {
/*  561 */             Socket replyToClient = null;
/*      */             try {
/*  563 */               replyToClient = new Socket(clientAddress, clientN + 50000);
/*      */             }
/*      */             catch (IOException localIOException3) {}
/*  566 */             DataOutputStream outToClient = null;
/*      */             try {
/*  568 */               outToClient = new DataOutputStream(replyToClient.getOutputStream());
/*      */             } catch (IOException localIOException4) {}
/*  570 */             String replyMessage = sentSentence;
/*      */             try {
/*  572 */               outToClient.writeBytes(replyMessage);
/*      */             } catch (IOException localIOException5) {}
/*      */             try {
/*  575 */               replyToClient.close();
/*      */             } catch (IOException localIOException6) {}
/*  577 */             System.out.println("File " + this.fileN + " is here.");
/*  578 */             System.out.println("A response message, destined for Peer " + clientN + ", has been sent.");
/*      */           }
/*      */           
/*  581 */           if (!this.file) {
/*  582 */             Socket forwardToServer = null;
/*      */             try {
/*  584 */               forwardToServer = new Socket(clientAddress, DHT.this.successor1 + 50000);
/*      */             } catch (IOException localIOException7) {}
/*  586 */             DataOutputStream outToServer = null;
/*      */             try {
/*  588 */               outToServer = new DataOutputStream(forwardToServer.getOutputStream());
/*      */             } catch (IOException localIOException8) {}
/*  590 */             String forwardMessage = sentSentence;
/*      */             try {
/*  592 */               outToServer.writeBytes(forwardMessage);
/*      */             } catch (IOException localIOException9) {}
/*      */             try {
/*  595 */               forwardToServer.close();
/*      */             } catch (IOException localIOException10) {}
/*  597 */             System.out.println("File " + this.fileN + " is not stored here.");
/*  598 */             System.out.println("File request message has been forwarded to my successor.");
/*      */           }
/*      */           
/*      */         }
/*  602 */         else if (splitSentence[0].equals("file"))
/*      */         {
/*      */ 
/*      */ 
/*  606 */           int filenumber = Integer.parseInt(splitSentence[1]);
/*  607 */           int serverN = Integer.parseInt(splitSentence[3]);
/*  608 */           if (Integer.parseInt(splitSentence[2]) == this.hasFile) {
/*  609 */             System.out.println("Received a response message from Peer " + serverN + ", which has the file " + filenumber + ".");
/*      */ 
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*      */         }
/*  616 */         else if ((splitSentence[0].equals("quit")) || (splitSentence[0].equals("Quit"))) {
/*  617 */           quitMessage = clientSentence;
/*  618 */           splitQuitMessage = quitMessage.split(":");
/*  619 */           clientN = Integer.parseInt(splitQuitMessage[1]);
/*  620 */           int new1 = Integer.parseInt(splitQuitMessage[2]);
/*  621 */           int new2 = Integer.parseInt(splitQuitMessage[3]);
/*      */           
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  627 */           if (clientN == DHT.this.successor1) {
/*  628 */             System.out.println("Peer " + clientN + " will depart from the network.");
/*  629 */             if (DHT.this.successor2 == new2) {
/*  630 */               DHT.this.successor1 = new1;
/*  631 */             } else if (DHT.this.successor2 == new1) {
/*  632 */               DHT.this.successor1 = new2;
/*      */             }
/*  634 */             int temp = DHT.this.successor1;
/*  635 */             DHT.this.successor1 = DHT.this.successor2;
/*  636 */             DHT.this.successor2 = temp;
/*  637 */             System.out.println("My first successor is now Peer " + DHT.this.successor1 + ".");
/*  638 */             System.out.println("My second successor is now Peer " + DHT.this.successor2 + ".");
/*      */             
/*  640 */             String confirmation = new String("confirmation1");
/*  641 */             Socket confirmSocket = null;
/*      */             try {
/*  643 */               confirmSocket = new Socket(serverAddress, clientN + 50000);
/*      */             } catch (IOException localIOException11) {}
/*  645 */             DataOutputStream confirm = null;
/*      */             try {
/*  647 */               confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*      */             } catch (IOException localIOException12) {}
/*      */             try {
/*  650 */               confirm.writeBytes(confirmation);
/*      */             } catch (IOException localIOException13) {}
/*      */             try {
/*  653 */               confirmSocket.close();
/*      */ 
/*      */ 
/*      */             }
/*      */             catch (IOException localIOException14) {}
/*      */ 
/*      */ 
/*      */           }
/*  661 */           else if (clientN == DHT.this.successor2) {
/*  662 */             System.out.println("Peer " + clientN + " will depart from the network.");
/*  663 */             DHT.this.successor2 = new1;
/*  664 */             System.out.println("My first successor is now Peer " + DHT.this.successor1 + ".");
/*  665 */             System.out.println("My second successor is now Peer " + DHT.this.successor2 + ".");
/*      */             
/*  667 */             String confirmation = new String("confirmation2");
/*  668 */             Socket confirmSocket = null;
/*      */             try {
/*  670 */               confirmSocket = new Socket(serverAddress, clientN + 50000);
/*      */             } catch (IOException localIOException15) {}
/*  672 */             DataOutputStream confirm = null;
/*      */             try {
/*  674 */               confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*      */             } catch (IOException localIOException16) {}
/*      */             try {
/*  677 */               confirm.writeBytes(confirmation);
/*      */             } catch (IOException localIOException17) {}
/*      */             try {
/*  680 */               confirmSocket.close();
/*      */             }
/*      */             catch (IOException localIOException18) {}
/*  683 */           } else if (clientN == DHT.predecessor1) {
/*  684 */             DHT.predecessor1 = DHT.predecessor2;
/*  685 */             DHT.predecessor2 = new2;
/*      */             
/*  687 */             String confirmation = new String("confirmation3");
/*  688 */             Socket confirmSocket = null;
/*      */             try {
/*  690 */               confirmSocket = new Socket(serverAddress, clientN + 50000);
/*      */             } catch (IOException localIOException19) {}
/*  692 */             DataOutputStream confirm = null;
/*      */             try {
/*  694 */               confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*      */             } catch (IOException localIOException20) {}
/*      */             try {
/*  697 */               confirm.writeBytes(confirmation);
/*      */             } catch (IOException localIOException21) {}
/*      */             try {
/*  700 */               confirmSocket.close();
/*      */             }
/*      */             catch (IOException localIOException22) {}
/*  703 */           } else if (clientN == DHT.predecessor2) {
/*  704 */             DHT.predecessor2 = new1;
/*      */             
/*  706 */             String confirmation = new String("confirmation4");
/*  707 */             Socket confirmSocket = null;
/*      */             try {
/*  709 */               confirmSocket = new Socket(serverAddress, clientN + 50000);
/*      */             } catch (IOException localIOException23) {}
/*  711 */             DataOutputStream confirm = null;
/*      */             try {
/*  713 */               confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*      */             } catch (IOException localIOException24) {}
/*      */             try {
/*  716 */               confirm.writeBytes(confirmation);
/*      */             } catch (IOException localIOException25) {}
/*      */             try {
/*  719 */               confirmSocket.close();
/*      */ 
/*      */             }
/*      */             catch (IOException localIOException26) {}
/*      */           }
/*      */           
/*      */ 
/*      */         }
/*  727 */         else if (splitSentence[0].equals("requiresuccessor1")) {
/*  728 */           predecessorN = Integer.parseInt(splitSentence[1]);
/*  729 */           predecessorP = predecessorN + 50000;
/*      */           
/*  731 */           String replyPredecessor = "replysuccessor1:" + Integer.toString(DHT.this.successor1) + ":end";
/*      */           
/*  733 */           if (predecessorN == DHT.predecessor2) {
/*  734 */             DHT.predecessor1 = predecessorN;
/*  735 */             DHT.predecessor2 = Integer.parseInt(splitSentence[2]);
/*      */           }
/*  737 */           Socket replyPredecessorSocket = null;
/*      */           try {
/*  739 */             replyPredecessorSocket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*      */           } catch (IOException localIOException27) {}
/*  741 */           DataOutputStream outToServer = null;
/*      */           try {
/*  743 */             outToServer = new DataOutputStream(replyPredecessorSocket.getOutputStream());
/*      */           } catch (IOException localIOException28) {}
/*      */           try {
/*  746 */             outToServer.writeBytes(replyPredecessor);
/*      */           } catch (IOException localIOException29) {}
/*      */           try {
/*  749 */             replyPredecessorSocket.close();
/*      */           }
/*      */           catch (IOException localIOException30) {}
/*      */           
/*  753 */           String informString = "changepredecessor2:" + Integer.toString(DHT.predecessor1) + ":end";
/*      */           
/*  755 */           Socket informSuccessor1Socket = null;
/*      */           try {
/*  757 */             informSuccessor1Socket = new Socket(serverAddress, DHT.this.successor1 + 50000);
/*      */           } catch (IOException localIOException31) {}
/*  759 */           DataOutputStream informSuccessor = null;
/*      */           try {
/*  761 */             informSuccessor = new DataOutputStream(informSuccessor1Socket.getOutputStream());
/*      */           } catch (IOException localIOException32) {}
/*      */           try {
/*  764 */             informSuccessor.writeBytes(informString);
/*      */           } catch (IOException localIOException33) {}
/*      */           try {
/*  767 */             informSuccessor1Socket.close();
/*      */           }
/*      */           catch (IOException localIOException34) {}
/*  770 */         } else if (splitSentence[0].equals("changepredecessor2")) {
/*  771 */           DHT.predecessor2 = Integer.parseInt(splitSentence[1]);
/*      */         }
/*  773 */         else if (splitSentence[0].equals("replysuccessor1")) {
/*  774 */           DHT.this.successor2 = Integer.parseInt(splitSentence[1]);
/*  775 */           DHT.this.successorFull = true;
/*  776 */           System.out.println("My second successor is now peer " + DHT.this.successor2 + ".");
/*      */           
/*  778 */           String inform = "successor2lost";
/*  779 */           Socket informPredecessor1Socket = null;
/*      */           try {
/*  781 */             informPredecessor1Socket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*      */           } catch (IOException localIOException35) {}
/*  783 */           DataOutputStream informSuccessor = null;
/*      */           try {
/*  785 */             informSuccessor = new DataOutputStream(informPredecessor1Socket.getOutputStream());
/*      */           } catch (IOException localIOException36) {}
/*      */           try {
/*  788 */             informSuccessor.writeBytes(inform);
/*      */           } catch (IOException localIOException37) {}
/*      */           try {
/*  791 */             informPredecessor1Socket.close();
/*      */           }
/*      */           catch (IOException localIOException38) {}
/*  794 */         } else if (splitSentence[0].equals("successor2lost")) {
/*  795 */           DHT.this.successorFull = false;
/*  796 */           System.out.println("Peer " + DHT.this.successor2 + " is no longer alive.");
/*  797 */           System.out.println("My first successor is now peer " + DHT.this.successor1 + ".");
/*      */           
/*  799 */           Socket peerfindingSocket = null;
/*      */           try {
/*  801 */             peerfindingSocket = new Socket(serverAddress, DHT.this.successor1 + 50000);
/*      */           } catch (IOException localIOException39) {}
/*  803 */           DataOutputStream outToServer = null;
/*      */           try {
/*  805 */             outToServer = new DataOutputStream(peerfindingSocket.getOutputStream());
/*      */           }
/*      */           catch (IOException localIOException40) {}
/*      */           
/*  809 */           String sentSentence1 = "requiresuccessor2:" + Integer.toString(DHT.this.peerN) + ":end";
/*      */           try
/*      */           {
/*  812 */             outToServer.writeBytes(sentSentence1);
/*      */           } catch (IOException localIOException41) {}
/*      */           try {
/*  815 */             peerfindingSocket.close();
/*      */           }
/*      */           catch (IOException localIOException42) {}
/*  818 */         } else if (splitSentence[0].equals("requiresuccessor2")) {
/*  819 */           predecessorN = Integer.parseInt(splitSentence[1]);
/*  820 */           predecessorP = predecessorN + 50000;
/*      */           
/*  822 */           String replyPredecessor = "replysuccessor2:" + Integer.toString(DHT.this.successor1) + ":end";
/*      */           
/*  824 */           Socket replyPredecessorSocket = null;
/*      */           try {
/*  826 */             replyPredecessorSocket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*      */           } catch (IOException localIOException43) {}
/*  828 */           DataOutputStream outToServer = null;
/*      */           try {
/*  830 */             outToServer = new DataOutputStream(replyPredecessorSocket.getOutputStream());
/*      */           } catch (IOException localIOException44) {}
/*      */           try {
/*  833 */             outToServer.writeBytes(replyPredecessor);
/*      */           } catch (IOException localIOException45) {}
/*      */           try {
/*  836 */             replyPredecessorSocket.close();
/*      */           }
/*      */           catch (IOException localIOException46) {}
/*  839 */         } else if (splitSentence[0].equals("replysuccessor2")) {
/*  840 */           DHT.this.successor2 = Integer.parseInt(splitSentence[1]);
/*  841 */           DHT.this.successorFull = true;
/*  842 */           System.out.println("My second successor is now peer " + DHT.this.successor2 + ".");
/*      */         }
/*  844 */         else if (splitSentence[0].equals("confirmation1")) {
/*  845 */           DHT.this.confirm1 = true;
/*      */         }
/*  847 */         else if (splitSentence[0].equals("confirmation2")) {
/*  848 */           DHT.this.confirm2 = true;
/*      */         }
/*  850 */         else if (splitSentence[0].equals("confirmation3")) {
/*  851 */           DHT.this.confirm3 = true;
/*      */         }
/*  853 */         else if (splitSentence[0].equals("confirmation4")) {
/*  854 */           DHT.this.confirm4 = true;
/*      */         }
/*      */         else {
/*  857 */           System.out.println("Unrecognised message received by TCP server.");
/*  858 */           System.out.println(clientSentence);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   class TCP_Client
/*      */     extends Thread
/*      */   {
/*      */     public int fileN;
/*      */     
/*      */     public int hash;
/*      */     
/*      */     public TCP_Client() {}
/*      */     
/*  874 */     public int requestFromClient = 1;
/*  875 */     public int forwardedByServer = 2;
/*  876 */     public int forwardedToServer = 2;
/*  877 */     public int hasFile = 3;
/*  878 */     public int clientP = 50000 + DHT.this.peerN;
/*  879 */     public boolean fileRequest = false;
/*  880 */     public boolean gracefulLeave = false;
/*      */     
/*      */     public void run() {
/*  883 */       while ((!DHT.this.confirm1) || (!DHT.this.confirm2) || (!DHT.this.confirm3) || (!DHT.this.confirm4))
/*      */       {
/*      */ 
/*  886 */         Scanner scan = new Scanner(System.in);
/*  887 */         while ((!DHT.this.confirm1) || (!DHT.this.confirm2) || (!DHT.this.confirm3) || (!DHT.this.confirm4)) {
/*  888 */           String clientOrder = scan.nextLine();
/*  889 */           String[] splitSentence = clientOrder.split(" ");
/*  890 */           if ((splitSentence[0].equals("request")) || (splitSentence[0].equals("Request"))) {
/*  891 */             this.fileN = Integer.parseInt(splitSentence[1]);
/*  892 */             if ((this.fileN >= 0) && (this.fileN <= 9999)) {
/*  893 */               this.fileRequest = true;
/*  894 */               this.hash = (this.fileN % 256);
/*  895 */               break;
/*      */             }
/*      */           } else {
/*  898 */             if ((splitSentence[0].equals("quit")) || (splitSentence[0].equals("Quit"))) {
/*  899 */               this.gracefulLeave = true;
/*  900 */               break;
/*      */             }
/*      */             
/*  903 */             System.out.println("Invalid input or a wrong file number, this node can only request a file or do a graceful leaving, please try again!");
/*      */           }
/*      */         }
/*  906 */         if (this.fileRequest)
/*      */         {
/*  908 */           InetAddress serverAddress = null;
/*      */           try {
/*  910 */             serverAddress = InetAddress.getLocalHost();
/*      */           }
/*      */           catch (UnknownHostException localUnknownHostException) {}
/*  913 */           Socket clientSocket = null;
/*      */           try {
/*  915 */             clientSocket = new Socket(serverAddress, DHT.this.successor1 + 50000);
/*      */           } catch (IOException localIOException) {}
/*  917 */           DataOutputStream outToServer = null;
/*      */           try {
/*  919 */             outToServer = new DataOutputStream(clientSocket.getOutputStream());
/*      */           }
/*      */           catch (IOException localIOException1) {}
/*      */           
/*      */ 
/*  924 */           String sentSentence = "request:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.requestFromClient) + ":" + Integer.toString(DHT.this.peerN) + ":end";
/*      */           
/*      */           try
/*      */           {
/*  928 */             outToServer.writeBytes(sentSentence);
/*      */           } catch (IOException localIOException2) {}
/*      */           try {
/*  931 */             clientSocket.close();
/*      */           } catch (IOException localIOException3) {}
/*  933 */           System.out.println("File request message for " + this.fileN + " has been sent to my successor.");
/*      */ 
/*      */         }
/*  936 */         else if (this.gracefulLeave)
/*      */         {
/*      */ 
/*      */ 
/*  940 */           InetAddress serverAddress = null;
/*      */           try {
/*  942 */             serverAddress = InetAddress.getLocalHost();
/*      */           }
/*      */           catch (UnknownHostException localUnknownHostException1) {}
/*      */           
/*      */ 
/*  947 */           String sentSentence = "quit:" + Integer.toString(DHT.this.peerN) + ":" + Integer.toString(DHT.this.successor1) + ":" + Integer.toString(DHT.this.successor2) + ":end";
/*      */           
/*      */ 
/*  950 */           Socket clientSocket1 = null;
/*      */           try {
/*  952 */             clientSocket1 = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*      */           } catch (IOException localIOException4) {}
/*  954 */           DataOutputStream outToServer1 = null;
/*      */           try {
/*  956 */             outToServer1 = new DataOutputStream(clientSocket1.getOutputStream());
/*      */           } catch (IOException localIOException5) {}
/*      */           try {
/*  959 */             outToServer1.writeBytes(sentSentence);
/*      */           } catch (IOException localIOException6) {}
/*      */           try {
/*  962 */             clientSocket1.close();
/*      */           }
/*      */           catch (IOException localIOException7) {}
/*  965 */           Socket clientSocket2 = null;
/*      */           try {
/*  967 */             clientSocket2 = new Socket(serverAddress, DHT.predecessor2 + 50000);
/*      */           } catch (IOException localIOException8) {}
/*  969 */           DataOutputStream outToServer2 = null;
/*      */           try {
/*  971 */             outToServer2 = new DataOutputStream(clientSocket2.getOutputStream());
/*      */           } catch (IOException localIOException9) {}
/*      */           try {
/*  974 */             outToServer2.writeBytes(sentSentence);
/*      */           } catch (IOException localIOException10) {}
/*      */           try {
/*  977 */             clientSocket2.close();
/*      */           }
/*      */           catch (IOException localIOException11) {}
/*      */           
/*      */ 
/*      */ 
/*  983 */           sentSentence = "quit:" + Integer.toString(DHT.this.peerN) + ":" + Integer.toString(DHT.predecessor1) + ":" + Integer.toString(DHT.predecessor2) + ":end";
/*      */           
/*  985 */           Socket clientSocket3 = null;
/*      */           try {
/*  987 */             clientSocket3 = new Socket(serverAddress, DHT.this.successor1 + 50000);
/*      */           } catch (IOException localIOException12) {}
/*  989 */           DataOutputStream outToServer3 = null;
/*      */           try {
/*  991 */             outToServer3 = new DataOutputStream(clientSocket3.getOutputStream());
/*      */           } catch (IOException localIOException13) {}
/*      */           try {
/*  994 */             outToServer3.writeBytes(sentSentence);
/*      */           } catch (IOException localIOException14) {}
/*      */           try {
/*  997 */             clientSocket3.close();
/*      */           }
/*      */           catch (IOException localIOException15) {}
/* 1000 */           Socket clientSocket4 = null;
/*      */           try {
/* 1002 */             clientSocket4 = new Socket(serverAddress, DHT.this.successor2 + 50000);
/*      */           } catch (IOException localIOException16) {}
/* 1004 */           DataOutputStream outToServer4 = null;
/*      */           try {
/* 1006 */             outToServer4 = new DataOutputStream(clientSocket4.getOutputStream());
/*      */           } catch (IOException localIOException17) {}
/*      */           try {
/* 1009 */             outToServer4.writeBytes(sentSentence);
/*      */           } catch (IOException localIOException18) {}
/*      */           try {
/* 1012 */             clientSocket4.close();
/*      */           }
/*      */           catch (IOException localIOException19) {}
/*      */         } else {
/* 1016 */           System.out.println("Unrecognised message in TCP client.");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\DHT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */