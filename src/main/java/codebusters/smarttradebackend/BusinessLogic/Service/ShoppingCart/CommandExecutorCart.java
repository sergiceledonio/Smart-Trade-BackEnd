package codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ICommand;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutorCart {

    public int executeCommand(ICommand command) {
        return command.execute();
    }
}
