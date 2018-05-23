import java.io.PrintStream;

final class cdht_ex$4
  extends Thread
{
  public void run()
  {
    M550437005(this);
  }
  
  protected static void M550437005(4 this)
  {
    for (;;)
    {
      try
      {
        Thread.currentThread();
        Thread.sleep(12000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        return;
      }
      if (cdht_ex.firstPingBack)
      {
        cdht_ex.firstPingBack = false;
      }
      else if (!cdht_ex.firstPingBack)
      {
        localInterruptedException = "ask " + cdht_ex.peerPort + " first\n";
        cdht_ex.TCPClient(localInterruptedException, cdht_ex.secondSuccessorPort);
        cdht_ex.firstPingBack = false;
        System.out.println("Peer " + cdht_ex.firstSuccessor + " is no longer alive.");
      }
      if (cdht_ex.secondPingBack)
      {
        cdht_ex.secondPingBack = false;
      }
      else if (!cdht_ex.secondPingBack)
      {
        localInterruptedException = "ask " + cdht_ex.peerPort + " second\n";
        cdht_ex.TCPClient(localInterruptedException, cdht_ex.firstSuccessorPort);
        cdht_ex.secondPingBack = false;
        System.out.println("Peer " + cdht_ex.secondSuccessor + " is no longer alive.");
      }
    }
  }
}


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex$4.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */