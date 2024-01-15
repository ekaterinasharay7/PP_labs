import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
 class RecordBook{
     String name;
     int id;
     int semestrStuding;
     ArrayList<Session> sessions = new ArrayList<>();
     RecordBook(){
         name="name";
         id=0;
         semestrStuding=0;

     }

     //пошли конструкторы для одного студента

     public void setName(String name) {
         this.name = name;
     }

     public String getName() {
         return name;
     }

     public void setId(int id) {
         this.id = id;
     }

     public int getId() {
         return id;
     }

     public void setSemestrStuding(int semestrStuding) {
         this.semestrStuding = semestrStuding;
     }

     public int getSemestrStuding() {
         return semestrStuding;
     }
     public void readRecordbook(Scanner in,FileReader fr ) throws Exception{
         String line = new String();
         line=in.nextLine();
         String[] words = line.split(" ");
         setName(words[0]);
         setId(Integer.parseInt(words[1]));
         setSemestrStuding(Integer.parseInt(words[2]));
         for(int i=0;i<getSemestrStuding();i++){
             Session session = new Session();
             session.readSession(in,fr);
             sessions.add(session);
         }

     }
     public void writeRecordBook(Scanner in,FileWriter fw) throws Exception{
         fw.write("Student:"+"\n");
         fw.write("Name: "+getName()+" ID: "+getId()+" on what semestr now: "+(getSemestrStuding()+1)+"\n");
         fw.write(""+"\n");
         for(int i=0;i<getSemestrStuding();i++){
             fw.write("Session number "+(i+1)+":"+"\n");
             sessions.get(i).writeSession(in,fw);
         }
     }

     class Session{
        int numSession;
        int countExams;
        ArrayList<Exam> exams = new ArrayList<>();
        Session(){
            numSession=0;
            countExams=0;
        }

     public void setCountExams(int countExams) {
         this.countExams = countExams;
     }

     public void setNumSession(int numSession) {
         this.numSession = numSession;
     }

     public int getCountExams() {
         return countExams;
     }

     public int getNumSession() {
         return numSession;
     }

     public void readSession(Scanner in, FileReader fr) throws Exception{
            String line = new String();
            line=in.nextLine();
            setCountExams(Integer.parseInt(line));
            for(int i=0;i<getCountExams();i++){
                Exam exam=new Exam();
                exam.readExam(in,fr);
                exams.add(exam);
            }
     }
     public void writeSession(Scanner in, FileWriter fw) throws Exception{
            fw.write("Session exams: "+"\n");
            for(int i=0;i<countExams;i++){
               exams.get(i).writeExam(in,fw);
            }
         fw.write(""+"\n");
     }

     class Exam{
            String subject;
            String teacher;
            int mark;
            Exam(){
                subject="subject";
                teacher="teacher";
                mark=0;
            }
            public void setSubject(String subject){
                this.subject=subject;
            }
            public String getSubject(){
                return subject;
            }

            public void setMark(int mark) {
                this.mark = mark;
            }

            public void setTeacher(String teacher) {
                this.teacher = teacher;
            }

            public String getTeacher() {
                return teacher;
            }

            public int getMark() {
                return mark;
            }

            public void readExam(Scanner in, FileReader fr) throws Exception{
            String line = new String();
            line = in.nextLine();
            String[] words = line.split(" ");
            setSubject(words[0]);
            setTeacher(words[1]);
            setMark(Integer.parseInt(words[2]));
            }
            public void writeExam(Scanner in, FileWriter fw) throws Exception{
                fw.write("Subject: "+getSubject()+" Teacher: "+getTeacher()+" Mark: "+getMark()+"\n");
            }

        }
    }

}
public class Main {
     public static  void Reader(Scanner in, FileReader fr, int numStudents, ArrayList<RecordBook> students) throws Exception{
    for(int i=0;i<numStudents;++i){
        RecordBook rb= new RecordBook();
        rb.readRecordbook(in,fr);
        students.add(rb);
        }
     }
     public static void Writer(Scanner in, FileWriter fw, int numStudents, ArrayList<RecordBook> students ) throws Exception{
         for(int i=0;i<numStudents;++i){
            students.get(i).writeRecordBook(in,fw);

         }
     }

     public static void InformationByName(Scanner in,FileWriter fw,int numStudents,ArrayList<RecordBook> students, String namePoisk ) throws Exception{
         for(int i=0;i<numStudents;++i){
             if(Objects.equals(students.get(i).getName(), namePoisk)){
                 fw.write("All information about student :"+namePoisk+"\n");
                 students.get(i).writeRecordBook(in,fw);
             }
         }
     }

    public static void InformationByID(Scanner in,FileWriter fw,int numStudents,ArrayList<RecordBook> students, Integer idPoisk ) throws Exception{
        for(int i=0;i<numStudents;++i){
            if(Objects.equals(students.get(i).getId(), idPoisk)){
                fw.write("All information about student with ID "+idPoisk+"\n");
                students.get(i).writeRecordBook(in,fw);
            }
        }
    }

    public static void Otlichniki(Scanner in, FileWriter fw,int numStudents,ArrayList<RecordBook> students, Integer sessionNum) throws Exception{
         fw.write("In session number "+sessionNum+" were such Excellent students:"+"\n");
         for(int i=0;i<numStudents;++i){
             RecordBook student = students.get(i);
             if (student.getSemestrStuding()>= sessionNum) {
                 RecordBook.Session session = student.sessions.get(sessionNum-1);
                 boolean ExcellentStudent = true;
                 for (int j = 0; j < session.getCountExams(); j++){
                     if (session.exams.get(j).getMark() < 8){
                         ExcellentStudent = false;
                         break;
                     }
                 }
                if(ExcellentStudent){
                    fw.write(student.getName()+"\n");
                }

             }
         }
    }

    public static void main(String[] args) throws Exception{
        FileReader fr =new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt");
        Scanner in = new Scanner(fr);
        //Exam exam = new Exam();
        //exam.readExam(in,fr);
        //exam.writeExam(in,fw);
        //Session session = new Session();
        //session.readSession(in,fr);
        //session.writeSession(in,fw);
        //RecordBook rb= new RecordBook();
        //rb.readRecordbook(in,fr);
        //rb.writeRecordBook(in,fw);
        int numStudents = Integer.parseInt(in.nextLine());
        ArrayList<RecordBook> students = new ArrayList<>(numStudents);
        Reader(in,fr,numStudents,students);
        Writer(in,fw,numStudents,students);
        String poiskName = new String(in.nextLine());
        InformationByName(in,fw,numStudents,students,poiskName);
        Integer poiskId = Integer.parseInt(in.nextLine());
        InformationByID(in,fw,numStudents,students,poiskId);
        Integer sessionNum = Integer.parseInt(in.nextLine());
        Otlichniki(in,fw,numStudents,students,sessionNum);
        fr.close();
        fw.close();

    }
}