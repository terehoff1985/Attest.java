package Attest;
import java.util.*;

public class Notebook {
    private String модель;
    private int объемОЗУ;
    private int объемЖД;
    private String операционнаяСистема;
    private String цвет;

    public Notebook(String модель, int объемОЗУ, int объемЖД, String операционнаяСистема, String цвет) {
        this.модель = модель;
        this.объемОЗУ = объемОЗУ;
        this.объемЖД = объемЖД;
        this.операционнаяСистема = операционнаяСистема;
        this.цвет = цвет;
    }

    public String getМодель() {
        return модель;
    }

    public int getОбъемОЗУ() {
        return объемОЗУ;
    }

    public int getОбъемЖД() {
        return объемЖД;
    }

    public String getОперационнаяСистема() {
        return операционнаяСистема;
    }

    public String getЦвет() {
        return цвет;
    }

    public static void main(String[] args) {
        Set<Notebook> Notebookи = new HashSet<>();
        Notebookи.add(new Notebook("Модель 1", 8, 512, "Windows", "Черный"));
        Notebookи.add(new Notebook("Модель 2", 12, 750, "Linux", "Серый"));
        Notebookи.add(new Notebook("Модель 3", 16, 1024, "MacOS", "Серебристый"));
        
      

        Map<String, String> критерии = new HashMap<>();
        критерии.put("1", "объемОЗУ");
        критерии.put("2", "объемЖД");
        

       

        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> параметрыФильтрации = new HashMap<>();
        for (Map.Entry<String, String> entry : критерии.entrySet()) {
            System.out.println("Введите минимальное значение для " + entry.getValue() + ":");
            параметрыФильтрации.put(entry.getValue(), scanner.nextInt());
        }

        for (Notebook Notebook : Notebookи) {
            boolean проходитПоУсловиям = true;
            for (Map.Entry<String, Integer> entry : параметрыФильтрации.entrySet()) {
                if (entry.getKey().equals("объемОЗУ") && Notebook.getОбъемОЗУ() < entry.getValue()) {
                    проходитПоУсловиям = false;
                    break;
                }
                if (entry.getKey().equals("объемЖД") && Notebook.getОбъемЖД() < entry.getValue()) {
                    проходитПоУсловиям = false;
                    break;
                }
            }
            if (проходитПоУсловиям) {
                System.out.println("Найден Notebook: " + Notebook.getМодель());
            }
        }
    }
}

