package modelTest;

import model2.*;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class EntityTestingSuite {

    @Ignore
    @Test
    public void itemTest()
    {
        ModelDao modelDao = new ModelDao();
        Item item = new Item("name", "oiefjosijdf ");
        modelDao.persistEntity(item);
    }

    @Test
    public void fullAppTest()
    {
        ModelDao modelDao = new ModelDao();

        Student student = new Student("Andrew", "Test", "TestNewtEST");
        Student newStudent = new Student("ASDASD", "lastname", "testlastnameemail");

        Message message = new Message("Hello, this message printed by Andrew Test");
        Message newMessage = new Message("new message by Andrew test");
        Message message1 = new Message("asojdijeoifeaf");
        Message message2 = new Message("oaiedj  q[wdl[pxscl[pslrv.sef");

        Item itemOne = new Item("myPhoto", "efpkjsapeof kspok osipjrg ojhsapogse ruifjWE RJMOSED ");
        Item itemTwo = new Item("spodfk", "siejfiposajefois imfg iosdfmom ");
        Item itemthree = new Item("poksdf", "soipejfowqkv09we4jkv809csjdcs 8094f");
        Item itemFour = new Item("item 4", " wpoekfpoakwe kas-0 fk");

        itemthree.addImage("images/testImageOne.jpg");

        student.addMessage(message);
        student.addMessage(newMessage);
        newStudent.addMessage(message1);
        newStudent.addMessage(message2);
        student.addItem(itemOne);
        student.addItem(itemTwo);
        newStudent.addItem(itemFour);
        newStudent.addItem(itemthree);

        modelDao.saveEntity(student);
        modelDao.saveEntity(newStudent);

        modelDao.removeMessage(2);
        modelDao.removeStudent(1);

        System.out.println(modelDao.getMessage(3).getSendingDate());

        assertNotNull(modelDao.getStudent(2));
        assertNotNull(modelDao.getMessage(3));
        assertNotNull(modelDao.getItem(3));

        assertNull(modelDao.getStudent(1));
        assertNull(modelDao.getItem(1));
        assertNull(modelDao.getMessage(1));
    }

}
