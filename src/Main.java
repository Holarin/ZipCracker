    import java.io.*;
    import net.lingala.zip4j.ZipFile;

    public class Main {
        public Main() {
            try (FileReader reader = new FileReader("passes.txt")) {
                BufferedReader in = new BufferedReader(reader);
                String password = "";
                while (password != null) {
                    password = in.readLine();
                    try {
                        ZipFile zipFile = new ZipFile("hackme.zip");
                        zipFile.setPassword(password.toCharArray());
                        String directory = "NNN";
                        zipFile.extractAll(directory);
                        System.out.println("Пароль: " + password + " ПОДОШЁЛ");
                        break;
                    } catch (Exception e) {
                        System.out.println("Пароль: " + password + " НЕ ПОДОШЕЛ");
                    }
                }
                File file = new File("otvet.txt");
                FileWriter fileWriter = new FileWriter(file, true);
                assert password != null;
                fileWriter.write(password + System.getProperty("line.separator"));
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            new Main();
        }
    }