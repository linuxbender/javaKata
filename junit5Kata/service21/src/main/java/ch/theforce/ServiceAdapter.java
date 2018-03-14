package ch.theforce;

public class ServiceAdapter implements IServiceAdapter {
    private IPersonService personService;

    public ServiceAdapter(IPersonService personService) {
        if (personService == null) {
            throw new NullPointerException("ServiceAdapter null pointer for IPersonService");
        }
        this.personService = personService;
    }

    @Override
    public boolean isFullNameValid() {
        return !this.personService.getName().isEmpty() && !this.personService.getFirstName().isEmpty();
    }

    @Override
    public String getFullName() {
        return this.isFullNameValid() ? this.personService.getFullName() : "😱";
    }
}
