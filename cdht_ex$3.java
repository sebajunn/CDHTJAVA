import java.net.DatagramPacket;
import java.net.DatagramSocket;

final class cdht_ex$3
  extends Thread
{
  public void run()
  {
    M637417425(this);
  }
  
  protected static void M637417425(3 this)
  {
    try
    {
      for (;;)
      {
        DatagramPacket localDatagramPacket = cdht_ex.UDPClient(cdht_ex.secondSuccessorPort);
        cdht_ex.UDPSocket.send(localDatagramPacket);
        Thread.currentThread();
        Thread.sleep(3000L);
      }
      return;
    }
    catch (Exception localException1) {}
  }
}


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex$3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */