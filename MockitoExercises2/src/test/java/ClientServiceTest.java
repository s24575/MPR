import car.Car;
import client.Client;
import client.ClientRepository;
import client.ClientService;
import exception.ClientAlreadyInactiveException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @Mock
    Car car;

    @Mock
    ClientRepository clientRepository;

    @Test
    public void disableClientAccountTest(){
        String client_id = "1";
        Client client = new Client(client_id, true, car);
        Mockito.when(clientRepository.findClient(client_id)).thenReturn(client);
        ClientService clientService = new ClientService(clientRepository);
        clientService.disableClientAccount(client_id);
        Assert.assertFalse(client.isActive());
    }

    @Test(expected = RuntimeException.class)
    public void disableClientAccountTestNull(){
        ClientService clientService = new ClientService(clientRepository);
        String not_in_repo = "1";
        Mockito.when(clientRepository.findClient(not_in_repo)).thenReturn(null);
        clientService.disableClientAccount(not_in_repo);
    }

    @Test(expected = RuntimeException.class)
    public void disableClientAccountTestNotActiveClient(){
        String client_id = "1";
        Client client = new Client(client_id, false, car);
        Mockito.when(clientRepository.findClient(client_id)).thenReturn(client);
        ClientService clientService = new ClientService(clientRepository);
        clientService.disableClientAccount(client_id);
    }

    // other method
    @Test
    public void createNewClientTest(){
        String client_id = "1";
        Mockito.when(clientRepository.findClient(client_id)).thenReturn(null);
        ClientService clientService = new ClientService(clientRepository);
        clientService.createNewClient(client_id);
        Client client = new Client();
        client.setId(client_id);
        client.setActive(true);
        Client client1 = clientService.createNewClient(client_id);
        Assert.assertEquals(client.getId(), client1.getId());
        Assert.assertEquals(client.isActive(), client1.isActive());
    }

    @Test(expected = RuntimeException.class)
    public void createNewClientTestNotNull(){
        String client_id = "1";
        Client client = new Client(client_id, false, car);
        Mockito.when(clientRepository.findClient(client_id)).thenReturn(client);
        ClientService clientService = new ClientService(clientRepository);
        clientService.createNewClient(client_id);
    }
}
