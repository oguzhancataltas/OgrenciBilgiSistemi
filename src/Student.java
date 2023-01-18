public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int matVerbal, int fizik, int fizikVerbal, int kimya, int kimyaVerval) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }
        if (matVerbal >= 0 && matVerbal <= 100) {
            this.mat.verbalNote = matVerbal;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }
        if (fizikVerbal >= 0 && fizikVerbal <= 100) {
            this.fizik.verbalNote = fizikVerbal;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }
        if (kimyaVerval >= 0 && kimyaVerval <= 100) {
            this.kimya.verbalNote = kimyaVerval;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.avarage = (this.fizik.commonAvarage() + this.kimya.commonAvarage()+ this.mat.commonAvarage()) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Matematik Sözlü Notu : " + this.mat.verbalNote);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Fizik Sözlü Notu : " + this.fizik.verbalNote);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Kimya Sözlü Notu : " + this.kimya.verbalNote);
    }
}
