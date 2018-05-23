/*     */ package cdht;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.ConnectException;
/*     */ import java.net.DatagramPacket;
/*     */ import java.net.DatagramSocket;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Socket;
/*     */ import java.util.Scanner;
/*     */ import java.util.Timer;
/*     */ 
/*     */ public class cdht
/*     */ {
/*     */   public static int peerID;
/*     */   public static int firstPeer;
/*     */   public static int secondPeer;
/*  21 */   public static int firstPredecessor = 0;
/*  22 */   public static int secondPredecessor = 0;
/*     */   
/*     */   public static int seqNum;
/*     */   
/*     */   public static int firstAck;
/*     */   public static int secondAck;
/*     */   public static int firstLostPings;
/*     */   public static int secondLostPings;
/*     */   public static final int PING_TIMING = 30000;
/*     */   public static final int FIRST_PING = 1000;
/*     */   public static final int MAX_LOST_PINGS = 4;
/*     */   public static final int PING_TIMEOUT = 1000;
/*     */   public static final String IP_ADDRESS = "127.0.0.1";
/*     */   
/*     */   static class TCPServerThread
/*     */     extends Thread
/*     */   {
/*     */     public void run()
/*     */     {
/*  41 */       java.net.ServerSocket welcomeSocket = null;
/*     */       try {
/*  43 */         welcomeSocket = new java.net.ServerSocket(50000 + cdht.peerID);
/*     */       } catch (IOException ex) {
/*  45 */         System.out.println(ex);
/*     */       }
/*     */       try
/*     */       {
/*     */         for (;;)
/*     */         {
/*  51 */           Socket connectionSocket = welcomeSocket.accept();
/*     */           
/*  53 */           BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
/*  54 */           String incomingSentence = inFromClient.readLine();
/*     */           
/*  56 */           String[] parsedSentence = incomingSentence.split(" ");
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  61 */           if (parsedSentence[0].equals("FILE")) {
/*  62 */             System.out.println("Received a response message from peer " + parsedSentence[2] + ", which has the file " + parsedSentence[1] + ".");
/*     */ 
/*     */ 
/*     */           }
/*  66 */           else if (parsedSentence[0].equals("LIST")) {
/*  67 */             DataOutputStream output = new DataOutputStream(connectionSocket.getOutputStream());
/*  68 */             output.writeBytes("PEERS " + cdht.firstPeer + " " + cdht.secondPeer + "\n");
/*     */ 
/*     */           }
/*  71 */           else if (parsedSentence[0].equals("QUIT")) {
/*  72 */             int departingPeer = Integer.parseInt(parsedSentence[3]);
/*  73 */             System.out.println("Peer " + departingPeer + " will depart from the network.");
/*  74 */             DataOutputStream output = new DataOutputStream(connectionSocket.getOutputStream());
/*  75 */             output.writeBytes("QUIT_RECEIVED\n");
/*     */             
/*  77 */             if ((departingPeer == cdht.secondPeer) && (departingPeer == cdht.secondPredecessor)) {
/*  78 */               cdht.secondPeer = cdht.firstPredecessor;
/*  79 */               cdht.secondPredecessor = cdht.firstPeer;
/*  80 */               System.out.println("My first successor is now peer " + cdht.firstPeer + ".");
/*  81 */               System.out.println("My second successor is now peer " + cdht.secondPeer + ".");
/*  82 */               System.out.println("My first predecessor is now peer " + cdht.firstPredecessor + ".");
/*  83 */               System.out.println("My second predecessor is now peer " + cdht.secondPredecessor + ".");
/*     */             }
/*  85 */             else if ((departingPeer == cdht.firstPeer) || (departingPeer == cdht.secondPeer)) {
/*  86 */               if (departingPeer == cdht.firstPeer) {
/*  87 */                 cdht.firstPeer = cdht.secondPeer;
/*  88 */                 cdht.secondPeer = Integer.parseInt(parsedSentence[2]);
/*     */               } else {
/*  90 */                 cdht.secondPeer = Integer.parseInt(parsedSentence[1]);
/*     */               }
/*  92 */               System.out.println("My first successor is now peer " + cdht.firstPeer + ".");
/*  93 */               System.out.println("My second successor is now peer " + cdht.secondPeer + ".");
/*     */             }
/*  95 */             else if ((departingPeer == cdht.firstPredecessor) || (departingPeer == cdht.secondPredecessor)) {
/*  96 */               if (departingPeer == cdht.firstPredecessor) {
/*  97 */                 cdht.firstPredecessor = cdht.secondPredecessor;
/*  98 */                 cdht.secondPredecessor = Integer.parseInt(parsedSentence[2]);
/*     */               } else {
/* 100 */                 cdht.secondPredecessor = Integer.parseInt(parsedSentence[1]);
/*     */               }
/* 102 */               System.out.println("My first predecessor is now peer " + cdht.firstPredecessor + ".");
/* 103 */               System.out.println("My second predecessor is now peer " + cdht.secondPredecessor + ".");
/*     */             }
/*     */             
/*     */           }
/* 107 */           else if (parsedSentence[0].equals("REQUEST")) {
/* 108 */             String fileRequested = parsedSentence[1];
/* 109 */             String sender = parsedSentence[2];
/* 110 */             String requester = parsedSentence[3];
/* 111 */             int hashFile = Integer.parseInt(fileRequested) % 256;
/*     */             
/*     */ 
/* 114 */             if ((cdht.peerID - Integer.parseInt(sender) + 256) % 256 > (cdht.peerID - hashFile + 256) % 256) {
/* 115 */               System.out.println("File " + fileRequested + " is here.");
/* 116 */               System.out.println("A response message, destined for peer " + requester + ", has been sent.");
/* 117 */               Socket sendSocket = new Socket(InetAddress.getByName("127.0.0.1"), 50000 + Integer.parseInt(requester));
/* 118 */               DataOutputStream output = new DataOutputStream(sendSocket.getOutputStream());
/* 119 */               String sentence = "FILE " + fileRequested + " " + cdht.peerID;
/* 120 */               output.writeBytes(sentence + "\n");
/* 121 */               sendSocket.close();
/*     */             }
/*     */             else {
/*     */               Socket sendSocket;
/*     */               try {
/* 126 */                 sendSocket = new Socket(InetAddress.getByName("127.0.0.1"), 50000 + cdht.firstPeer);
/*     */               } catch (ConnectException e) { Socket sendSocket;
/* 128 */                 sendSocket = new Socket(InetAddress.getByName("127.0.0.1"), 50000 + cdht.secondPeer);
/*     */               }
/* 130 */               DataOutputStream output = new DataOutputStream(sendSocket.getOutputStream());
/* 131 */               output.writeBytes("REQUEST " + fileRequested + " " + cdht.peerID + " " + requester + "\n");
/* 132 */               System.out.println("File " + fileRequested + " is not stored here.");
/* 133 */               System.out.println("File request message has been forwarded to my successor.");
/* 134 */               sendSocket.close();
/*     */             }
/*     */           }
/* 137 */           connectionSocket.close();
/*     */         }
/*     */       } catch (IOException ex) {
/* 140 */         System.out.println(ex);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static class UDPServerThread extends Thread
/*     */   {
/*     */     DatagramSocket socket;
/*     */     
/*     */     public UDPServerThread(DatagramSocket ds)
/*     */     {
/* 151 */       this.socket = ds;
/*     */     }
/*     */     
/*     */     public void run()
/*     */     {
/* 156 */       byte[] buffer = new byte['Ѐ'];
/*     */       for (;;) {
/* 158 */         DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
/*     */         try
/*     */         {
/* 161 */           this.socket.receive(dp);
/* 162 */           int clientPort = dp.getPort();
/*     */           
/* 164 */           String[] parsedSentence = dataToString(dp).split(" ");
/*     */           
/*     */ 
/*     */ 
/* 168 */           if (parsedSentence[0].equals("REPLY")) {
/* 169 */             System.out.println("A ping response message was received from Peer " + (clientPort - 50000) + ".");
/*     */             
/* 171 */             if (clientPort - 50000 == cdht.firstPeer) {
/* 172 */               cdht.firstAck = Integer.parseInt(parsedSentence[1]);
/*     */             } else
/* 174 */               cdht.secondAck = Integer.parseInt(parsedSentence[1]);
/*     */           }
/* 176 */           if (parsedSentence[0].equals("PING")) {
/* 177 */             System.out.println("A ping request message was received from Peer " + (clientPort - 50000) + ".");
/* 178 */             updatePredecessors(clientPort - 50000);
/*     */             
/* 180 */             byte[] buf = ("REPLY " + parsedSentence[1] + "\n").getBytes();
/* 181 */             DatagramPacket reply = new DatagramPacket(buf, buf.length, dp.getAddress(), clientPort);
/* 182 */             this.socket.send(reply);
/*     */           }
/*     */         } catch (IOException ex) {
/* 185 */           System.err.println(ex);
/*     */         } catch (Exception ex) {
/* 187 */           System.err.println(ex);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private String dataToString(DatagramPacket request) throws Exception
/*     */     {
/* 194 */       byte[] buf = request.getData();
/* 195 */       java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(buf);
/* 196 */       InputStreamReader isr = new InputStreamReader(bais);
/* 197 */       BufferedReader br = new BufferedReader(isr);
/* 198 */       return br.readLine();
/*     */     }
/*     */     
/*     */     private void updatePredecessors(int newPeer)
/*     */     {
/* 203 */       if ((cdht.firstPredecessor == 0) && (cdht.secondPredecessor == 0)) {
/* 204 */         cdht.firstPredecessor = newPeer;
/* 205 */         return;
/*     */       }
/*     */       
/* 208 */       if ((cdht.secondPredecessor == 0) && (cdht.firstPredecessor != 0)) {
/* 209 */         if ((cdht.peerID - cdht.firstPredecessor + 256) % 256 >= (cdht.peerID - newPeer + 256) % 256) { cdht.secondPredecessor = cdht.firstPredecessor;cdht.firstPredecessor = newPeer;
/* 210 */         } else { cdht.secondPredecessor = newPeer; } return; } if ((newPeer != cdht.firstPredecessor) && (newPeer != cdht.secondPredecessor)) { cdht.firstPredecessor = newPeer;cdht.secondPredecessor = 0;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static class PingTask
/*     */     extends java.util.TimerTask
/*     */   {
/*     */     DatagramSocket socket;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     PingTask(DatagramSocket socket)
/*     */     {
/* 232 */       this.socket = socket;
/*     */     }
/*     */     
/*     */ 
/*     */     public void run()
/*     */     {
/* 238 */       byte[] sendData = new byte['Ѐ'];
/* 239 */       String sentence = "PING " + cdht.seqNum + "\n";
/* 240 */       cdht.seqNum = (cdht.seqNum + 1) % 65536;
/* 241 */       sendData = sentence.getBytes();
/*     */       try {
/* 243 */         DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"), cdht.firstPeer + 50000);
/* 244 */         this.socket.send(sendPacket);
/* 245 */         sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("127.0.0.1"), cdht.secondPeer + 50000);
/* 246 */         this.socket.send(sendPacket);
/* 247 */         Thread.sleep(1000L);
/* 248 */         if (cdht.firstAck != cdht.seqNum - 1) {
/* 249 */           cdht.firstLostPings += 1;
/*     */         } else
/* 251 */           cdht.firstLostPings = 0;
/* 252 */         if (cdht.secondAck != cdht.seqNum - 1) {
/* 253 */           cdht.secondLostPings += 1;
/*     */         } else {
/* 255 */           cdht.secondLostPings = 0;
/*     */         }
/*     */         
/* 258 */         if ((cdht.firstLostPings >= 4) || (cdht.secondLostPings >= 4)) {
/* 259 */           int deadPeer = cdht.firstPeer;
/* 260 */           int livePeer = cdht.secondPeer;
/* 261 */           if (cdht.secondLostPings >= 4) {
/* 262 */             deadPeer = cdht.secondPeer;
/* 263 */             livePeer = cdht.firstPeer;
/*     */           }
/* 265 */           System.out.println("Peer " + deadPeer + " is no longer alive.");
/*     */           
/* 267 */           Socket sendSocket = new Socket(InetAddress.getByName("127.0.0.1"), 50000 + livePeer);
/* 268 */           DataOutputStream output = new DataOutputStream(sendSocket.getOutputStream());
/* 269 */           output.writeBytes("LIST\n");
/*     */           
/* 271 */           BufferedReader inFromServer = new BufferedReader(new InputStreamReader(sendSocket.getInputStream()));
/*     */           
/* 273 */           String replyFromServerSentence = inFromServer.readLine();
/* 274 */           String[] parsedSentence = replyFromServerSentence.split(" ");
/*     */           
/* 276 */           if (deadPeer == cdht.firstPeer) {
/* 277 */             cdht.firstPeer = cdht.secondPeer;
/* 278 */             cdht.secondPeer = Integer.parseInt(parsedSentence[1]);
/*     */ 
/*     */ 
/*     */           }
/* 282 */           else if (Integer.parseInt(parsedSentence[1]) == deadPeer) {
/* 283 */             cdht.secondPeer = Integer.parseInt(parsedSentence[2]);
/*     */           }
/*     */           else
/*     */           {
/* 287 */             cdht.secondPeer = Integer.parseInt(parsedSentence[1]);
/*     */           }
/* 289 */           System.out.println("My first successor is now peer " + cdht.firstPeer + ".");
/* 290 */           System.out.println("My second successor is now peer " + cdht.secondPeer + ".");
/* 291 */           sendSocket.close();
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/* 295 */         System.out.println(ex);
/*     */       } catch (InterruptedException ex) {
/* 297 */         System.out.println(ex);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */     throws Exception
/*     */   {
/* 305 */     peerID = Integer.parseInt(args[0]);
/* 306 */     firstPeer = Integer.parseInt(args[1]);
/* 307 */     secondPeer = Integer.parseInt(args[2]);
/* 308 */     InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
/* 309 */     seqNum = new java.util.Random().nextInt(65536);
/* 310 */     firstAck = secondAck = seqNum;
/* 311 */     firstLostPings = secondLostPings = 0;
/*     */     
/*     */ 
/* 314 */     DatagramSocket socket = new DatagramSocket(50000 + peerID);
/* 315 */     PingTask ping = new PingTask(socket);
/* 316 */     Timer timer = new Timer();
/* 317 */     timer.schedule(ping, 1000L, 30000L);
/*     */     
/*     */ 
/* 320 */     UDPServerThread UDPThread = new UDPServerThread(socket);
/* 321 */     UDPThread.start();
/*     */     
/*     */ 
/* 324 */     TCPServerThread TCPThread = new TCPServerThread();
/* 325 */     TCPThread.start();
/*     */     
/*     */ 
/* 328 */     Scanner s = new Scanner(System.in);
/*     */     
/*     */     String input;
/* 331 */     while (!(input = s.nextLine()).isEmpty())
/*     */     {
/* 333 */       if (!input.equalsIgnoreCase("quit")) { if ((input.length() == 12) && (input.substring(0, 7).equalsIgnoreCase("request"))) { String requestedFile = input.substring(8, input.length()); try { Integer hash = Integer.valueOf(Integer.parseInt(requestedFile) % 256); Socket sendSocket; try { sendSocket = new Socket(IPAddress, 50000 + firstPeer); } catch (ConnectException e) { Socket sendSocket; sendSocket = new Socket(IPAddress, 50000 + secondPeer); } DataOutputStream outToServer = new DataOutputStream(sendSocket.getOutputStream());String sentence = "REQUEST " + requestedFile + " " + peerID + " " + peerID;outToServer.writeBytes(sentence + "\n");sendSocket.close();System.out.println("File request message for " + requestedFile + " has been sent to my successor. File hash is " + hash + "."); } catch (NumberFormatException ex) { System.out.println("Filename is not numeric."); } } else { System.out.println("Unknown command : " + input);System.out.println("Syntax : QUIT or REQUEST <wxyz>");
/*     */         }
/* 335 */       } else { Socket sendSocketFirst = new Socket(IPAddress, 50000 + firstPeer);
/* 336 */         Socket sendSocketSecond = new Socket(IPAddress, 50000 + secondPeer);
/* 337 */         DataOutputStream outToServerFirst = new DataOutputStream(sendSocketFirst.getOutputStream());
/* 338 */         DataOutputStream outToServerSecond = new DataOutputStream(sendSocketSecond.getOutputStream());
/* 339 */         String quitMessage = "QUIT " + firstPredecessor + " " + secondPredecessor + " " + peerID;
/* 340 */         outToServerFirst.writeBytes(quitMessage + "\n");
/* 341 */         outToServerSecond.writeBytes(quitMessage + "\n");
/* 342 */         BufferedReader inFromFirst = new BufferedReader(new InputStreamReader(sendSocketFirst.getInputStream()));
/* 343 */         BufferedReader inFromSecond = new BufferedReader(new InputStreamReader(sendSocketSecond.getInputStream()));
/* 344 */         inFromFirst.readLine();
/* 345 */         inFromSecond.readLine();
/* 346 */         sendSocketFirst.close();
/* 347 */         sendSocketSecond.close();
/*     */         
/*     */ 
/* 350 */         Socket sendSocketA = new Socket(IPAddress, 50000 + firstPredecessor);
/* 351 */         DataOutputStream outToServerA = new DataOutputStream(sendSocketA.getOutputStream());
/* 352 */         quitMessage = "QUIT " + firstPeer + " " + secondPeer + " " + peerID;
/* 353 */         outToServerA.writeBytes(quitMessage + "\n");
/* 354 */         BufferedReader inFromA = new BufferedReader(new InputStreamReader(sendSocketA.getInputStream()));
/* 355 */         inFromA.readLine();
/* 356 */         sendSocketA.close();
/* 357 */         if (secondPredecessor != secondPeer) {
/* 358 */           Socket sendSocketB = new Socket(IPAddress, 50000 + secondPredecessor);
/* 359 */           DataOutputStream outToServerB = new DataOutputStream(sendSocketB.getOutputStream());
/* 360 */           outToServerB.writeBytes(quitMessage + "\n");
/* 361 */           BufferedReader inFromB = new BufferedReader(new InputStreamReader(sendSocketB.getInputStream()));
/* 362 */           inFromB.readLine();
/* 363 */           sendSocketB.close();
/*     */         }
/*     */         
/* 366 */         System.out.println("Peer " + peerID + " has left the network.");
/* 367 */         System.exit(0);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\cdht\cdht.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */