package codebusters.smarttradebackend.BusinessLogic.Service.ShoppingCart;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ShoppingCartCommand;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutor {

    public void executeCommand(ShoppingCartCommand command) {
        command.execute();
    }
}
