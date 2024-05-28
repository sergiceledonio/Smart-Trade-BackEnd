package codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ShoppingCartCommand;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutor {

    public int executeCommand(ShoppingCartCommand command) {
        return command.execute();
    }
}
