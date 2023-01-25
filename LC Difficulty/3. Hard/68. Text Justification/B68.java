import java.util.ArrayList;
import java.util.List;

class B68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // list to store the justified lines
        List<String> lines = new ArrayList<>();
        int index = 0;
        // loop through all the words
        while (index < words.length) {
            // count the length of words from index to last
            int count = words[index].length();
            int last = index + 1;
            // loop through the words and add them to the current line until maxWidth is reached
            while (last < words.length) {
                // check if adding the next word would exceed the max width
                if (words[last].length() + count + 1 > maxWidth)
                    break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if it is the last line or there is only one word in the line
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1)
                        builder.append(" ");
                }
                // add remaining spaces
                for (int i = builder.length(); i < maxWidth; i++) {
                    builder.append(" ");
                }
            } else {
                // calculate the number of spaces between words
                int spaces = (maxWidth - count) / diff;
                int r = (maxWidth - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        // add spaces with an extra space for the left over remainder
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            // add the current line to the list of lines
            lines.add(builder.toString());
            index = last;
        }
        return lines;
    }

}
