public class UploadFileTest {
    public void test1() {
        String fileName = "abcdef.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
