public class Alphabets_Aplhanumerics {
    public static void main(String[] args) {
        String input="1245swapna6789radharapu";
        System.out.println(input);
        System.out.println(input.replaceAll( "[0-9]",""));
        System.out.println(input.replaceAll( "[^0-9]",""));

    }
}
