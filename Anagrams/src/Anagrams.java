public class Anagrams {
    public String solve(String input) {
        if (input.length() == 1) { return input; }
        return input + " " + this.reverse(input);
    }

    private String reverse(String input) {
        String reverse = "";
        for(int i = input.length() - 1; i >= 0; i--) {
            reverse = reverse + input.charAt(i);
        }
        return reverse;
    }
}