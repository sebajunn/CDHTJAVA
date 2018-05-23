/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.ServerSocket;
/*     */ import java.net.Socket;
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
/*     */ public class DHT$TCP_Server
/*     */   extends Thread
/*     */ {
/*     */   public int fileN;
/*     */   public int hash;
/*     */   
/*     */   public DHT$TCP_Server(DHT this$0) {}
/*     */   
/* 473 */   public int requestFromClient = 1;
/* 474 */   public int forwardedByServer = 2;
/* 475 */   public int forwardedToServer = 2;
/* 476 */   public int hasFile = 3;
/* 477 */   public int operationCode = 0;
/*     */   
/* 479 */   public boolean file = false;
/*     */   
/*     */   public void run() {
/* 482 */     while ((!this.this$0.confirm1) || (!this.this$0.confirm2) || (!this.this$0.confirm3) || (!this.this$0.confirm4)) {
/* 483 */       String clientSentence = null;
/*     */       
/* 485 */       InetAddress clientAddress = null;
/*     */       
/* 487 */       Socket listenSocket = null;
/*     */       try {
/* 489 */         listenSocket = this.this$0.tcpServerSocket.accept();
/*     */       } catch (IOException localIOException) {}
/* 491 */       BufferedReader inFromClient = null;
/*     */       try {
/* 493 */         inFromClient = new BufferedReader(new InputStreamReader(listenSocket.getInputStream()));
/*     */       } catch (IOException localIOException1) {}
/*     */       try {
/* 496 */         clientSentence = inFromClient.readLine();
/*     */       } catch (IOException localIOException2) {}
/* 498 */       clientAddress = listenSocket.getInetAddress();
/* 499 */       InetAddress serverAddress = listenSocket.getInetAddress();
/*     */       
/* 501 */       int clientP = -1;
/* 502 */       int clientN = -1;
/* 503 */       int predecessorP = -1;
/* 504 */       int predecessorN = -1;
/* 505 */       String fileMessage = null;
/* 506 */       String quitMessage = null;
/* 507 */       String predecessorMessage = null;
/* 508 */       String[] splitFileMessage = null;
/* 509 */       String[] splitQuitMessage = null;
/* 510 */       String[] splitSentence = clientSentence.split(":");
/* 511 */       if ((splitSentence[0].equals("request")) || (splitSentence[0].equals("Request"))) {
/* 512 */         fileMessage = clientSentence;
/* 513 */         splitFileMessage = fileMessage.split(":");
/* 514 */         this.fileN = Integer.parseInt(splitFileMessage[1]);
/* 515 */         this.hash = (this.fileN % 256);
/* 516 */         this.operationCode = Integer.parseInt(splitFileMessage[2]);
/*     */         
/* 518 */         clientN = Integer.parseInt(splitFileMessage[3]);
/* 519 */         clientP = clientN + 50000;
/*     */         String sentSentence;
/* 521 */         if (this.this$0.peerN == this.hash)
/*     */         {
/*     */ 
/* 524 */           String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(this.this$0.peerN) + ":end";
/*     */           
/* 526 */           this.file = true;
/*     */         }
/* 528 */         else if ((this.this$0.peerN > this.hash) && (DHT.predecessor1 <= this.hash) && (DHT.predecessor2 <= this.hash))
/*     */         {
/*     */ 
/* 531 */           String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(this.this$0.peerN) + ":end";
/*     */           
/* 533 */           this.file = true;
/*     */         }
/* 535 */         else if ((this.this$0.peerN > this.hash) && (DHT.predecessor1 <= this.hash) && (DHT.predecessor2 > this.hash))
/*     */         {
/*     */ 
/* 538 */           String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(this.this$0.peerN) + ":end";
/*     */           
/* 540 */           this.file = true;
/*     */         }
/* 542 */         else if ((this.this$0.firstNode) && (this.hash > DHT.predecessor1) && (this.hash > DHT.predecessor2))
/*     */         {
/*     */ 
/* 545 */           String sentSentence = "file:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.hasFile) + ":" + Integer.toString(this.this$0.peerN) + ":end";
/*     */           
/* 547 */           this.file = true;
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 552 */           sentSentence = "request:" + Integer.toString(this.fileN) + ":" + Integer.toString(this.forwardedToServer) + ":" + Integer.toString(clientN) + ":end";
/*     */           
/* 554 */           this.file = false;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 560 */         if (this.file == true) {
/* 561 */           Socket replyToClient = null;
/*     */           try {
/* 563 */             replyToClient = new Socket(clientAddress, clientN + 50000);
/*     */           }
/*     */           catch (IOException localIOException3) {}
/* 566 */           DataOutputStream outToClient = null;
/*     */           try {
/* 568 */             outToClient = new DataOutputStream(replyToClient.getOutputStream());
/*     */           } catch (IOException localIOException4) {}
/* 570 */           String replyMessage = sentSentence;
/*     */           try {
/* 572 */             outToClient.writeBytes(replyMessage);
/*     */           } catch (IOException localIOException5) {}
/*     */           try {
/* 575 */             replyToClient.close();
/*     */           } catch (IOException localIOException6) {}
/* 577 */           System.out.println("File " + this.fileN + " is here.");
/* 578 */           System.out.println("A response message, destined for Peer " + clientN + ", has been sent.");
/*     */         }
/*     */         
/* 581 */         if (!this.file) {
/* 582 */           Socket forwardToServer = null;
/*     */           try {
/* 584 */             forwardToServer = new Socket(clientAddress, this.this$0.successor1 + 50000);
/*     */           } catch (IOException localIOException7) {}
/* 586 */           DataOutputStream outToServer = null;
/*     */           try {
/* 588 */             outToServer = new DataOutputStream(forwardToServer.getOutputStream());
/*     */           } catch (IOException localIOException8) {}
/* 590 */           String forwardMessage = sentSentence;
/*     */           try {
/* 592 */             outToServer.writeBytes(forwardMessage);
/*     */           } catch (IOException localIOException9) {}
/*     */           try {
/* 595 */             forwardToServer.close();
/*     */           } catch (IOException localIOException10) {}
/* 597 */           System.out.println("File " + this.fileN + " is not stored here.");
/* 598 */           System.out.println("File request message has been forwarded to my successor.");
/*     */         }
/*     */         
/*     */       }
/* 602 */       else if (splitSentence[0].equals("file"))
/*     */       {
/*     */ 
/*     */ 
/* 606 */         int filenumber = Integer.parseInt(splitSentence[1]);
/* 607 */         int serverN = Integer.parseInt(splitSentence[3]);
/* 608 */         if (Integer.parseInt(splitSentence[2]) == this.hasFile) {
/* 609 */           System.out.println("Received a response message from Peer " + serverN + ", which has the file " + filenumber + ".");
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */       }
/* 616 */       else if ((splitSentence[0].equals("quit")) || (splitSentence[0].equals("Quit"))) {
/* 617 */         quitMessage = clientSentence;
/* 618 */         splitQuitMessage = quitMessage.split(":");
/* 619 */         clientN = Integer.parseInt(splitQuitMessage[1]);
/* 620 */         int new1 = Integer.parseInt(splitQuitMessage[2]);
/* 621 */         int new2 = Integer.parseInt(splitQuitMessage[3]);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 627 */         if (clientN == this.this$0.successor1) {
/* 628 */           System.out.println("Peer " + clientN + " will depart from the network.");
/* 629 */           if (this.this$0.successor2 == new2) {
/* 630 */             this.this$0.successor1 = new1;
/* 631 */           } else if (this.this$0.successor2 == new1) {
/* 632 */             this.this$0.successor1 = new2;
/*     */           }
/* 634 */           int temp = this.this$0.successor1;
/* 635 */           this.this$0.successor1 = this.this$0.successor2;
/* 636 */           this.this$0.successor2 = temp;
/* 637 */           System.out.println("My first successor is now Peer " + this.this$0.successor1 + ".");
/* 638 */           System.out.println("My second successor is now Peer " + this.this$0.successor2 + ".");
/*     */           
/* 640 */           String confirmation = new String("confirmation1");
/* 641 */           Socket confirmSocket = null;
/*     */           try {
/* 643 */             confirmSocket = new Socket(serverAddress, clientN + 50000);
/*     */           } catch (IOException localIOException11) {}
/* 645 */           DataOutputStream confirm = null;
/*     */           try {
/* 647 */             confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*     */           } catch (IOException localIOException12) {}
/*     */           try {
/* 650 */             confirm.writeBytes(confirmation);
/*     */           } catch (IOException localIOException13) {}
/*     */           try {
/* 653 */             confirmSocket.close();
/*     */ 
/*     */ 
/*     */           }
/*     */           catch (IOException localIOException14) {}
/*     */ 
/*     */ 
/*     */         }
/* 661 */         else if (clientN == this.this$0.successor2) {
/* 662 */           System.out.println("Peer " + clientN + " will depart from the network.");
/* 663 */           this.this$0.successor2 = new1;
/* 664 */           System.out.println("My first successor is now Peer " + this.this$0.successor1 + ".");
/* 665 */           System.out.println("My second successor is now Peer " + this.this$0.successor2 + ".");
/*     */           
/* 667 */           String confirmation = new String("confirmation2");
/* 668 */           Socket confirmSocket = null;
/*     */           try {
/* 670 */             confirmSocket = new Socket(serverAddress, clientN + 50000);
/*     */           } catch (IOException localIOException15) {}
/* 672 */           DataOutputStream confirm = null;
/*     */           try {
/* 674 */             confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*     */           } catch (IOException localIOException16) {}
/*     */           try {
/* 677 */             confirm.writeBytes(confirmation);
/*     */           } catch (IOException localIOException17) {}
/*     */           try {
/* 680 */             confirmSocket.close();
/*     */           }
/*     */           catch (IOException localIOException18) {}
/* 683 */         } else if (clientN == DHT.predecessor1) {
/* 684 */           DHT.predecessor1 = DHT.predecessor2;
/* 685 */           DHT.predecessor2 = new2;
/*     */           
/* 687 */           String confirmation = new String("confirmation3");
/* 688 */           Socket confirmSocket = null;
/*     */           try {
/* 690 */             confirmSocket = new Socket(serverAddress, clientN + 50000);
/*     */           } catch (IOException localIOException19) {}
/* 692 */           DataOutputStream confirm = null;
/*     */           try {
/* 694 */             confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*     */           } catch (IOException localIOException20) {}
/*     */           try {
/* 697 */             confirm.writeBytes(confirmation);
/*     */           } catch (IOException localIOException21) {}
/*     */           try {
/* 700 */             confirmSocket.close();
/*     */           }
/*     */           catch (IOException localIOException22) {}
/* 703 */         } else if (clientN == DHT.predecessor2) {
/* 704 */           DHT.predecessor2 = new1;
/*     */           
/* 706 */           String confirmation = new String("confirmation4");
/* 707 */           Socket confirmSocket = null;
/*     */           try {
/* 709 */             confirmSocket = new Socket(serverAddress, clientN + 50000);
/*     */           } catch (IOException localIOException23) {}
/* 711 */           DataOutputStream confirm = null;
/*     */           try {
/* 713 */             confirm = new DataOutputStream(confirmSocket.getOutputStream());
/*     */           } catch (IOException localIOException24) {}
/*     */           try {
/* 716 */             confirm.writeBytes(confirmation);
/*     */           } catch (IOException localIOException25) {}
/*     */           try {
/* 719 */             confirmSocket.close();
/*     */ 
/*     */           }
/*     */           catch (IOException localIOException26) {}
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 727 */       else if (splitSentence[0].equals("requiresuccessor1")) {
/* 728 */         predecessorN = Integer.parseInt(splitSentence[1]);
/* 729 */         predecessorP = predecessorN + 50000;
/*     */         
/* 731 */         String replyPredecessor = "replysuccessor1:" + Integer.toString(this.this$0.successor1) + ":end";
/*     */         
/* 733 */         if (predecessorN == DHT.predecessor2) {
/* 734 */           DHT.predecessor1 = predecessorN;
/* 735 */           DHT.predecessor2 = Integer.parseInt(splitSentence[2]);
/*     */         }
/* 737 */         Socket replyPredecessorSocket = null;
/*     */         try {
/* 739 */           replyPredecessorSocket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*     */         } catch (IOException localIOException27) {}
/* 741 */         DataOutputStream outToServer = null;
/*     */         try {
/* 743 */           outToServer = new DataOutputStream(replyPredecessorSocket.getOutputStream());
/*     */         } catch (IOException localIOException28) {}
/*     */         try {
/* 746 */           outToServer.writeBytes(replyPredecessor);
/*     */         } catch (IOException localIOException29) {}
/*     */         try {
/* 749 */           replyPredecessorSocket.close();
/*     */         }
/*     */         catch (IOException localIOException30) {}
/*     */         
/* 753 */         String informString = "changepredecessor2:" + Integer.toString(DHT.predecessor1) + ":end";
/*     */         
/* 755 */         Socket informSuccessor1Socket = null;
/*     */         try {
/* 757 */           informSuccessor1Socket = new Socket(serverAddress, this.this$0.successor1 + 50000);
/*     */         } catch (IOException localIOException31) {}
/* 759 */         DataOutputStream informSuccessor = null;
/*     */         try {
/* 761 */           informSuccessor = new DataOutputStream(informSuccessor1Socket.getOutputStream());
/*     */         } catch (IOException localIOException32) {}
/*     */         try {
/* 764 */           informSuccessor.writeBytes(informString);
/*     */         } catch (IOException localIOException33) {}
/*     */         try {
/* 767 */           informSuccessor1Socket.close();
/*     */         }
/*     */         catch (IOException localIOException34) {}
/* 770 */       } else if (splitSentence[0].equals("changepredecessor2")) {
/* 771 */         DHT.predecessor2 = Integer.parseInt(splitSentence[1]);
/*     */       }
/* 773 */       else if (splitSentence[0].equals("replysuccessor1")) {
/* 774 */         this.this$0.successor2 = Integer.parseInt(splitSentence[1]);
/* 775 */         this.this$0.successorFull = true;
/* 776 */         System.out.println("My second successor is now peer " + this.this$0.successor2 + ".");
/*     */         
/* 778 */         String inform = "successor2lost";
/* 779 */         Socket informPredecessor1Socket = null;
/*     */         try {
/* 781 */           informPredecessor1Socket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*     */         } catch (IOException localIOException35) {}
/* 783 */         DataOutputStream informSuccessor = null;
/*     */         try {
/* 785 */           informSuccessor = new DataOutputStream(informPredecessor1Socket.getOutputStream());
/*     */         } catch (IOException localIOException36) {}
/*     */         try {
/* 788 */           informSuccessor.writeBytes(inform);
/*     */         } catch (IOException localIOException37) {}
/*     */         try {
/* 791 */           informPredecessor1Socket.close();
/*     */         }
/*     */         catch (IOException localIOException38) {}
/* 794 */       } else if (splitSentence[0].equals("successor2lost")) {
/* 795 */         this.this$0.successorFull = false;
/* 796 */         System.out.println("Peer " + this.this$0.successor2 + " is no longer alive.");
/* 797 */         System.out.println("My first successor is now peer " + this.this$0.successor1 + ".");
/*     */         
/* 799 */         Socket peerfindingSocket = null;
/*     */         try {
/* 801 */           peerfindingSocket = new Socket(serverAddress, this.this$0.successor1 + 50000);
/*     */         } catch (IOException localIOException39) {}
/* 803 */         DataOutputStream outToServer = null;
/*     */         try {
/* 805 */           outToServer = new DataOutputStream(peerfindingSocket.getOutputStream());
/*     */         }
/*     */         catch (IOException localIOException40) {}
/*     */         
/* 809 */         String sentSentence1 = "requiresuccessor2:" + Integer.toString(this.this$0.peerN) + ":end";
/*     */         try
/*     */         {
/* 812 */           outToServer.writeBytes(sentSentence1);
/*     */         } catch (IOException localIOException41) {}
/*     */         try {
/* 815 */           peerfindingSocket.close();
/*     */         }
/*     */         catch (IOException localIOException42) {}
/* 818 */       } else if (splitSentence[0].equals("requiresuccessor2")) {
/* 819 */         predecessorN = Integer.parseInt(splitSentence[1]);
/* 820 */         predecessorP = predecessorN + 50000;
/*     */         
/* 822 */         String replyPredecessor = "replysuccessor2:" + Integer.toString(this.this$0.successor1) + ":end";
/*     */         
/* 824 */         Socket replyPredecessorSocket = null;
/*     */         try {
/* 826 */           replyPredecessorSocket = new Socket(serverAddress, DHT.predecessor1 + 50000);
/*     */         } catch (IOException localIOException43) {}
/* 828 */         DataOutputStream outToServer = null;
/*     */         try {
/* 830 */           outToServer = new DataOutputStream(replyPredecessorSocket.getOutputStream());
/*     */         } catch (IOException localIOException44) {}
/*     */         try {
/* 833 */           outToServer.writeBytes(replyPredecessor);
/*     */         } catch (IOException localIOException45) {}
/*     */         try {
/* 836 */           replyPredecessorSocket.close();
/*     */         }
/*     */         catch (IOException localIOException46) {}
/* 839 */       } else if (splitSentence[0].equals("replysuccessor2")) {
/* 840 */         this.this$0.successor2 = Integer.parseInt(splitSentence[1]);
/* 841 */         this.this$0.successorFull = true;
/* 842 */         System.out.println("My second successor is now peer " + this.this$0.successor2 + ".");
/*     */       }
/* 844 */       else if (splitSentence[0].equals("confirmation1")) {
/* 845 */         this.this$0.confirm1 = true;
/*     */       }
/* 847 */       else if (splitSentence[0].equals("confirmation2")) {
/* 848 */         this.this$0.confirm2 = true;
/*     */       }
/* 850 */       else if (splitSentence[0].equals("confirmation3")) {
/* 851 */         this.this$0.confirm3 = true;
/*     */       }
/* 853 */       else if (splitSentence[0].equals("confirmation4")) {
/* 854 */         this.this$0.confirm4 = true;
/*     */       }
/*     */       else {
/* 857 */         System.out.println("Unrecognised message received by TCP server.");
/* 858 */         System.out.println(clientSentence);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\COMP3331\NonObf\cdht_obf.jar!\DHT$TCP_Server.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */