package codebusters.smarttradebackend.BusinessLogic.Service.WishList;

import codebusters.smarttradebackend.BusinessLogic.IntService.Command.ICommand;
import org.springframework.stereotype.Service;

@Service
public class CommandExecutorWish {

    public int executeCommand(ICommand command){
        return command.execute();
    }
}
