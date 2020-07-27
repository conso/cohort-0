import java.util.ArrayList;

public class Anagrams {
    public String solve(String input) {
        ArrayList<String> output;
        output = calculateAnagramsFor(input);
        return String.join(" ", output);
    }

    private ArrayList<String> calculateAnagramsFor(String input){
        ArrayList<String> output = new ArrayList<>();
        if (input.length()==1) output.add(input); //exit condition for recursion

        for(int i = 0; i < input.length(); i++) {
            String character = String.valueOf(input.charAt(i));
            String inputLeftover = this.removeCharAt(input, i);
            ArrayList<String> partialAnagrams = this.calculateAnagramsFor(inputLeftover);

            for (String partialAnagram : partialAnagrams) {
                output.add(character + partialAnagram);
            }
        }
        return output;
    }

    private String removeCharAt(String input, int index) {
        StringBuilder sb = new StringBuilder(input);
        sb.deleteCharAt(index);
        return sb.toString();
    }

}