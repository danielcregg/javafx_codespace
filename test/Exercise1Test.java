import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import java.util.Scanner;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import java.util.regex.Pattern;


public class Exercise1Test {

    final String[] EMPTY_STRING_ARRAY = new String[0];
    
    @Test
    @Disabled
    void application_writes_text_to_System_out() throws Exception {
    String text = tapSystemOut(() -> {
        System.out.print("some text");
    });
    assertEquals("some text", text);
    }

    @Test
    @Disabled
    void application_writes_mutliple_lines_to_System_out() throws Exception {
    String text = tapSystemOutNormalized(() -> {
        System.out.println("first line");
        System.out.println("second line");
    });
    assertEquals("first line\nsecond line\n", text);
    }

    @Test
    @Disabled
    void Scanner_reads_text_from_System_in(
    ) throws Exception {
    withTextFromSystemIn("first line", "second line")
        .execute(() -> {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        assertEquals("second line", scanner.nextLine());
        });
    }

    @Test
    void testExercise1() throws Exception {
        // \\W* matches one or more non-word characters (i.e. not [a-zA-Z_0-9])
        // (useful for variations in spacing, use of colons etc)
        String expectedOutput = "Enter an integer\\W*" 
            + "Number input was\\W*8\\W*";

        // Compiling the pattern with the CASE_INSENSITIVE flag will make the 
        // resulting matches case insensitive
        Pattern expectedPattern = Pattern.compile(expectedOutput, Pattern.CASE_INSENSITIVE); 
               
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("8")
                .execute(() -> {
                    Exercise1.main(EMPTY_STRING_ARRAY);
                });           
        });
        assertThat(output, matchesPattern(expectedPattern));
    }
}