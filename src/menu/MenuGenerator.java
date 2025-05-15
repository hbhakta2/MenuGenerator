package menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A library to generate menu
 *
 * @author Hardikkumar Bhakta
 */
public class MenuGenerator {

    /**
     * MenuGenerator() constructor
     */
    public MenuGenerator() {
    }

    /**
     * Generates menu that can be used in common Java programs inside a print
     * statement
     *
     * @param title
     * @param subTitle
     * @param prompt
     * @param options
     * @return string formatted menu
     */
    public String generateMenu(String title, String subTitle, String prompt,
            String... options) {

        ArrayList<Integer> textSizes = new ArrayList<>();
        textSizes.add(title.length());
        textSizes.add(subTitle.length());
        textSizes.add(prompt.length());

        int offset = 4;
        for (String option : options) {
            textSizes.add(option.length() + offset);
        }

        Comparator sortIntegerByDescendingOrder = new SortIntegerByDescendingOrder();
        Collections.sort(textSizes, sortIntegerByDescendingOrder);

        int largest = textSizes.getFirst();
        int spacesValue = 0;
        int numberOfSpacesAwayFromRightMostCharacter = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(createStringWithAsterisksAndNewLine(largest + offset));
        spacesValue = largest - title.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("*  ").append(title).append(String.format("%" + spacesValue + "s", " ")).append("*\n");
        spacesValue = largest - subTitle.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("*  ").append(subTitle).append(String.format("%" + spacesValue + "s", " ")).append("*\n");
        spacesValue = largest - prompt.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("*  ").append(prompt).append(String.format("%" + spacesValue + "s", " ")).append("*\n");

        int innerOffSet = 2;
        for (int i = 0; i < options.length; i++) {
            spacesValue = largest - options[i].length() - innerOffSet;
            if (i < 9) {
                sb.append("*  ").append(i + 1).append(". ").append(options[i]).append(String.format("%" + spacesValue + "s", " ")).append("*\n");
            } else if (i >= 9 && i < 99) {
                sb.append("* ").append(i + 1).append(". ").append(options[i]).append(String.format("%" + spacesValue + "s", " ")).append("*\n");
            }
        }
        sb.append(createStringWithAsterisksAndNewLine(largest + offset));
        return sb.toString();
    }

    /**
     * Generates a menu that can be used inside a System.out.println("");
     * statement for common Java programs
     *
     * @param title
     * @param subTitle
     * @param prompt
     * @param options
     * @return string formatted menu
     */
    public String generateMenuEnclosedByDoWhileLoop(String title, String subTitle,
            String prompt, String... options) {

        ArrayList<Integer> textSizes = new ArrayList<>();
        textSizes.add(title.length());
        textSizes.add(subTitle.length());
        textSizes.add(prompt.length());

        int offset = 4;
        for (String option : options) {
            textSizes.add(option.length() + offset);
        }

        Comparator sortIntegerByDescendingOrder = new SortIntegerByDescendingOrder();
        Collections.sort(textSizes, sortIntegerByDescendingOrder);

        int largest = textSizes.getFirst();
        int spacesValue = 0;
        int numberOfSpacesAwayFromRightMostCharacter = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(createStringWithAsterisks(largest + offset));
        sb.append("\\n\"");
        spacesValue = largest - title.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("\n+ \"").append("*  ").append(title).append(String.format("%" + spacesValue + "s", " ")).append("*\\n\"");
        spacesValue = largest - subTitle.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("\n+ \"").append("*  ").append(subTitle).append(String.format("%" + spacesValue + "s", " ")).append("*\\n\"");
        spacesValue = largest - prompt.length() + numberOfSpacesAwayFromRightMostCharacter;
        sb.append("\n+ \"").append("*  ").append(prompt).append(String.format("%" + spacesValue + "s", " ")).append("*\\n\"");

        int innerOffSet = 2;
        for (int i = 0; i < options.length; i++) {
            spacesValue = largest - options[i].length() - innerOffSet;
            if (i < 9) {
                sb.append("\n+ \"").append("*  ").append(i + 1).append(". ").append(options[i]).append(String.format("%" + spacesValue + "s", " ")).append("*\\n\"");
            } else if (i >= 9 && i < 99) {
                sb.append("\n+ \"").append("* ").append(i + 1).append(". ").append(options[i]).append(String.format("%" + spacesValue + "s", " ")).append("*\\n\"");
            }
        }

        sb.append("\n+ \"");
        sb.append(createStringWithAsterisks(largest + offset));
        sb.append("\\n");
        return sb.toString();
    }

    /**
     * Helper method creates string which contains asterisks with a new line
     * character appended at the end
     *
     * @param length: the length of a string to be created
     * @return string
     */
    private String createStringWithAsterisksAndNewLine(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            sb.append("*");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Helper method creates string which contains asterisks
     *
     * @param length: the length of a string to be created
     * @return string
     */
    private String createStringWithAsterisks(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
