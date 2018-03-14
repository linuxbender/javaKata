package ch.theforce;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ServiceAdapterTest {

    private IPersonService personServiceMock;
    private ServiceAdapter serviceAdapter;

    @BeforeEach
    void init() {
        this.personServiceMock = mock(IPersonService.class);
    }

    @AfterEach
    void tearDown() {
        this.serviceAdapter = null;
    }

    @Test
    @DisplayName("Create ServiceAdapter without error")
    void createServiceAdapterWithoutError() {
        this.serviceAdapter = new ServiceAdapter(this.personServiceMock);
    }

    @Test
    void WhenFullNameIsCalledThenShouldBeTheName() {

        when(this.personServiceMock.getName()).thenReturn(" ");
        when(this.personServiceMock.getFirstName()).thenReturn(" ");

        this.serviceAdapter = new ServiceAdapter(this.personServiceMock);

        boolean testee = this.serviceAdapter.isFullNameValid();

        assertTrue(testee);
    }

    @Test
    void GetFullNameWhenNameIsValid() {
        ServiceAdapter serviceAdapter = new ServiceAdapter(this.personServiceMock);
        when(this.personServiceMock.getFullName()).thenReturn("Foo Baa");

        ServiceAdapter serviceAdapterSpy = spy(serviceAdapter);
        doReturn(true).when(serviceAdapterSpy).isFullNameValid();

        assertEquals(serviceAdapterSpy.getFullName(), "Foo Baa");
    }

    @Test
    @DisplayName("Get empty name when name is not valid 😱")
    void GetEmptyNameWhenNameIsNotValid() {
        ServiceAdapter serviceAdapter = new ServiceAdapter(this.personServiceMock);
        when(this.personServiceMock.getFullName()).thenReturn("Foo Baa");

        ServiceAdapter serviceAdapterSpy = spy(serviceAdapter);
        doReturn(false).when(serviceAdapterSpy).isFullNameValid();

        assertEquals(serviceAdapterSpy.getFullName(), "😱");
    }
}
