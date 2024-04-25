import java.io.*;
import java.time.LocalDate;
import java.util.*;

public abstract class Country {
    private final String name;
    private static String path;
    private static String path2;
    public void setFiles(String file, String file2) throws FileNotFoundException {
//        try {
//            BufferedReader reader=new BufferedReader(new FileReader(path));
//            BufferedReader reader2=new BufferedReader(new FileReader(path2));
//            path=file;
//            path2=file2;
//        }catch (IOException e){
//            throw new FileNotFoundException();
//        }
        File afile=new File(file);
        File bfile=new File(file2);
        if(!afile.exists()){
            throw new FileNotFoundException(file);
        }
        if(!bfile.exists()){
            throw new FileNotFoundException(file2);
        }
        path=file;
        path2=file2;

    }
    public static Country fromCsv(String country) throws CountryNotFoundException, IOException {
        BufferedReader reader=new BufferedReader(new FileReader(path));
        BufferedReader reader2=new BufferedReader(new FileReader(path2));
        String line = reader.readLine();
        Scanner scanner = new Scanner(path);
        scanner.nextLine();
        Scanner scanner2 = new Scanner(path2);
        scanner2.nextLine();
        CountryColumns countryColumns = CountryColumns.getCountryColumns(line, country);
        line = reader.readLine();
        String[] field = scanner.nextLine().split(";");
        String[] field2 = scanner2.nextLine().split(";");
        LocalDate a;
        int b, c;
        if(field[countryColumns.firstColumnIndex].equals("nan")){
            CountryWithoutProvinces withoutProvinces = new CountryWithoutProvinces(country);
            while(scanner.hasNext()) {
                a= LocalDate.parse((field[0]));
                b= Integer.parseInt(field[countryColumns.firstColumnIndex]);
                c= Integer.parseInt(field2[countryColumns.firstColumnIndex]);
                withoutProvinces.addDateStatistic(a, b, c);
                scanner.nextLine();
            }
        }
        return new CountryWithProvinces(country);
    }
    public static Country[] fromCsv(String[] strings){
        Country[] countries=new Country[strings.length];
        try {
            for (int i = 0; i<strings.length; i++) {
                countries[i]=fromCsv(strings[i]);
            }
            return countries;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Integer getDeaths(LocalDate date){
        Integer bla=0;
        for (Integer ints:CountryWithProvinces.deaths){
            bla+=ints;
        }
        return bla;
    }
    public Integer getInfections(LocalDate date){
        Integer bel=0;
        for (Integer infect:CountryWithProvinces.infections){
            bel+=infect;
        }
        return bel;
    }
    public int getDeathsBetween(LocalDate a, LocalDate b){
        Integer f=0;
        for (int i = 0; !a.plusDays(i).isEqual(b); i++) {
            f+= CountryWithProvinces.deaths.get(i);
        }
        return f;
    }
    public static void sortByDeaths(Country[] countries, LocalDate start, LocalDate end){
        Arrays.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o2.getDeathsBetween(start, end)- o1.getDeathsBetween(start, end);
            }
        });

    }
    public void saveDataToFile(String sciezka) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(sciezka));
        writer.write("data, przypdaki, zgony");
        for (Country country:CountryWithProvinces.countries){
            for (LocalDate date: CountryWithProvinces.date){
                String h= String.valueOf(date);
                writer.write(h);
                writer.write(String.format("\t%d\t%d\t"), country.getInfections(date), country.getDeaths(date));
            }
        }
    }
    public String getName() {
        return name;
    }

    public Country(String name) {
        this.name = name;
    }
    private static class CountryColumns{
        public final int firstColumnIndex, columnCount;

        public CountryColumns(int firstColumnIndex, int columnCount) {
            this.firstColumnIndex = firstColumnIndex;
            this.columnCount = columnCount;
        }
        private static CountryColumns getCountryColumns(String line, String country){
            String[] field=line.split(";");
            int i=0;
            while (!field[i].equals(country)){
                i++;
            }
            int j=0;
            while (!field[j].isEmpty()){
                j++;
            }
            return new CountryColumns(j, i);
        }
    }
}

