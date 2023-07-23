package hangman;

import java.util.Random;
import java.util.Scanner;

//���� � ��������
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

        String[] words = {"�������", "������", "������", "��������", "�������", "�������", "������", "�������", "�������",
                "�����������", "���������", "����������", "������", "��������", "���������", "��������", "����������",
                "���������", "������", "������", "���������", "�������", "��������", "����������", "�������", "��������",
                "����������", "���������", "��������", "�������", "�������", "����������", "�������", "��������", "�����������"};

        while (true) {
            System.out.println("������� Enter, ����� ������ ����� ����, ���� ������� \"�����\", ����� ����� �� ����");
            Scanner scan = new Scanner(System.in);
            String in = scan.nextLine();
            if (in.equals("�����")) break;

            int mistakeCount = 6;
            Random random = new Random();
            String word = words[random.nextInt(words.length) - 1];
            StringBuilder shownWord = new StringBuilder();
            while (shownWord.length() != word.length()) shownWord.append("_");

            while (mistakeCount > -1 && shownWord.toString().contains("_")) {
                switch (mistakeCount) {
                    case 1, 5, 6 -> System.out.printf(shownWord + "\n�� ������ ��������� %d ���. ���� �����?\n", mistakeCount);
                    case 2, 3, 4 -> System.out.printf(shownWord + "\n�� ������ ��������� %d ����. ���� �����?\n", mistakeCount);
                    case 0 -> System.out.printf(shownWord + "\n�� ������ �� ������ ���������. ���� �����?\n");
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

            if (shownWord.toString().equals(word)) System.out.println("����������� � �������!");
            else System.out.println("� ���������, �� ��������� :(");
            System.out.println("���������� ����� - "+word);
        }
    }
}
