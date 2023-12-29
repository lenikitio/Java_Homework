public class Notebook {
    int RAM;
    int HDD;
    String OS;
    String color;
    String producer;
    int price;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Notebook) {
            Notebook note = (Notebook) obj;
            return RAM == note.RAM && HDD == note.HDD && OS.equals(note.OS)
            && color.equals(note.color) && producer.equals(producer) && price == note.price;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ОЗУ: " + RAM + ", " + "Объем ЖД: " + HDD + ", " + "Операционная система: " + OS + ", " + "Цвет: " + color + ", " + "Производитель: " + producer + ", " + "Цена: " + price;
    }
    
}
