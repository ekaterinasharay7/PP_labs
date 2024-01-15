import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class Hotel{
    String City;
    String Name;
    int Stars;
    Hotel(){
        City="city";
        Name="name";
        Stars=0;
    }
    Hotel(String City,String Name,int Stars){
        this.City=City;
        this.Name=Name;
        this.Stars=Stars;
    }

    public void setCity(String city) {
        City = city;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setStars(int stars) {
        Stars = stars;
    }
    public String getCity(){
        return City;
    }

    public String getName() {
        return Name;
    }

    public int getStars() {
        return Stars;
    }
    public void hotelReader(Scanner in,FileReader fr ) throws Exception{
        String line = new String();
        line=in.nextLine();
        String[] razdel = line.split(" ");
        setCity(razdel[0]);
        setName(razdel[1]);
        setStars(Integer.parseInt(razdel[2]));
    }

    public void hotelWriter(Scanner in, FileWriter fw) throws Exception{
        fw.write("City: "+getCity()+" Name of Hotel: "+getName()+" Count of stars: "+getStars()+"\n");
    }
    public void cityWriter(Scanner in, FileWriter fw) throws Exception{
        fw.write("City: "+getCity()+"\n");
    }
    public void nameWriter(Scanner in, FileWriter fw ) throws Exception{
        fw.write("Name of Hotel: "+getName()+"\n");
    }
    public void starsWriter(Scanner in, FileWriter fw) throws Exception{
        fw.write("Count of stars: "+getStars()+"\n");
    }
}
//теперь нужно написать два кампоратора
class compCities implements Comparator<Hotel>{
    public int compare(Hotel one, Hotel two){
        return one.getCity().compareTo(two.getCity());
    }
}
class compStars implements Comparator<Hotel>{
    public int compare(Hotel one, Hotel two){
        if(one.getStars()<two.getStars()){
            return 1;
        }
        else if (one.getStars()>two.getStars()){
            return -1;
        }
        else {
            return 0;
        }
    }
}


public class Main {
    public static void ReadAllHotels(Scanner in, FileReader fr, int countHotels, ArrayList<Hotel> hotels ) throws Exception{
        for(int i=0;i<countHotels;i++){
            Hotel buf= new Hotel();
            buf.hotelReader(in,fr);
            hotels.add(buf);
        }
    }
    public static void WriteAllHotels(Scanner in,FileWriter fw,int countHotels,ArrayList<Hotel> hotels) throws Exception{
        for(int i=0;i<countHotels;i++){
            hotels.get(i).hotelWriter(in,fw);
        }
    }
    public static void infAboutCityHotels(Scanner in,FileWriter fw, int countHotels, ArrayList<Hotel>hotels,String nameOfCity) throws Exception{
        fw.write("In  city "+nameOfCity+" you can find theese hotels:"+"\n");
        for(int i=0;i<countHotels;i++){
            if(Objects.equals(hotels.get(i).getCity(), nameOfCity)){
                hotels.get(i).nameWriter(in,fw);
                hotels.get(i).starsWriter(in,fw);
            }
        }
    }
    public static void infHotelInWhatCities(Scanner in,FileWriter fw,int countHotels,ArrayList<Hotel> hotels,String nameOfHotel) throws Exception{
        fw.write("Hotel "+nameOfHotel+" can be found in theese cities:"+"\n");
        for(int i=0;i<countHotels;i++){
            if (Objects.equals(hotels.get(i).getName(), nameOfHotel)) {
                hotels.get(i).cityWriter(in,fw);
            }
        }
    }
    public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("input.txt");
    FileWriter fw = new FileWriter("output.txt");
    Scanner in = new Scanner(fr);
    String line = new String();
    line=in.nextLine();
    int countHotels;
    countHotels=Integer.parseInt(line);
    ArrayList<Hotel> test = new ArrayList<>();
    ReadAllHotels(in,fr,countHotels,test);
    Collections.sort(test, new compCities().thenComparing(new compStars()));
    WriteAllHotels(in,fw,countHotels,test);
    String poiskCityHotels=new String();
    poiskCityHotels=in.nextLine();
    infAboutCityHotels(in,fw,countHotels,test,poiskCityHotels);
    String poiskHotel=new String();
    poiskHotel=in.nextLine();
    infHotelInWhatCities(in,fw,countHotels,test,poiskHotel);
    fr.close();
    fw.close();
    }
}