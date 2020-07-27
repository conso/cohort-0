import java.util.ArrayList;

public class Anagrams {
    public String solve(String input) {
        ArrayList<String> output = new ArrayList<String>();

        output = calculateAnagramsFor(input);

        return String.join(" ", output);
    }

    private ArrayList<String> calculateAnagramsFor(String input){
        ArrayList<String> output = new ArrayList<String>();
        if (input.length()==1) output.add(input);
        for(int i = 0; i < input.length(); i++) {
            String character = String.valueOf(input.charAt(i));
            String inputLeftover = this.removeCharAt(input, i);

            ArrayList<String> partialAnagrams = this.calculateAnagramsFor(inputLeftover);
            for (int x=0; x<partialAnagrams.size(); x++) {
                output.add(character + partialAnagrams.get(x));
            }
        }
        return output;
    }

    private ArrayList<String> anagramOfAny(String inputLeftover) {
        ArrayList<String> output = new ArrayList<String>();
        for (int l = 0; l<inputLeftover.length(); l++){
            output.add(String.valueOf(inputLeftover.charAt(l)));
        }
        return output;
    }

    private ArrayList<String> anagramOfTwo(String input) {
        ArrayList<String> output = new ArrayList<String>();
        output.add(input);
        output.add(this.reverse(input));
        return output;
    }

    private String removeCharAt(String input, int index) {
        StringBuilder sb = new StringBuilder(input);
        sb.deleteCharAt(index);
        return sb.toString();
    }

    private String reverse(String input) {
        String reverse = "";
        for(int i = input.length() - 1; i >= 0; i--) {
            reverse = reverse + input.charAt(i);
        }
        return reverse;
    }
}