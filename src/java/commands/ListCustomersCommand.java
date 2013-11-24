package commands;

import dto.CustomerDTO;
import servlets.Factory;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;


public class ListCustomersCommand extends TargetCommand {

    public ListCustomersCommand(String target) {
        super(target);
    }

    @Override
    public String execute(HttpServletRequest request) {
        Collection<CustomerDTO> custs = Factory.getInstance().getBankManager().getCustomers();
        request.setAttribute("customers", custs);
        return super.execute(request);
    }
}
