public class CountryNotFoundException extends RuntimeException{
    private final String name;

    public CountryNotFoundException(String name) {
        super("country not found"+ name);
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
