import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class myClient {
   // public static final Object lock = new Object();
    
    public static void main(String[] args) throws InterruptedException {
        Socket s;
        DataInputStream dis;
        DataOutputStream dos;
    
        ArrayList<String> message = new ArrayList<>();
        message.add(msgeData.cmsge1);
        message.add(msgeData.cmsge2);
        message.add(msgeData.cmsge3);
        message.add(msgeData.cmsge4);
        message.add(msgeData.cmsge5);
        message.add(msgeData.cmsge6);
        message.add(msgeData.cmsge7);
        message.add(msgeData.cmsge8);

        System.out.println(message);
       // byte[] byteArrray = cmsge1.getBytes();
        System.out.println("Client has Started.......");
        try {
             s=new Socket("localhost",44444);
             System.out.println("clint connected..");
            dis=new DataInputStream(s.getInputStream());
            dos=new DataOutputStream(s.getOutputStream());

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            for (String string : message) {
               // byte[] byteArrray = string.getBytes();
               buffer.clear();
               buffer.put(string.getBytes());
               buffer.flip();

               while (buffer.hasRemaining()) {
                dos.write(buffer.get());
            }
                //dos.write(byteArrray); 
                System.out.println("from server: "+(char)dis.readByte());
            }
            //dos.write(byteArrray);
           // dos.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            System.out.println("this is wn known HostException from client"+" kkkkk "+e);
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("this is wn known IOException from client"+" kkkkk "+e);
            e.printStackTrace();
        }
        }
}