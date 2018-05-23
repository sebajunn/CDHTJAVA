import java.net.DatagramPacket;
import java.net.DatagramSocket;

final class cdht_ex$2
  extends Thread
{
  public void run()
  {
    M240536415(this);
  }
  
  protected static void M240536415(2 this)
  {
    try
    {
      for (;;)
      {
        DatagramPacket localDatagramPacket = cdht_ex.UDPClient(cdht_ex.firstSuccessorPort);
        cdht_ex.UDPSocket.send(localDatagramPacket);
        Thread.currentThread();
        Thread.sleep(3000L);
      }
      return;
    }
    catch (Exception localException1) {}
  }
}


/* Location:              D:\COMP3331\obf\First\cdht_ex_obf.jar!\cdht_ex$2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */