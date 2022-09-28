import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Exercise4Test {

    final String[] EMPTY_STRING_ARRAY = new String[0];

    @Test
    void testExercise4_Even() throws Exception {
        // Regular expression pattern for expected output
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter number\\W*"
            + "The number entered is even\\n*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("4")
                .execute(() -> {
                    Exercise4.main(EMPTY_STRING_ARRAY);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }

    @Test
    void testExercise4_Odd() throws Exception {
        // Regular expression pattern for expected output
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter number\\W*"
            + "The number entered is odd\\n*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE);
       
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("9")
                .execute(() -> {
                    Exercise4.main(EMPTY_STRING_ARRAY);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }    
}