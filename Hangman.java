import java.util.Random;
import java.util.Scanner;

//Игра в виселицу
public class Hangman {
    public static void main(String[] args) {
        String[] gallows = {"_______\n|/\n|\n|\n|\n|\n|\n|\n|\n|________",
                "_______\n|/\n|     ( )\n|\n|\n|\n|\n|\n|\n|________",
                "_______\n|/\n|     ( )\n|     _|_\n|\n|\n|\n|\n|\n|________",
                "_______\n|/\n|     ( )\n|     _|_\n|    /   \\\n|\n|\n|\n|\n|________",
                "_______\n|/\n|     ( )\n|     _|_\n|    / | \\\n|      |\n|\n|\n|\n|________",
                "_______\n|/\n|     ( )\n|     _|_\n|    / | \\\n|      |\n|     / \\\n|    /   \\\n|\n|________",
                "_______\n|/     |\n|     ( )\n|     _|_\n|    / | \\\n|      |\n|     / \\\n|    /   \\\n|\n|________",
        };

        String[] words = {"хроника", "кафель", "фильтр", "кондитер", "тетерев", "бальзам", "бревно", "самовар", "карабин",
                "подлокотник", "амфитеатр", "скворечник", "спичка", "характер", "фундамент", "бумажник", "комбинация",
                "процессор", "крышка", "сфинкс", "пассатижи", "леденец", "вращение", "клавиатура", "сегмент", "обещание",
                "магнитофон", "указатель", "мармелад", "копейка", "леопард", "аттракцион", "ошейник", "карамель", "дельфинарий"};

        while (true) {
            System.out.println("Нажмите Enter, чтобы начать новую игру, либо введите \"выход\", чтобы выйти из игры");
            Scanner scan = new Scanner(System.in);
            String in = scan.nextLine();
            if (in.equals("выход")) break;

            int mistakeCount = 6;
            Random random = new Random();
            String word = words[random.nextInt(words.length) - 1];
            StringBuilder shownWord = new StringBuilder();
            while (shownWord.length() != word.length()) shownWord.append("_");

            while (mistakeCount > -1 && shownWord.toString().contains("_")) {
                switch (mistakeCount) {
                    case 1, 5, 6 -> System.out.printf(shownWord + "\nВы можете ошибиться %d раз. Ваша буква?\n", mistakeCount);
                    case 2, 3, 4 -> System.out.printf(shownWord + "\nВы можете ошибиться %d раза. Ваша буква?\n", mistakeCount);
                    case 0 -> System.out.printf(shownWord + "\nВы больше не можете ошибаться. Ваша буква?\n");
                }
                String letter = String.valueOf(scan.next().charAt(0)).toLowerCase();
                if (word.contains(letter)) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == letter.charAt(0)) shownWord.replace(i, i+1, letter);
                    }
                }
                else {
                    System.out.println(gallows[gallows.length - 1 - mistakeCount]);
                    mistakeCount--;
                }
            }

            if (shownWord.toString().equals(word)) System.out.println("Поздравляем с победой!");
            else System.out.println("К сожалению, вы проиграли :(");
            System.out.println("Загаданное слово - "+word);
        }
    }
}
