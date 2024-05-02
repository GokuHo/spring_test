package demon.service;

import java.io.IOException;

public interface UserService {
    void transfer(int fromId, int toId, double money);
    void setBalance();
    void isolationTest();
    void timeoutTest();
    void readonlyTest();
    void rollbackforTest() throws IOException;
    void noRollbackforTest() throws IOException;
}
