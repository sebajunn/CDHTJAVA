/*      */ import java.io.DataOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.net.InetAddress;
/*      */ import java.net.Socket;
/*      */ import java.net.UnknownHostException;
/*      */ import java.util.Scanner;
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
/*      */ public class DHT$TCP_Client
/*      */   extends Thread
/*      */ {
/*      */   public int fileN;
/*      */   public int hash;
/*      */   
/*      */   public DHT$TCP_Client(DHT this$0) {}
/*      */   
/*  874 */   public int requestFromClient = 1;
/*  875 */   public int forwardedByServer = 2;
/*  876 */   public int forwardedToServer = 2;
/*  877 */   public int hasFile = 3;
/*  878 */   public int clientP = 50000 + this.this$0.peerN;
/*  879 */   public boolean fileRequest = false;
/*  880 */   public boolean gracefulLeave = false;
/*      */   
/*      */   public void run() {
/*  883 */     while ((!this.this$0.confirm1) || (!this.this$0.confirm2) || (!this.this$0.confirm3) || (!this.this$0.confirm4))
/*      */     {
/*      */ 
/*  886 */       Scanner scan = new Scanner(System.in);
/*  887 */       while ((!this.this$0.confirm1) || (!this.this$0.confirm2) || (!this.this$0.confirm3) || (!this.this$0.confirm4)) {
/*  888 */         String clientOrder = scan.nextLine();
/*  889 */         String[] splitSentence = clientOrder.split(" ");
/*  890 */         if ((splitSentence[0].equals("request")) || (splitSentence[0].equals("Request"))) {
/*  891 */           this.fileN = Integer.parseInt(splitSentence[1]);
/*  892 */           if ((this.fileN >= 0) && (this.fileN <= 9999)) {
/*  893 */             this.fileRequest = true;
/*  894 */             this.hash = (this.fileN % 256);
/*  895 */             break;
/*      */           }
/*      */         } else {
/*  898 */           if ((splitSentence[0].equals("quit")) || (splitSentence[0].equals("Quit"))) {
/*  899 */             this.gracefulLeave = true;
/*  900 */             break;
/*      */           }
/*      */           
/*  903 */           System.out.println("Invalid input or a wrong file number, this node can only request a file or do a graceful leaving, please try again!");
/*      */         }
/*      */       }
/*  906 */       if (this.fileRequest)
/*      */       {
/*  908 */         InetAddress serverAddress = null;
/*      */         try {
/*  910 */           serverAddress = InetAddress.getLocalHost();
/*      */         }
/*      */         catch (UnknownHostException localUnknownHostException) {}
/*  913 */         Socket clientSocket = null;
/*      */         try {
/*  915 */           clientSocket = new Socket(serverAddress, this.this$0.successor1 + 50000);
/*      */         } catch (IOException localIOException) {}
/*  917 */         DataOutputStream outToServer = null;
/*      */         try {
/*  919 */           outToServer = new DataOutputStream(clientSocket.getOutputStream());
/*      */         }
/*      */         catch (IOException localIOException1) {}
/*      */         
/*      */ 
/*  924 */         String sentSentence = "request:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.requestFromClient) + ":" + Integer.toString(this.this$0.peerN) + ":end";
/*      */         
/*      */         try
/*      */         {
/*  928 */           outToServer.writeBytes(sentSentence);
/*      */         } catch (IOException localIOException2) {}
/*      */         try {
/*  931 */           clientSocket.close();
/*      */         } catch (IOException localIOException3) {}
/*  933 */         System.out.println("File request message for " + this.fileN + " has been sent to my successor.");
/*      */ 
/*      */       }
/*  936 */       else if (this.gracefulLeave)
/*      */       {
/*      */ 
/*      */ 
/*  940 */         InetAddress serverAddress = null;
/*      */         try {
/*  942 */           serverAddress = InetAddress.getLocalHost();
/*      */         }
/*      */         catch (UnknownHostException localUnknownHostException1) {}
/*      */         
/*      */ 
/*  947 */         String sentSentence = "quit:" + Integer.toString(this.this$0.peerN) + ":" + Integer.toString(this.this$0.successor1) + ":" + Integer.toString(this.this$0.successor2) + ":end";
/*      */         
/*      */ 
/*  950 */         Socket clientSocket1 = null;
/*      */         try {
/*  952 */           clientSocket1 = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*      */         } catch (IOException localIOException4) {}
/*  954 */         DataOutputStream outToServer1 = null;
/*      */         try {
/*  956 */           outToServer1 = new DataOutputStream(clientSocket1.getOutputStream());
/*      */         } catch (IOException localIOException5) {}
/*      */         try {
/*  959 */           outToServer1.writeBytes(sentSentence);
/*      */         } catch (IOException localIOException6) {}
/*      */         try {
/*  962 */           clientSocket1.close();
/*      */         }
/*      */         catch (IOException localIOException7) {}
/*  965 */         Socket clientSocket2 = null;
/*      */         try {
/*  967 */           clientSocket2 = new Socket(serverAddress, DHT.predecessor2 + 50000);
/*      */         } catch (IOException localIOException8) {}
/*  969 */         DataOutputStream outToServer2 = null;
/*      */         try {
/*  971 */           outToServer2 = new DataOutputStream(clientSocket2.getOutputStream());
/*      */         } catch (IOException localIOException9) {}
/*      */         try {
/*  974 */           outToServer2.writeBytes(sentSentence);
/*      */         } catch (IOException localIOException10) {}
/*      */         try {
/*  977 */           clientSocket2.close();
/*      */         }
/*      */         catch (IOException localIOException11) {}
/*      */         
/*      */ 
/*      */ 
/*  983 */         sentSentence = "quit:" + Integer.toString(this.this$0.peerN) + ":" + Integer.toString(DHT.predecessor1) + ":" + Integer.toString(DHT.predecessor2) + ":end";
/*      */         
/*  985 */         Socket clientSocket3 = null;
/*      */         try {
/*  987 */           clientSocket3 = new Socket(serverAddress, this.this$0.successor1 + 50000);
/*      */         } catch (IOException localIOException12) {}
/*  989 */         DataOutputStream outToServer3 = null;
/*      */         try {
/*  991 */           outToServer3 = new DataOutputStream(clientSocket3.getOutputStream());
/*      */         } catch (IOException localIOException13) {}
/*      */         try {
/*  994 */           outToServer3.writeBytes(sentSentence);
/*      */         } catch (IOException localIOException14) {}
/*      */         try {
/*  997 */           clientSocket3.close();
/*      */         }
/*      */         catch (IOException localIOException15) {}
/* 1000 */         Socket clientSocket4 = null;
/*      */         try {
/* 1002 */           clientSocket4 = new Socket(serverAddress, this.this$0.successor2 + 50000);
/*      */         } catch (IOException localIOException16) {}
/* 1004 */         DataOutputStream outToServer4 = null;
/*      */         try {
/* 1006 */           outToServer4 = new DataOutputStream(clientSocket4.getOutputStream());
/*      */         } catch (IOException localIOException17) {}
/*      */         try {
/* 1009 */           outToServer4.writeBytes(sentSentence);
/*      */         } catch (IOException localIOException18) {}
/*      */         try {
/* 1012 */           clientSocket4.close();
/*      */         }
/*      */         catch (IOException localIOException19) {}
/*      */       } else {
/* 1016 */         System.out.println("Unrecognised message in TCP client.");
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\DHT$TCP_Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */