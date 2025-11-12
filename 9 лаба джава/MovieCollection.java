import java.util.*;


class Movie {
    private String title;
    private int year;
    
    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
    }
    
    public String getTitle() {
        return title;
    }
    
    public int getYear() {
        return year;
    }
    
    @Override
    public String toString() {
        return "Movie{title='" + title + "', year=" + year + "}";
    }
}


class Action extends Movie {
    private String mainActor;
    
    public Action(String title, int year, String mainActor) {
        super(title, year);
        this.mainActor = mainActor;
    }
    
    public String getMainActor() {
        return mainActor;
    }
    
    @Override
    public String toString() {
        return "Action{" + super.toString() + ", mainActor='" + mainActor + "'}";
    }
}


class Drama extends Movie {
    private String director;
    
    public Drama(String title, int year, String director) {
        super(title, year);
        this.director = director;
    }
    
    public String getDirector() {
        return director;
    }
    
    @Override
    public String toString() {
        return "Drama{" + super.toString() + ", director='" + director + "'}";
    }
}


public class MovieCollection {
    public static void main(String[] args) {
      
        Map<String, Movie> movies = new HashMap<>();
        
     
        movies.put("Терминатор", new Action("Терминатор", 1984, "Арнольд Шварценеггер"));
        movies.put("Крестный отец", new Drama("Крестный отец", 1972, "Фрэнсис Форд Коппола"));
        movies.put("Матрица", new Action("Матрица", 1999, "Киану Ривз"));
        movies.put("Форрест Гамп", new Drama("Форрест Гамп", 1994, "Роберт Земекис"));
        movies.put("Безумный Макс", new Action("Безумный Макс", 2015, "Том Харди"));
        
      
        System.out.println("Все названия фильмов в коллекции:");
        for (String title : movies.keySet()) {
            System.out.println("- " + title);
        }
        
   
        System.out.println("\nПолная информация о фильмах:");
        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}