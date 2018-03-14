package ch.theforce;

public class PersonService implements IPersonService {

    private String name;
    private String firstName;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getFullName() {
        return String.format("{name} {firstName}", this.getName(), this.getFirstName());
    }
}
