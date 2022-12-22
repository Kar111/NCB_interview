import com.example.ncb_tasks.Countries.SimpleMethods;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMethodsTest {
    private SimpleMethods simpleMethods;

    @Before
    public void setup() {
        simpleMethods = new SimpleMethods();
    }




    /////////////////////  Task 1  ////////////////////
    @Test
    public void shouldReturnEmptyStringWhenNoDuplicates() {

        //EXECUTE
        String response = simpleMethods.getDuplicates("absdefghijklmnop");
        //ASSERT
        assertEquals(response.length(), 0);
    }

    @Test
    public void shouldReturnStringOfDuplicateChars() {

        //EXECUTE
        String response = simpleMethods.getDuplicates("Welcome to Armenia");

        //ASSERT
        assertNotEquals(response.length(), 0);
        assertTrue(response.indexOf('W') < 0);
        assertTrue(response.indexOf('a') < 0);


        assertTrue(response.indexOf('e') >= 0);
        assertTrue(response.indexOf('o') >= 0);
        assertTrue(response.indexOf('m') >= 0);
        assertTrue(response.indexOf(' ') >= 0);

    }





    /////////////////////  Task 2 ////////////////////

    @Test
    public void shouldReturnTheSameMinAndMax() {
        //SETUP
        int array[] = new int[10];
        int number = 11;
        Arrays.fill(array, number);

        //EXECUTE
        int response[] = simpleMethods.findMinMax(array);

        //ASSERT
        assertEquals(response.length, 2);
        assertEquals(response[0], number); //min value
        assertEquals(response[1], number); //max value
    }

    @Test
    public void shouldReturnTheMinAndMax() {
        //SETUP
        int array[] = {6, 2, 6, 0, 111, 99};

        //EXECUTE
        int response[] = simpleMethods.findMinMax(array);

        //ASSERT
        assertEquals(response.length, 2);
        assertEquals(response[0], Arrays.stream(array).min().getAsInt()); //min value
        assertEquals(response[1], Arrays.stream(array).max().getAsInt()); //max value
    }





    /////////////////////  Task 3 ////////////////////

    @Test
    public void shouldReturnTheSumUpToNumber() {
        //SETUP
        int number = 10;

        //EXECUTE
        int response = simpleMethods.recursiveSum(number);

        //ASSERT
        assertEquals(response, (number * (number + 1)) / 2);
    }

}
