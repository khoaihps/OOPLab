package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc junglgDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap1(junglgDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + junglgDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(junglgDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + junglgDVD.getTitle());
    }

    // swap by instruction in the document
    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    // swap method that can actually swap 2 objects
    public static void swap1(DigitalVideoDisc o1, DigitalVideoDisc o2) {
        DigitalVideoDisc temp = new DigitalVideoDisc(o1.getTitle(), o1.getCategory(), o1.getDirector(), o1.getLength(), o1.getCost());
        temp.setId(o1.getId());

        o1.setId(o2.getId());
        o1.setTitle(o2.getTitle());
        o1.setCategory(o2.getCategory());
        o1.setDirector(o2.getDirector());
        o1.setLength(o2.getLength());
        o1.setCost(o2.getCost());

        o2.setId(temp.getId());
        o2.setTitle(temp.getTitle());
        o2.setCategory(temp.getCategory());
        o2.setDirector(temp.getDirector());
        o2.setLength(o2.getLength());
        o2.setCost(o2.getCost());
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
