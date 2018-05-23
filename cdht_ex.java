/*    */ import java.io.PrintStream;
/*    */ import java.net.DatagramPacket;
/*    */ 
/*    */ public class cdht_ex
/*    */ {
/*    */   static int base;
/*    */   static int peerIdentity;
/*    */   static int firstSuccessor;
/*    */   static int secondSuccessor;
/*    */   static int peerPort;
/*    */   static int firstSuccessorPort;
/*    */   static int secondSuccessorPort;
/* 13 */   static int count = 0;
/* 14 */   static boolean firstPingBack = false;
/* 15 */   static boolean secondPingBack = false;
/* 16 */   static boolean userInput = false;
/* 17 */   static boolean requestFileMessage = false;
/*    */   static java.net.DatagramSocket UDPSocket;
/*    */   
/*    */   public static DatagramPacket UDPClient(int paramInt)
/*    */     throws Exception
/*    */   {
/*    */     return M984841540(paramInt);
/*    */   }
/*    */   
/*    */   public static void UDPServer()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public static int stringToHash(String paramString)
/*    */   {
/*    */     return M128897150(paramString);
/*    */   }
/*    */   
/*    */   public static void TCPServer()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   public static void TCPClient(String paramString, int paramInt)
/*    */   {
/*    */     M964486860(paramString, paramInt);
/*    */   }
/*    */   
/*    */   public static void main(String[] paramArrayOfString)
/*    */     throws java.io.IOException
/*    */   {
/*    */     M625146363(paramArrayOfString);
/*    */   }
/*    */   
/*    */   protected static DatagramPacket M984841540(int arg0)
/*    */     throws Exception
/*    */   {
/*    */     String str = "Request";
/*    */     java.net.InetAddress localInetAddress = java.net.InetAddress.getByName("localhost");
/*    */     byte[] arrayOfByte = str.getBytes();
/*    */     DatagramPacket localDatagramPacket = new DatagramPacket(arrayOfByte, arrayOfByte.length, localInetAddress, arg0);
/*    */     return localDatagramPacket;
/*    */   }
/*    */   
/*    */   protected static void M941249179()
/*    */     throws Exception
/*    */   {
/*    */     int i = 0;
/*    */     int j = 0;
/*    */     String str = "Response";
/*    */     byte[] arrayOfByte1 = new byte['Ѐ'];
/*    */     byte[] arrayOfByte2 = str.getBytes();
/*    */     DatagramPacket localDatagramPacket1 = new DatagramPacket(arrayOfByte1, arrayOfByte1.length);
/*    */     for (;;)
/*    */     {
/*    */       UDPSocket.receive(localDatagramPacket1);
/*    */       int k = localDatagramPacket1.getPort();
/*    */       java.net.InetAddress localInetAddress = localDatagramPacket1.getAddress();
/*    */       DatagramPacket localDatagramPacket2 = new DatagramPacket(arrayOfByte2, arrayOfByte2.length, localInetAddress, k);
/*    */       if ((userInput) && (i == 0)) {
/*    */         i = 1;
/*    */       }
/*    */       if ((requestFileMessage) && (j == 0))
/*    */       {
/*    */         System.out.println("Ping messages are hide\n");
/*    */         j = 1;
/*    */       }
/*    */       if ((k != firstSuccessorPort) && (k != secondSuccessorPort))
/*    */       {
/*    */         UDPSocket.send(localDatagramPacket2);
/*    */         int m = k - base;
/*    */         if ((!userInput) && (!requestFileMessage)) {
/*    */           System.out.println("A ping request message was received from Peer " + m + ".");
/*    */         }
/*    */       }
/*    */       if (k == firstSuccessorPort)
/*    */       {
/*    */         if ((!userInput) && (!requestFileMessage)) {
/*    */           System.out.println("A ping response message was received from Peer " + firstSuccessor + ".");
/*    */         }
/*    */         firstPingBack = true;
/*    */       }
/*    */       if (k == secondSuccessorPort)
/*    */       {
/*    */         if ((!userInput) && (!requestFileMessage)) {
/*    */           System.out.println("A ping response message was received from Peer " + secondSuccessor + ".");
/*    */         }
/*    */         secondPingBack = true;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   protected static int M128897150(String arg0)
/*    */   {
/*    */     int i = Integer.parseInt(String.valueOf(arg0.charAt(0)));
/*    */     int j = Integer.parseInt(String.valueOf(arg0.charAt(1)));
/*    */     int k = Integer.parseInt(String.valueOf(arg0.charAt(2)));
/*    */     int m = Integer.parseInt(String.valueOf(arg0.charAt(3)));
/*    */     int n = (i * 1000 + j * 100 + k * 10 + m + 1) % 256;
/*    */     return n;
/*    */   }
/*    */   
/*    */   protected static void M23238122()
/*    */     throws Exception
/*    */   {
/*    */     java.net.ServerSocket localServerSocket = new java.net.ServerSocket(peerPort);
/*    */     for (;;)
/*    */     {
/*    */       java.net.Socket localSocket = localServerSocket.accept();
/*    */       java.io.BufferedReader localBufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(localSocket.getInputStream()));
/*    */       String str1 = localBufferedReader.readLine();
/*    */       String str2 = str1.split(" ")[0];
/*    */       int j;
/*    */       int n;
/*    */       int i1;
/*    */       if (str2.equals("quit"))
/*    */       {
/*    */         if (str1.split(" ")[1].equals("ok"))
/*    */         {
/*    */           count += 1;
/*    */           if (count == 2) {
/*    */             System.out.println("I can quit now.");
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/*    */           userInput = false;
/*    */           requestFileMessage = false;
/*    */           j = Integer.parseInt(str1.split(" ")[1]);
/*    */           if ((j != firstSuccessor) && (j != secondSuccessor))
/*    */           {
/*    */             TCPClient(str1 + "\n", firstSuccessorPort);
/*    */           }
/*    */           else
/*    */           {
/*    */             if (j != firstSuccessor) {
/*    */               TCPClient(str1 + "\n", firstSuccessorPort);
/*    */             }
/*    */             int k = Integer.parseInt(str1.split(" ")[2]);
/*    */             n = Integer.parseInt(str1.split(" ")[3]);
/*    */             if (firstSuccessor == j)
/*    */             {
/*    */               firstSuccessor = secondSuccessor == k ? n : k;
/*    */               i1 = firstSuccessor;
/*    */               firstSuccessor = secondSuccessor;
/*    */               secondSuccessor = i1;
/*    */             }
/*    */             else
/*    */             {
/*    */               secondSuccessor = firstSuccessor == k ? n : k;
/*    */             }
/*    */             firstSuccessorPort = base + firstSuccessor;
/*    */             secondSuccessorPort = base + secondSuccessor;
/*    */             TCPClient("quit ok " + peerIdentity + "\n", j + base);
/*    */             System.out.println(j + " " + peerIdentity);
/*    */             System.out.println("Peer " + j + " will depart from the network.");
/*    */             System.out.println("My first successor is now peer " + firstSuccessor);
/*    */             System.out.println("My second successor is now peer " + secondSuccessor);
/*    */           }
/*    */         }
/*    */       }
/*    */       else if (str2.equals("ask"))
/*    */       {
/*    */         requestFileMessage = false;
/*    */         j = Integer.parseInt(str1.split(" ")[1]);
/*    */         String str4 = str1.split(" ")[2];
/*    */         if (str4.equals("first")) {
/*    */           TCPClient("reponseAsk firstSuccessor " + firstSuccessor + "\n", j);
/*    */         } else {
/*    */           TCPClient("reponseAsk secondSuccessor " + secondSuccessor + "\n", j);
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/*    */         String str3;
/*    */         int m;
/*    */         if (str2.equals("reponseAsk"))
/*    */         {
/*    */           requestFileMessage = false;
/*    */           str3 = str1.split(" ")[1];
/*    */           m = Integer.parseInt(str1.split(" ")[2]);
/*    */           if (str3.equals("firstSuccessor"))
/*    */           {
/*    */             firstSuccessor = secondSuccessor;
/*    */             secondSuccessor = m;
/*    */             firstSuccessorPort = firstSuccessor + base;
/*    */             secondSuccessorPort = secondSuccessor + base;
/*    */             System.out.println("My first successor is now peer " + firstSuccessor);
/*    */             System.out.println("My second successor is now peer " + secondSuccessor);
/*    */           }
/*    */           else
/*    */           {
/*    */             secondSuccessor = m;
/*    */             secondSuccessorPort = secondSuccessor + base;
/*    */             System.out.println("My first successor is now peer " + firstSuccessor);
/*    */             System.out.println("My second successor is now peer " + secondSuccessor);
/*    */           }
/*    */         }
/*    */         else
/*    */         {
/*    */           requestFileMessage = true;
/*    */           str3 = str1.split(" ")[1];
/*    */           m = Integer.parseInt(str1.split(" ")[2]);
/*    */           n = Integer.parseInt(str1.split(" ")[3]);
/*    */           i1 = Integer.parseInt(str1.split(" ")[4]);
/*    */           if (str2.equals("Response"))
/*    */           {
/*    */             System.out.println("Received a response message from peer " + i1 + ", which has the file " + str3);
/*    */           }
/*    */           else
/*    */           {
/*    */             int i;
/*    */             if ((m == peerIdentity) || ((peerIdentity < m) && (firstSuccessor < m) && (peerIdentity > firstSuccessor)) || ((peerIdentity < m) && (firstSuccessor > m))) {
/*    */               i = 0;
/*    */             } else {
/*    */               i = 1;
/*    */             }
/*    */             if (i != 0)
/*    */             {
/*    */               TCPClient("Request " + str3 + " " + m + " " + n + " " + peerIdentity + "\n", firstSuccessorPort);
/*    */               System.out.println("File " + str3 + " is not stored here.\nFile request message has been forwarded to my successor.");
/*    */             }
/*    */             else
/*    */             {
/*    */               TCPClient("Response " + str3 + " " + m + " " + n + " " + peerIdentity + "\n", base + n);
/*    */               System.out.println("File " + str3 + " is stored here.\nA response message, destined for peer " + n + ", has been sent.");
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   protected static void M964486860(String arg0, int arg1)
/*    */   {
/*    */     try
/*    */     {
/*    */       java.net.Socket localSocket = new java.net.Socket("localhost", arg1);
/*    */       java.io.DataOutputStream localDataOutputStream = new java.io.DataOutputStream(localSocket.getOutputStream());
/*    */       localDataOutputStream.writeBytes(arg0);
/*    */     }
/*    */     catch (Exception localException1)
/*    */     {
/*    */       System.out.println("----Socket Create failed-----");
/*    */     }
/*    */   }
/*    */   
/*    */   protected static void M625146363(String[] arg0)
/*    */     throws java.io.IOException
/*    */   {
/*    */     peerIdentity = Integer.parseInt(arg0[0]);
/*    */     firstSuccessor = Integer.parseInt(arg0[1]);
/*    */     secondSuccessor = Integer.parseInt(arg0[2]);
/*    */     base = 50000;
/*    */     peerPort = base + peerIdentity;
/*    */     firstSuccessorPort = base + firstSuccessor;
/*    */     secondSuccessorPort = base + secondSuccessor;
/*    */     UDPSocket = new java.net.DatagramSocket(peerPort);
/*    */     final Thread local1 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         M730967787(this);
/*    */       }
/*    */       
/*    */       protected static void M730967787(1 this)
/*    */       {
/*    */         try
/*    */         {
/*    */           
/*    */         }
/*    */         catch (Exception localException) {}
/*    */       }
/*    */     };
/*    */     Thread local2 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         M240536415(this);
/*    */       }
/*    */       
/*    */       protected static void M240536415(2 this)
/*    */       {
/*    */         try
/*    */         {
/*    */           for (;;)
/*    */           {
/*    */             DatagramPacket localDatagramPacket = cdht_ex.UDPClient(cdht_ex.firstSuccessorPort);
/*    */             cdht_ex.UDPSocket.send(localDatagramPacket);
/*    */             Thread.currentThread();
/*    */             Thread.sleep(3000L);
/*    */           }
/*    */           return;
/*    */         }
/*    */         catch (Exception localException1) {}
/*    */       }
/*    */     };
/*    */     final Thread local3 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         M637417425(this);
/*    */       }
/*    */       
/*    */       protected static void M637417425(3 this)
/*    */       {
/*    */         try
/*    */         {
/*    */           for (;;)
/*    */           {
/*    */             DatagramPacket localDatagramPacket = cdht_ex.UDPClient(cdht_ex.secondSuccessorPort);
/*    */             cdht_ex.UDPSocket.send(localDatagramPacket);
/*    */             Thread.currentThread();
/*    */             Thread.sleep(3000L);
/*    */           }
/*    */           return;
/*    */         }
/*    */         catch (Exception localException1) {}
/*    */       }
/*    */     };
/*    */     final Thread local4 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         M550437005(this);
/*    */       }
/*    */       
/*    */       protected static void M550437005(4 this)
/*    */       {
/*    */         for (;;)
/*    */         {
/*    */           try
/*    */           {
/*    */             Thread.currentThread();
/*    */             Thread.sleep(12000L);
/*    */           }
/*    */           catch (InterruptedException localInterruptedException)
/*    */           {
/*    */             return;
/*    */           }
/*    */           if (cdht_ex.firstPingBack)
/*    */           {
/*    */             cdht_ex.firstPingBack = false;
/*    */           }
/*    */           else if (!cdht_ex.firstPingBack)
/*    */           {
/*    */             localInterruptedException = "ask " + cdht_ex.peerPort + " first\n";
/*    */             cdht_ex.TCPClient(localInterruptedException, cdht_ex.secondSuccessorPort);
/*    */             cdht_ex.firstPingBack = false;
/*    */             System.out.println("Peer " + cdht_ex.firstSuccessor + " is no longer alive.");
/*    */           }
/*    */           if (cdht_ex.secondPingBack)
/*    */           {
/*    */             cdht_ex.secondPingBack = false;
/*    */           }
/*    */           else if (!cdht_ex.secondPingBack)
/*    */           {
/*    */             localInterruptedException = "ask " + cdht_ex.peerPort + " second\n";
/*    */             cdht_ex.TCPClient(localInterruptedException, cdht_ex.firstSuccessorPort);
/*    */             cdht_ex.secondPingBack = false;
/*    */             System.out.println("Peer " + cdht_ex.secondSuccessor + " is no longer alive.");
/*    */           }
/*    */         }
/*    */       }
/*    */     };
/*    */     final Thread local5 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         M597545277(this);
/*    */       }
/*    */       
/*    */       protected static void M597545277(5 this)
/*    */       {
/*    */         try
/*    */         {
/*    */           
/*    */         }
/*    */         catch (Exception localException) {}
/*    */       }
/*    */     };
/*    */     Thread local6 = new Thread()
/*    */     {
/*    */       public void run()
/*    */       {
/*    */         6.M333218399(this);
/*    */       }
/*    */       
/*    */       protected static void M333218399(6 this)
/*    */       {
/*    */         java.util.Scanner localScanner = new java.util.Scanner(System.in);
/*    */         for (;;)
/*    */         {
/*    */           String str1 = localScanner.nextLine();
/*    */           if (str1.equals(""))
/*    */           {
/*    */             if ((cdht_ex.userInput) || (cdht_ex.requestFileMessage))
/*    */             {
/*    */               cdht_ex.userInput = false;
/*    */               cdht_ex.requestFileMessage = false;
/*    */               System.out.println("You have pressed enter key, ping messages are displayed again\n");
/*    */             }
/*    */             else if (!cdht_ex.userInput)
/*    */             {
/*    */               cdht_ex.userInput = true;
/*    */               System.out.println("You have pressed enter key, ping messages are hide\n");
/*    */             }
/*    */           }
/*    */           else
/*    */           {
/*    */             String str2;
/*    */             if (str1.equals("quit"))
/*    */             {
/*    */               str2 = "quit " + cdht_ex.peerIdentity + " " + cdht_ex.firstSuccessor + " " + cdht_ex.secondSuccessor + "\n";
/*    */               try
/*    */               {
/*    */                 cdht_ex.TCPClient(str2, cdht_ex.firstSuccessorPort);
/*    */               }
/*    */               catch (Exception localException)
/*    */               {
/*    */                 return;
/*    */               }
/*    */               try
/*    */               {
/*    */                 Thread.currentThread();
/*    */                 Thread.sleep(3000L);
/*    */               }
/*    */               catch (InterruptedException localInterruptedException)
/*    */               {
/*    */                 return;
/*    */               }
/*    */               this.val$firstClient.interrupt();
/*    */               local3.interrupt();
/*    */               local4.interrupt();
/*    */               if (cdht_ex.count == 2)
/*    */               {
/*    */                 local1.interrupt();
/*    */                 local5.interrupt();
/*    */               }
/*    */             }
/*    */             else
/*    */             {
/*    */               localInterruptedException = str1.split(" ")[0];
/*    */               if (localInterruptedException.equals("request"))
/*    */               {
/*    */                 String str3 = str1.split(" ")[1];
/*    */                 int i = cdht_ex.stringToHash(str3);
/*    */                 str2 = "request " + str3 + " " + i + " " + cdht_ex.peerIdentity + " " + cdht_ex.peerIdentity + "\n";
/*    */                 try
/*    */                 {
/*    */                   cdht_ex.TCPClient(str2, cdht_ex.firstSuccessorPort);
/*    */                 }
/*    */                 catch (Exception localException1)
/*    */                 {
/*    */                   return;
/*    */                 }
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     };
/*    */     local1.start();
/*    */     local2.start();
/*    */     local3.start();
/*    */     local4.start();
/*    */     local5.start();
/*    */     local6.start();
/*    */   }
/*    */ }


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */