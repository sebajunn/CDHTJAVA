/*     */ import java.io.PrintStream;
/*     */ import java.net.DatagramPacket;
/*     */ 
/*     */ public class cdht_ex
/*     */ {
/*     */   static int base;
/*     */   static int peerIdentity;
/*     */   static int firstSuccessor;
/*     */   static int secondSuccessor;
/*     */   static int peerPort;
/*     */   static int firstSuccessorPort;
/*     */   static int secondSuccessorPort;
/*  13 */   static int count = 0;
/*  14 */   static boolean firstPingBack = false;
/*  15 */   static boolean secondPingBack = false;
/*  16 */   static boolean userInput = false;
/*  17 */   static boolean requestFileMessage = false;
/*     */   
/*     */   static java.net.DatagramSocket UDPSocket;
/*     */   
/*     */   public static DatagramPacket UDPClient(int destinationPort)
/*     */     throws Exception
/*     */   {
/*  24 */     String message = "Request";
/*  25 */     java.net.InetAddress IPAddress = java.net.InetAddress.getByName("localhost");
/*  26 */     byte[] sendData = message.getBytes();
/*  27 */     DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, destinationPort);
/*  28 */     return sendPacket;
/*     */   }
/*     */   
/*     */   public static void UDPServer() throws Exception
/*     */   {
/*  33 */     boolean haveShownHideMessage = false;
/*  34 */     boolean haveShownHideRequestMessage = false;
/*     */     
/*  36 */     String message = "Response";
/*  37 */     byte[] receiveData = new byte['Ѐ'];
/*  38 */     byte[] sendData = message.getBytes();
/*  39 */     DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
/*     */     for (;;) {
/*  41 */       UDPSocket.receive(receivePacket);
/*  42 */       int port = receivePacket.getPort();
/*  43 */       java.net.InetAddress IPAdress = receivePacket.getAddress();
/*  44 */       DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAdress, port);
/*     */       
/*  46 */       if ((userInput) && (!haveShownHideMessage)) haveShownHideMessage = true;
/*  47 */       if ((requestFileMessage) && (!haveShownHideRequestMessage)) {
/*  48 */         System.out.println("Ping messages are hide\n");
/*  49 */         haveShownHideRequestMessage = true;
/*     */       }
/*  51 */       if ((port != firstSuccessorPort) && (port != secondSuccessorPort))
/*     */       {
/*     */ 
/*  54 */         UDPSocket.send(sendPacket);
/*  55 */         int peer = port - base;
/*  56 */         if ((!userInput) && (!requestFileMessage))
/*  57 */           System.out.println("A ping request message was received from Peer " + peer + ".");
/*     */       }
/*  59 */       if (port == firstSuccessorPort) {
/*  60 */         if ((!userInput) && (!requestFileMessage))
/*  61 */           System.out.println("A ping response message was received from Peer " + firstSuccessor + ".");
/*  62 */         firstPingBack = true;
/*     */       }
/*  64 */       if (port == secondSuccessorPort) {
/*  65 */         if ((!userInput) && (!requestFileMessage))
/*  66 */           System.out.println("A ping response message was received from Peer " + secondSuccessor + ".");
/*  67 */         secondPingBack = true;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static int stringToHash(String fileName)
/*     */   {
/*  74 */     int w = Integer.parseInt(String.valueOf(fileName.charAt(0)));
/*  75 */     int x = Integer.parseInt(String.valueOf(fileName.charAt(1)));
/*  76 */     int y = Integer.parseInt(String.valueOf(fileName.charAt(2)));
/*  77 */     int z = Integer.parseInt(String.valueOf(fileName.charAt(3)));
/*  78 */     int hash = (w * 1000 + x * 100 + y * 10 + z + 1) % 256;
/*  79 */     return hash;
/*     */   }
/*     */   
/*     */   public static void TCPServer() throws Exception
/*     */   {
/*  84 */     java.net.ServerSocket welcomeServer = new java.net.ServerSocket(peerPort);
/*     */     for (;;) {
/*  86 */       java.net.Socket connectionSocket = welcomeServer.accept();
/*  87 */       java.io.BufferedReader inFromClient = new java.io.BufferedReader(new java.io.InputStreamReader(connectionSocket.getInputStream()));
/*  88 */       String clientMessage = inFromClient.readLine();
/*  89 */       String status = clientMessage.split(" ")[0];
/*     */       
/*  91 */       if (status.equals("quit"))
/*     */       {
/*     */ 
/*  94 */         if (clientMessage.split(" ")[1].equals("ok"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  99 */           count += 1;
/* 100 */           if (count == 2) {
/* 101 */             System.out.println("I can quit now.");
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 109 */           userInput = false;
/* 110 */           requestFileMessage = false;
/* 111 */           int quitPeer = Integer.parseInt(clientMessage.split(" ")[1]);
/* 112 */           if ((quitPeer != firstSuccessor) && (quitPeer != secondSuccessor))
/*     */           {
/*     */ 
/* 115 */             TCPClient(clientMessage + "\n", firstSuccessorPort);
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 120 */             if (quitPeer != firstSuccessor) TCPClient(clientMessage + "\n", firstSuccessorPort);
/* 121 */             int newFirstSuccessor = Integer.parseInt(clientMessage.split(" ")[2]);
/* 122 */             int newSecondSuccessor = Integer.parseInt(clientMessage.split(" ")[3]);
/* 123 */             if (firstSuccessor == quitPeer) {
/* 124 */               firstSuccessor = secondSuccessor == newFirstSuccessor ? newSecondSuccessor : newFirstSuccessor;
/* 125 */               int tmp = firstSuccessor;
/* 126 */               firstSuccessor = secondSuccessor;
/* 127 */               secondSuccessor = tmp;
/*     */             } else {
/* 129 */               secondSuccessor = firstSuccessor == newFirstSuccessor ? newSecondSuccessor : newFirstSuccessor; }
/* 130 */             firstSuccessorPort = base + firstSuccessor;
/* 131 */             secondSuccessorPort = base + secondSuccessor;
/*     */             
/*     */ 
/* 134 */             TCPClient("quit ok " + peerIdentity + "\n", quitPeer + base);
/* 135 */             System.out.println(quitPeer + " " + peerIdentity);
/* 136 */             System.out.println("Peer " + quitPeer + " will depart from the network.");
/* 137 */             System.out.println("My first successor is now peer " + firstSuccessor);
/* 138 */             System.out.println("My second successor is now peer " + secondSuccessor);
/*     */           }
/*     */         }
/*     */       }
/* 142 */       else if (status.equals("ask"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 147 */         requestFileMessage = false;
/* 148 */         int reponseToPort = Integer.parseInt(clientMessage.split(" ")[1]);
/* 149 */         String whichSuccessor = clientMessage.split(" ")[2];
/*     */         
/* 151 */         if (whichSuccessor.equals("first")) TCPClient("reponseAsk firstSuccessor " + firstSuccessor + "\n", reponseToPort); else {
/* 152 */           TCPClient("reponseAsk secondSuccessor " + secondSuccessor + "\n", reponseToPort);
/*     */         }
/* 154 */       } else if (status.equals("reponseAsk"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 159 */         requestFileMessage = false;
/* 160 */         String changedSuccessor = clientMessage.split(" ")[1];
/* 161 */         int newSuccessor = Integer.parseInt(clientMessage.split(" ")[2]);
/* 162 */         if (changedSuccessor.equals("firstSuccessor"))
/*     */         {
/*     */ 
/* 165 */           firstSuccessor = secondSuccessor;
/* 166 */           secondSuccessor = newSuccessor;
/* 167 */           firstSuccessorPort = firstSuccessor + base;
/* 168 */           secondSuccessorPort = secondSuccessor + base;
/* 169 */           System.out.println("My first successor is now peer " + firstSuccessor);
/* 170 */           System.out.println("My second successor is now peer " + secondSuccessor);
/*     */         }
/*     */         else
/*     */         {
/* 174 */           secondSuccessor = newSuccessor;
/* 175 */           secondSuccessorPort = secondSuccessor + base;
/* 176 */           System.out.println("My first successor is now peer " + firstSuccessor);
/* 177 */           System.out.println("My second successor is now peer " + secondSuccessor);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 183 */         requestFileMessage = true;
/* 184 */         String fileName = clientMessage.split(" ")[1];
/* 185 */         int hashValue = Integer.parseInt(clientMessage.split(" ")[2]);
/* 186 */         int sourcePeerIdentity = Integer.parseInt(clientMessage.split(" ")[3]);
/* 187 */         int clientPeerIdentity = Integer.parseInt(clientMessage.split(" ")[4]);
/*     */         
/* 189 */         if (status.equals("Response"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 194 */           System.out.println("Received a response message from peer " + clientPeerIdentity + ", which has the file " + fileName);
/*     */         }
/*     */         else
/*     */         {
/*     */           boolean forwardMessage;
/*     */           
/*     */           boolean forwardMessage;
/* 201 */           if ((hashValue == peerIdentity) || ((peerIdentity < hashValue) && (firstSuccessor < hashValue) && (peerIdentity > firstSuccessor)) || ((peerIdentity < hashValue) && (firstSuccessor > hashValue)))
/*     */           {
/*     */ 
/* 204 */             forwardMessage = false; } else
/* 205 */             forwardMessage = true;
/* 206 */           if (forwardMessage) {
/* 207 */             TCPClient("Request " + fileName + " " + hashValue + " " + sourcePeerIdentity + " " + peerIdentity + "\n", firstSuccessorPort);
/* 208 */             System.out.println("File " + fileName + " is not stored here.\nFile request message has been forwarded to my successor.");
/*     */           } else {
/* 210 */             TCPClient("Response " + fileName + " " + hashValue + " " + sourcePeerIdentity + " " + peerIdentity + "\n", base + sourcePeerIdentity);
/* 211 */             System.out.println("File " + fileName + " is stored here.\nA response message, destined for peer " + sourcePeerIdentity + ", has been sent.");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void TCPClient(String message, int destPort)
/*     */   {
/*     */     try {
/* 221 */       java.net.Socket clientSocket = new java.net.Socket("localhost", destPort);
/* 222 */       java.io.DataOutputStream outToServer = new java.io.DataOutputStream(clientSocket.getOutputStream());
/* 223 */       outToServer.writeBytes(message);
/*     */     } catch (Exception e) {
/* 225 */       System.out.println("----Socket Create failed-----");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */     throws java.io.IOException
/*     */   {
/* 232 */     peerIdentity = Integer.parseInt(args[0]);
/* 233 */     firstSuccessor = Integer.parseInt(args[1]);
/* 234 */     secondSuccessor = Integer.parseInt(args[2]);
/* 235 */     base = 50000;
/* 236 */     peerPort = base + peerIdentity;
/* 237 */     firstSuccessorPort = base + firstSuccessor;
/* 238 */     secondSuccessorPort = base + secondSuccessor;
/* 239 */     UDPSocket = new java.net.DatagramSocket(peerPort);
/*     */     
/*     */ 
/* 242 */     final Thread newServer = new Thread() {
/*     */       public void run() {
/*     */         try {
/*     */           
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/* 249 */     };
/* 250 */     Thread firstClient = new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         try {
/*     */           for (;;) {
/* 256 */             DatagramPacket packet = cdht_ex.UDPClient(cdht_ex.firstSuccessorPort);
/* 257 */             cdht_ex.UDPSocket.send(packet);
/* 258 */             Thread.currentThread();Thread.sleep(3000L); }
/* 259 */           return;
/*     */         } catch (Exception e) {}
/*     */       }
/* 262 */     };
/* 263 */     final Thread secondClient = new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         try {
/*     */           for (;;) {
/* 269 */             DatagramPacket packet = cdht_ex.UDPClient(cdht_ex.secondSuccessorPort);
/* 270 */             cdht_ex.UDPSocket.send(packet);
/* 271 */             Thread.currentThread();Thread.sleep(3000L); }
/* 272 */           return;
/*     */         } catch (Exception e) {}
/*     */       }
/* 275 */     };
/* 276 */     final Thread check = new Thread()
/*     */     {
/*     */       public void run()
/*     */       {
/*     */         for (;;)
/*     */         {
/*     */           try
/*     */           {
/* 284 */             Thread.currentThread();Thread.sleep(12000L);
/* 285 */           } catch (InterruptedException e) { return;
/*     */           }
/* 287 */           if (cdht_ex.firstPingBack) {
/* 288 */             cdht_ex.firstPingBack = false;
/* 289 */           } else if (!cdht_ex.firstPingBack) {
/* 290 */             String changeSuccessor = "ask " + cdht_ex.peerPort + " first\n";
/* 291 */             cdht_ex.TCPClient(changeSuccessor, cdht_ex.secondSuccessorPort);
/* 292 */             cdht_ex.firstPingBack = false;
/* 293 */             System.out.println("Peer " + cdht_ex.firstSuccessor + " is no longer alive.");
/*     */           }
/*     */           
/* 296 */           if (cdht_ex.secondPingBack) {
/* 297 */             cdht_ex.secondPingBack = false;
/*     */           }
/* 299 */           else if (!cdht_ex.secondPingBack) {
/* 300 */             String changeSuccessor = "ask " + cdht_ex.peerPort + " second\n";
/* 301 */             cdht_ex.TCPClient(changeSuccessor, cdht_ex.firstSuccessorPort);
/* 302 */             cdht_ex.secondPingBack = false;
/* 303 */             System.out.println("Peer " + cdht_ex.secondSuccessor + " is no longer alive.");
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 308 */     };
/* 309 */     final Thread requestFileServer = new Thread()
/*     */     {
/*     */       public void run() {
/*     */         try {
/*     */           
/*     */         }
/*     */         catch (Exception e) {}
/*     */       }
/* 317 */     };
/* 318 */     Thread waitInput = new Thread()
/*     */     {
/*     */ 
/*     */       public void run()
/*     */       {
/* 323 */         java.util.Scanner sc = new java.util.Scanner(System.in);
/*     */         for (;;)
/*     */         {
/* 326 */           String inputString = sc.nextLine();
/* 327 */           if (inputString.equals("")) {
/* 328 */             if ((cdht_ex.userInput) || (cdht_ex.requestFileMessage)) {
/* 329 */               cdht_ex.userInput = false;
/* 330 */               cdht_ex.requestFileMessage = false;
/* 331 */               System.out.println("You have pressed enter key, ping messages are displayed again\n");
/*     */ 
/*     */             }
/* 334 */             else if (!cdht_ex.userInput) {
/* 335 */               cdht_ex.userInput = true;
/* 336 */               System.out.println("You have pressed enter key, ping messages are hide\n");
/*     */             }
/*     */             
/*     */ 
/*     */           }
/* 341 */           else if (inputString.equals("quit"))
/*     */           {
/*     */ 
/*     */ 
/* 345 */             String sendMessage = "quit " + cdht_ex.peerIdentity + " " + cdht_ex.firstSuccessor + " " + cdht_ex.secondSuccessor + "\n";
/* 346 */             try { cdht_ex.TCPClient(sendMessage, cdht_ex.firstSuccessorPort); } catch (Exception e) { return; }
/* 347 */             try { Thread.currentThread();Thread.sleep(3000L); } catch (InterruptedException e) { return;
/*     */             }
/* 349 */             this.val$firstClient.interrupt();
/* 350 */             secondClient.interrupt();
/* 351 */             check.interrupt();
/* 352 */             if (cdht_ex.count == 2) {
/* 353 */               newServer.interrupt();
/* 354 */               requestFileServer.interrupt();
/*     */             }
/*     */           }
/*     */           else {
/* 358 */             String command = inputString.split(" ")[0];
/* 359 */             if (command.equals("request"))
/*     */             {
/*     */ 
/*     */ 
/* 363 */               String fileName = inputString.split(" ")[1];
/* 364 */               int hashValue = cdht_ex.stringToHash(fileName);
/* 365 */               String sendMessage = "request " + fileName + " " + hashValue + " " + cdht_ex.peerIdentity + " " + cdht_ex.peerIdentity + "\n";
/*     */               try {
/* 367 */                 cdht_ex.TCPClient(sendMessage, cdht_ex.firstSuccessorPort); } catch (Exception e) { return;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 372 */       } };
/* 373 */     newServer.start();
/* 374 */     firstClient.start();
/* 375 */     secondClient.start();
/* 376 */     check.start();
/* 377 */     requestFileServer.start();
/* 378 */     waitInput.start();
/*     */   }
/*     */ }


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */