public class Reverse {
    public static void main(String[] args) {
        String name = "Sunishka";
        String reverse = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            reverse=reverse+name.charAt(i);
            System.out.println("the reverse string of "+name+"is :"+reverse);

        }
    }
}