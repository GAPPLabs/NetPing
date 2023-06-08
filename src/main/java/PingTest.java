
import java.io.BufferedReader;
import java.io.InputStreamReader;



public class PingTest {
    public static void runSystemCommand(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));

            String s = "";
            // reading output stream of the command
            while ((s = inputStream.readLine()) != null) {
                System.out.println(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String ip = "www.example.com"; //Any IP Address on your network / Web
        runSystemCommand("ping " + ip);
    }
}
