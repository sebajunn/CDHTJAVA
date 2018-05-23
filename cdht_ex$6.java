import java.io.PrintStream;
import java.util.Scanner;

final class cdht_ex$6
  extends Thread
{
  cdht_ex$6(Thread paramThread1, Thread paramThread2, Thread paramThread3, Thread paramThread4, Thread paramThread5) {}
  
  public void run()
  {
    6.M333218399(this);
  }
  
  protected static void M333218399(6 this)
  {
    Scanner localScanner = new Scanner(System.in);
    for (;;)
    {
      String str1 = localScanner.nextLine();
      if (str1.equals(""))
      {
        if ((cdht_ex.userInput) || (cdht_ex.requestFileMessage))
        {
          cdht_ex.userInput = false;
          cdht_ex.requestFileMessage = false;
          System.out.println("You have pressed enter key, ping messages are displayed again\n");
        }
        else if (!cdht_ex.userInput)
        {
          cdht_ex.userInput = true;
          System.out.println("You have pressed enter key, ping messages are hide\n");
        }
      }
      else
      {
        String str2;
        if (str1.equals("quit"))
        {
          str2 = "quit " + cdht_ex.peerIdentity + " " + cdht_ex.firstSuccessor + " " + cdht_ex.secondSuccessor + "\n";
          try
          {
            cdht_ex.TCPClient(str2, cdht_ex.firstSuccessorPort);
          }
          catch (Exception localException)
          {
            return;
          }
          try
          {
            Thread.currentThread();
            Thread.sleep(3000L);
          }
          catch (InterruptedException localInterruptedException)
          {
            return;
          }
          this.val$firstClient.interrupt();
          this.val$secondClient.interrupt();
          this.val$check.interrupt();
          if (cdht_ex.count == 2)
          {
            this.val$newServer.interrupt();
            this.val$requestFileServer.interrupt();
          }
        }
        else
        {
          localInterruptedException = str1.split(" ")[0];
          if (localInterruptedException.equals("request"))
          {
            String str3 = str1.split(" ")[1];
            int i = cdht_ex.stringToHash(str3);
            str2 = "request " + str3 + " " + i + " " + cdht_ex.peerIdentity + " " + cdht_ex.peerIdentity + "\n";
            try
            {
              cdht_ex.TCPClient(str2, cdht_ex.firstSuccessorPort);
            }
            catch (Exception localException1)
            {
              return;
            }
          }
        }
      }
    }
  }
}


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex$6.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */