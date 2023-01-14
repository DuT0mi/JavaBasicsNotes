import org.example.List;
import org.junit.*;
import org.junit.Assert.*;

import java.util.NoSuchElementException;

public class TestList {
    private List list = new List();
    @Before
    public void init(){
        list.add("Tommy");
        list.add("Alex");
    }

    @Test
    public void testSize(){
        Assert.assertEquals("Size checking",2,list.getSize());
    }
    @Test
    public void testIsEmpty(){
        Assert.assertFalse(list.isEmpty());
    }
    // Deleting an element which the List doesn't include
    @Test(expected = NoSuchElementException.class)
    public void remove(){
        list.remove("Me");
        // cause error, but it is not an error -> addition to the annotation
        // but now if we like'd to delete an existing element it will cause error

    }
}
