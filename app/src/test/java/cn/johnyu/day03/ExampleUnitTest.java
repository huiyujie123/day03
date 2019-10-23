package cn.johnyu.day03;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test1() throws Exception{
        Socket socket=new Socket("www.baidu.com",80);
       OutputStream outputStream= socket.getOutputStream();
        InputStream inputStream=socket.getInputStream();

       outputStream.write("GET / HTTP/1.1\n".getBytes());
        outputStream.write("Host: www.baidu.com\n\n".getBytes());
        byte[] buf=new byte[1512];
        inputStream.read(buf);

        inputStream.close();
        outputStream.close();
        socket.close();
        String s=new String(buf);
        System.out.println(s);
    }
    @Test
    public void test3(){
        User user1=new User();
        user1.setId(1);
        user1.setName("john");
        user1.getTels().add(123);
        user1.getTels().add(234);


        User user2=new User();
        user2.setId(1);
        user2.setName("tom");
        user2.getTels().add(110);
        user2.getTels().add(119);

        List<User> users=new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Gson gson=new Gson();
        String s1=gson.toJson(users);
        System.out.println(s1);
        String s2=gson.toJson(user1);


      User u1=  gson.fromJson(s2,User.class);
        System.out.println(u1.getName());
        System.out.println(u1.getTels().get(0));

       ArrayList<User> us= gson.fromJson(s1,new TypeToken<ArrayList<User>>(){}.getType());
        for (User u:
             us) {
            System.out.println(u.getName()+"\t"+u.getTels().get(0));
        }

    }
}

